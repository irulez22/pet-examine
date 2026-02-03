package com.petexamine;

import com.google.inject.Inject;
import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.events.MenuOpened;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.hiscore.HiscoreClient;
import net.runelite.client.hiscore.HiscoreEndpoint;
import net.runelite.client.hiscore.HiscoreResult;
import net.runelite.client.hiscore.HiscoreSkill;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
@Slf4j
@PluginDescriptor(
        name = "Pet Examine",
        description = "Adds examine options to player pets showing KC or XP",
        tags = {"pet", "examine", "kc", "xp"}
)
public class PetExaminePlugin extends Plugin
{
    @Inject
    private ClientThread clientThread;
    @Inject private Client client;
    @Inject private HiscoreClient hiscoreClient;

    @Inject
    private PetExamineConfig config;

    @Provides
    PetExamineConfig provideConfig(ConfigManager configManager)
    {
        return configManager.getConfig(PetExamineConfig.class);
    }

    private final Map<String, HiscoreResult> hiscoreCache = new HashMap<>();

    private Polygon getTileClickbox(NPC npc)
    {
        LocalPoint lp = npc.getLocalLocation();
        if (lp == null)
            return null;

        // 1x1 tile square
        return Perspective.getCanvasTilePoly(
                client,
                lp
        );
    }
    private NPC getHoveredPet()
    {
        Point mouse = client.getMouseCanvasPosition();
        if (mouse == null)
        {
            return null;
        }

        for (NPC npc : client.getNpcs())
        {
            if (!PetRegistry.isPet(npc.getId()))
                continue;

            Polygon poly = getTileClickbox(npc);
            if (poly != null && poly.contains(mouse.getX(), mouse.getY()))
            {
                return npc;
            }
        }
        return null;
    }

    @Subscribe
    public void onMenuOpened(MenuOpened event)
    {
        NPC pet = getHoveredPet();
        if (pet == null)
            return;

        // Don't add menu options on local pets
        if (pet.getInteracting() == client.getLocalPlayer())
            return;

        String target;

        if (config.showOwnerInMenu())
        {
            Player owner = getPetOwner(pet);
            if (owner != null)
            {
                String ownerName = Text.removeTags(owner.getName());
                target = "<col=ffff00>" + ownerName + "'s " + pet.getName() + "</col>";
            }
            else
            {
                // No username
                target = "<col=ffff00>" + pet.getName() + "</col>";
            }
        }
        else
        {
            target = "<col=ffff00>" + pet.getName() + "</col>";
        }

        client.createMenuEntry(1) // Set to 1 as having it above "walk here" looks horrid
                .setOption("Examine")
                .setTarget(target)
                .setType(MenuAction.RUNELITE)
                .onClick(e -> handlePetExamine(pet))
                .setDeprioritized(true);
    }


    private void handlePetExamine(NPC pet)
    {
        PetData data = PetRegistry.get(pet.getId());
        if (data == null)
        {
            return;
        }

        Player owner = getPetOwner(pet);
        if (owner == null)
        {
            clientThread.invokeLater(() ->
            {
                Player retryOwner = getPetOwner(pet);
                if (retryOwner == null)
                {
                    post("Unable to determine pet owner, try moving closer.");
                    return;
                }

                handlePetExamine(pet);
            });
            return;
        }


        String name = Text.removeTags(owner.getName());

        if (data.type == PetType.SKILL_XP)
        {

            if (owner == client.getLocalPlayer())
            {
                long xp = client.getSkillExperience(data.skill);
                post(name + " has " + format(xp) + " XP in " + data.skill.getName() + ".");
            }
            else
            {
                lookupSkillXp(name, data.skill);
            }
        }
        else
        {
            lookupBossKC(name, data.boss);
        }
    }


    private void lookupBossKC(String name, HiscoreSkill boss)
    {
        HiscoreResult cached = hiscoreCache.get(name);
        if (cached != null)
        {
            showBossKC(name, cached, boss);
            return;
        }

        HiscoreEndpoint endpoint =
                HiscoreEndpoint.fromWorldTypes(client.getWorldType());

        hiscoreClient.lookupAsync(name, endpoint)
                .whenCompleteAsync((result, ex) ->
                {
                    clientThread.invokeLater(() ->
                    {
                        if (result == null || ex != null)
                        {
                            post(name + "'s killcount is unavailable.");
                            return;
                        }

                        hiscoreCache.put(name, result);
                        showBossKC(name, result, boss);
                    });
                });
    }

    private void showBossKC(String name, HiscoreResult result, HiscoreSkill boss)
    {
        // Chaos Ele pet has 2 sources
        if (boss == HiscoreSkill.CHAOS_ELEMENTAL)
        {
            net.runelite.client.hiscore.Skill elemental =
                    result.getSkill(HiscoreSkill.CHAOS_ELEMENTAL);
            net.runelite.client.hiscore.Skill fanatic =
                    result.getSkill(HiscoreSkill.CHAOS_FANATIC);

            boolean hasElemental = elemental != null && elemental.getLevel() >= 0;
            boolean hasFanatic   = fanatic != null && fanatic.getLevel() >= 0;

            if (!hasElemental && !hasFanatic)
            {
                post(name + " is unranked for Chaos Elemental.");
                return;
            }

            StringBuilder msg = new StringBuilder(name + " has defeated ");

            if (hasElemental)
            {
                msg.append("Chaos Elemental ")
                        .append(elemental.getLevel())
                        .append(" times");
            }

            if (hasFanatic)
            {
                if (hasElemental)
                    msg.append(" and ");

                msg.append("Chaos Fanatic ")
                        .append(fanatic.getLevel())
                        .append(" times");
            }

            msg.append(".");

            post(msg.toString());
            return;
        }

        // Nightmare pet has 2 sources
        if (boss == HiscoreSkill.NIGHTMARE)
        {
            net.runelite.client.hiscore.Skill nightmare =
                    result.getSkill(HiscoreSkill.NIGHTMARE);
            net.runelite.client.hiscore.Skill phosani =
                    result.getSkill(HiscoreSkill.PHOSANIS_NIGHTMARE);

            boolean hasNightmare = nightmare != null && nightmare.getLevel() >= 0;
            boolean hasPhosani   = phosani != null && phosani.getLevel() >= 0;

            if (!hasNightmare && !hasPhosani)
            {
                post(name + " is unranked for the Nightmare.");
                return;
            }

            StringBuilder msg = new StringBuilder(name + " has defeated ");

            if (hasNightmare)
            {
                msg.append("The Nightmare ")
                        .append(nightmare.getLevel())
                        .append(" times");
            }

            if (hasPhosani)
            {
                if (hasNightmare)
                    msg.append(" and ");

                msg.append("Phosani's Nightmare ")
                        .append(phosani.getLevel())
                        .append(" times");
            }

            msg.append(".");

            post(msg.toString());
            return;
        }

        // Default
        net.runelite.client.hiscore.Skill s = result.getSkill(boss);
        if (s == null || s.getLevel() < 0)
        {
            post(name + " is unranked for " + boss.getName() + ".");
            return;
        }

        int count = s.getLevel();

        switch (boss)
        {
            case CLUE_SCROLL_MASTER:
                post(name + " has completed " + count + " master clue scrolls.");
                break;

            case SOUL_WARS_ZEAL:
                post(name + " has earned " + count + " Soul Wars zeal.");
                break;

            case RIFTS_CLOSED:
                post(name + " has closed " + count + " rifts.");
                break;

            default:
                post(name + " has defeated " + boss.getName() + " " + count + " times.");
                break;
        }
    }



    private void lookupSkillXp(String name, Skill skill)
    {
        HiscoreResult cached = hiscoreCache.get(name);
        if (cached != null)
        {
            showSkillXp(name, cached, skill);
            return;
        }

        HiscoreEndpoint endpoint =
                HiscoreEndpoint.fromWorldTypes(client.getWorldType());

        hiscoreClient.lookupAsync(name, endpoint)
                .whenCompleteAsync((result, ex) ->
                {
                    clientThread.invokeLater(() ->
                    {
                        if (result == null || ex != null)
                        {
                            post(name + "'s XP is unavailable.");
                            return;
                        }

                        hiscoreCache.put(name, result);
                        showSkillXp(name, result, skill);
                    });
                });
    }

    private void showSkillXp(String name, HiscoreResult result, Skill skill)
    {
        HiscoreSkill hs = HiscoreSkill.valueOf(skill.name());
        net.runelite.client.hiscore.Skill s = result.getSkill(hs);

        if (s == null || s.getExperience() < 0)
        {
            post(name + " is unranked in " + skill.getName() + ".");
            return;
        }

        post(name + " has " + format(s.getExperience()) + " XP in " + skill.getName() + ".");
    }

    private Player getPetOwner(NPC pet)
    {
        Actor a = pet.getInteracting();
        if (a == null)
        {
            return null;
        }

        if (!(a instanceof Player))
        {
            return null;
        }

        return (Player) a;
    }


    private void post(String msg)
    {
        client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", msg, null);
    }

    private static String format(long v)
    {
        return String.format("%,d", v);
    }
}
