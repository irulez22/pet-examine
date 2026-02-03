package com.petexamine;

import net.runelite.api.Skill;
import net.runelite.client.hiscore.HiscoreSkill;

import java.util.Map;

final class PetRegistry
{
    private PetRegistry() {} // no instances

    static final Map<Integer, PetData> PET_DATA = Map.ofEntries(
            Map.entry(11429, PetData.boss(HiscoreSkill.RIFTS_CLOSED)), // abyssal_pet
            Map.entry(5884, PetData.boss(HiscoreSkill.ABYSSAL_SIRE)), // abyssalsire_pet
            Map.entry(14046, PetData.boss(HiscoreSkill.AMOXLIATL)), // amoxliatl_pet
            Map.entry(13683, PetData.boss(HiscoreSkill.ARAXXOR)), // araxxor_pet
            Map.entry(13684, PetData.boss(HiscoreSkill.ARAXXOR)), // araxxor_pet_cute
            Map.entry(13678, PetData.boss(HiscoreSkill.ARAXXOR)), // araxxor_pet_easter_egg
            Map.entry(6631, PetData.boss(HiscoreSkill.KREEARRA)), // armadyl_pet
            Map.entry(6632, PetData.boss(HiscoreSkill.GENERAL_GRAARDOR)), // bandos_pet
            Map.entry(7232, PetData.boss(HiscoreSkill.CLUE_SCROLL_MASTER)), // bloodhoundpet
            Map.entry(5558, PetData.boss(HiscoreSkill.CALLISTO)), // callistopet
            Map.entry(11986, PetData.boss(HiscoreSkill.CALLISTO)), // callistopet_legacy
            Map.entry(2055, PetData.boss(HiscoreSkill.CHAOS_ELEMENTAL)), // chaos_elemental_pet  can also get from chaos fanatic
            //Map.entry(4002, ), // chompy_bird_pet  cannot track chompy kills
            Map.entry(318, PetData.boss(HiscoreSkill.CORPOREAL_BEAST)), // core_pet
            Map.entry(8010, PetData.boss(HiscoreSkill.CORPOREAL_BEAST)), // corp_pet
            Map.entry(7892, PetData.boss(HiscoreSkill.GROTESQUE_GUARDIANS)), // dawn_pet
            Map.entry(8201, PetData.boss(HiscoreSkill.CHAMBERS_OF_XERIC_CHALLENGE_MODE)), // dogadile_pet puppadile pet return challenge mode kc
            Map.entry(14785, PetData.boss(HiscoreSkill.DOOM_OF_MOKHAIOTL)), // dom_pet
            Map.entry(12159, PetData.boss(HiscoreSkill.DUKE_SUCELLUS)), // duke_sucellus_pet
            Map.entry(7893, PetData.boss(HiscoreSkill.GROTESQUE_GUARDIANS)), // dusk_pet
            Map.entry(8737, PetData.boss(HiscoreSkill.THE_GAUNTLET)), // gauntlet_pet regular version
            Map.entry(8738, PetData.boss(HiscoreSkill.THE_CORRUPTED_GAUNTLET)), // gauntlet_pet_corrupt return corrupted version
            Map.entry(14931, PetData.boss(HiscoreSkill.SHELLBANE_GRYPHON)), // gryphonboss_pet
            Map.entry(14932, PetData.boss(HiscoreSkill.SHELLBANE_GRYPHON)), // gryphonboss_pet_adult
            Map.entry(3099, PetData.boss(HiscoreSkill.CERBERUS)), // hellpet
            //Map.entry(7760, , // herbiboar_pet  cannot be tracked
            Map.entry(14045, PetData.boss(HiscoreSkill.THE_HUEYCOATL)), // huey_pet
            Map.entry(8492, PetData.boss(HiscoreSkill.ALCHEMICAL_HYDRA)), // hydra_pet
            Map.entry(8493, PetData.boss(HiscoreSkill.ALCHEMICAL_HYDRA)), // hydra_pet_electric
            Map.entry(8495, PetData.boss(HiscoreSkill.ALCHEMICAL_HYDRA)), // hydra_pet_extinguished
            Map.entry(8494, PetData.boss(HiscoreSkill.ALCHEMICAL_HYDRA)), // hydra_pet_fire
            Map.entry(7675, PetData.boss(HiscoreSkill.TZKAL_ZUK)), // inferno_pet
            Map.entry(5893, PetData.boss(HiscoreSkill.TZTOK_JAD)), // jadpet
            Map.entry(10625, PetData.boss(HiscoreSkill.TZTOK_JAD)), // jadpet_inferno  return jad kc i guess
            Map.entry(6636, PetData.boss(HiscoreSkill.KING_BLACK_DRAGON)), // kbd_pet
            Map.entry(6637, PetData.boss(HiscoreSkill.KALPHITE_QUEEN)), // kq_pet_flying
            Map.entry(6638, PetData.boss(HiscoreSkill.KALPHITE_QUEEN)), // kq_pet_walking
            Map.entry(6640, PetData.boss(HiscoreSkill.KRAKEN)), // kraken_pet
            Map.entry(12160, PetData.boss(HiscoreSkill.THE_LEVIATHAN)), // leviathan_pet
            Map.entry(6635, PetData.boss(HiscoreSkill.GIANT_MOLE)), // mole_pet
            Map.entry(10651, PetData.boss(HiscoreSkill.GIANT_MOLE)), // mole_pet_naked.. kinky
            Map.entry(12014, PetData.boss(HiscoreSkill.PHANTOM_MUSPAH)), // muspah_pet
            Map.entry(12015, PetData.boss(HiscoreSkill.PHANTOM_MUSPAH)), // muspah_pet_melee
            Map.entry(12016, PetData.boss(HiscoreSkill.PHANTOM_MUSPAH)), // muspah_pet_shielded
            Map.entry(11277, PetData.boss(HiscoreSkill.NEX)), // nex_pet
            Map.entry(9399, PetData.boss(HiscoreSkill.NIGHTMARE)), // nightmare_pet return both kcs
            Map.entry(8541, PetData.boss(HiscoreSkill.NIGHTMARE)), // nightmare_pet_parasite return both kcs
            //Map.entry(6674, ), // penance_pet cannot be tracked
            Map.entry(7370, PetData.boss(HiscoreSkill.WINTERTODT)), // phoenix_pet
            Map.entry(3082, PetData.boss(HiscoreSkill.WINTERTODT)), // phoenix_pet_blue
            Map.entry(3081, PetData.boss(HiscoreSkill.WINTERTODT)), // phoenix_pet_green
            Map.entry(3084, PetData.boss(HiscoreSkill.WINTERTODT)), // phoenix_pet_purple
            Map.entry(3083, PetData.boss(HiscoreSkill.WINTERTODT)), // phoenix_pet_white
            Map.entry(6629, PetData.boss(HiscoreSkill.DAGANNOTH_PRIME)), // prime_pet
            //Map.entry(12858, ), // quetzal_pet cannot be tracked
            Map.entry(7520, PetData.boss(HiscoreSkill.CHAMBERS_OF_XERIC)), // raids_olm_pet
            Map.entry(6630, PetData.boss(HiscoreSkill.DAGANNOTH_REX)), // rex_pet
            Map.entry(12593, PetData.boss(HiscoreSkill.THE_ROYAL_TITANS)), // rtbranda_pet
            Map.entry(12595, PetData.boss(HiscoreSkill.THE_ROYAL_TITANS)), // rteldric_pet
            Map.entry(2144, PetData.boss(HiscoreSkill.SARACHNIS)), // sarachnispet
            Map.entry(11160, PetData.boss(HiscoreSkill.SARACHNIS)), // sarachnispet_blue
            Map.entry(11159, PetData.boss(HiscoreSkill.SARACHNIS)), // sarachnispet_orange
            Map.entry(6633, PetData.boss(HiscoreSkill.COMMANDER_ZILYANA)), // saradomin_pet
            Map.entry(5561, PetData.boss(HiscoreSkill.SCORPIA)), // scorpiapet
            Map.entry(7616, PetData.boss(HiscoreSkill.SCURRIUS)), // scurrius_pet
            Map.entry(7351, PetData.skill(Skill.AGILITY)), // skillpet_agility
            Map.entry(14044, PetData.skill(Skill.AGILITY)), // skillpet_agility_bone
            Map.entry(9637, PetData.skill(Skill.AGILITY)), // skillpet_agility_dark
            Map.entry(7352, PetData.skill(Skill.FARMING)), // skillpet_farming
            Map.entry(9497, PetData.skill(Skill.FARMING)), // skillpet_farming_crystal
            Map.entry(9498, PetData.skill(Skill.FARMING)), // skillpet_farming_dragon
            Map.entry(9499, PetData.skill(Skill.FARMING)), // skillpet_farming_herb
            Map.entry(9500, PetData.skill(Skill.FARMING)), // skillpet_farming_lily
            Map.entry(9501, PetData.skill(Skill.FARMING)), // skillpet_farming_redwood
            Map.entry(6722, PetData.skill(Skill.FISHING)), // skillpet_fish
            Map.entry(10636, PetData.boss(HiscoreSkill.TEMPOROSS)), // skillpet_fish_tempoross return tempoross kc
            Map.entry(6758, PetData.skill(Skill.HUNTER)), // skillpet_hunter_black
            Map.entry(6759, PetData.skill(Skill.HUNTER)), // skillpet_hunter_gold
            Map.entry(6757, PetData.skill(Skill.HUNTER)), // skillpet_hunter_grey
            Map.entry(6756, PetData.skill(Skill.HUNTER)), // skillpet_hunter_red
            Map.entry(7647, PetData.skill(Skill.MINING)), // skillpet_mining_adamantite
            Map.entry(7711, PetData.skill(Skill.MINING)), // skillpet_mining_amethyst
            Map.entry(7455, PetData.skill(Skill.MINING)), // skillpet_mining_blurite
            Map.entry(7643, PetData.skill(Skill.MINING)), // skillpet_mining_coal
            Map.entry(7453, PetData.skill(Skill.MINING)), // skillpet_mining_copper
            Map.entry(7741, PetData.skill(Skill.MINING)), // skillpet_mining_daeyalt
            Map.entry(7451, PetData.skill(Skill.MINING)), // skillpet_mining_default
            Map.entry(7740, PetData.skill(Skill.MINING)), // skillpet_mining_elemental
            Map.entry(7644, PetData.skill(Skill.MINING)), // skillpet_mining_gold
            Map.entry(7646, PetData.skill(Skill.MINING)), // skillpet_mining_granite
            Map.entry(7454, PetData.skill(Skill.MINING)), // skillpet_mining_iron
            Map.entry(14923, PetData.skill(Skill.MINING)), // skillpet_mining_lead
            Map.entry(7739, PetData.skill(Skill.MINING)), // skillpet_mining_lovakite
            Map.entry(7645, PetData.skill(Skill.MINING)), // skillpet_mining_mithril
            Map.entry(14925, PetData.skill(Skill.MINING)), // skillpet_mining_nickel
            Map.entry(14924, PetData.skill(Skill.MINING)), // skillpet_mining_rubium
            Map.entry(7648, PetData.skill(Skill.MINING)), // skillpet_mining_runite
            Map.entry(7642, PetData.skill(Skill.MINING)), // skillpet_mining_silver
            Map.entry(7452, PetData.skill(Skill.MINING)), // skillpet_mining_tin
            Map.entry(7355, PetData.skill(Skill.HUNTER)), // skillpet_runecrafting_air
            Map.entry(7366, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_astral
            Map.entry(7367, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_blood
            Map.entry(7359, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_body
            Map.entry(7361, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_chaos
            Map.entry(7360, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_cosmic
            Map.entry(7364, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_death
            Map.entry(7358, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_earth
            Map.entry(7354, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_fire
            Map.entry(11428, PetData.boss(HiscoreSkill.RIFTS_CLOSED)), // skillpet_runecrafting_gotr
            Map.entry(7363, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_law
            Map.entry(7356, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_mind
            Map.entry(7362, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_nature
            Map.entry(7365, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_soul
            Map.entry(7357, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_water
            Map.entry(8028, PetData.skill(Skill.RUNECRAFT)), // skillpet_runecrafting_wrath
            Map.entry(14930, PetData.skill(Skill.SAILING)), // skillpet_sailing
            Map.entry(7353, PetData.skill(Skill.THIEVING)), // skillpet_thieving
            Map.entry(9852, PetData.skill(Skill.THIEVING)), // skillpet_thieving_panda
            Map.entry(9853, PetData.skill(Skill.THIEVING)), // skillpet_thieving_tanuki
            Map.entry(12190, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_arctic
            Map.entry(14926, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_camphor
            Map.entry(12550, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_fox
            Map.entry(14927, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_ironwood
            Map.entry(14928, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_jatoba
            Map.entry(12186, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_magic
            Map.entry(12189, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_mahogany
            Map.entry(12184, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_maple
            Map.entry(12182, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_oak
            Map.entry(12549, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_pheasant
            Map.entry(12187, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_redwood
            Map.entry(14929, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_rosewood
            Map.entry(12188, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_teak
            Map.entry(12183, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_willow
            Map.entry(12185, PetData.skill(Skill.WOODCUTTING)), // skillpet_wc_yew
            Map.entry(12181, PetData.skill(Skill.WOODCUTTING)), // skillpetwc
            Map.entry(7671, PetData.boss(HiscoreSkill.SKOTIZO)), // skotizo_pet
            Map.entry(6639, PetData.boss(HiscoreSkill.THERMONUCLEAR_SMOKE_DEVIL)), // smoke_pet
            Map.entry(8483, PetData.boss(HiscoreSkill.THERMONUCLEAR_SMOKE_DEVIL)), // smoke_pet_old
            Map.entry(2132, PetData.boss(HiscoreSkill.ZULRAH)), // snake_pet_blue
            Map.entry(2130, PetData.boss(HiscoreSkill.ZULRAH)), // snake_pet_green
            Map.entry(2131, PetData.boss(HiscoreSkill.ZULRAH)), // snake_pet_orange
            Map.entry(12857, PetData.boss(HiscoreSkill.SOL_HEREDIT)), // solheredit_pet
            Map.entry(3566, PetData.boss(HiscoreSkill.SOUL_WARS_ZEAL)), // soulwars_pet_blue return soul wars zeal? hmm
            Map.entry(5008, PetData.boss(HiscoreSkill.SOUL_WARS_ZEAL)), // soulwars_pet_red return soul wars zeal? hmm
            Map.entry(6628, PetData.boss(HiscoreSkill.DAGANNOTH_SUPREME)), // supreme_pet
            Map.entry(9513, PetData.boss(HiscoreSkill.CHAMBERS_OF_XERIC_CHALLENGE_MODE)), // tekton_enraged_pet return challenge mode
            Map.entry(8202, PetData.boss(HiscoreSkill.CHAMBERS_OF_XERIC_CHALLENGE_MODE)), // tekton_pet return challenge mode
            Map.entry(10637, PetData.boss(HiscoreSkill.TEMPOROSS)), // tempoross_pet
            Map.entry(8203, PetData.boss(HiscoreSkill.CHAMBERS_OF_XERIC_CHALLENGE_MODE)), // vanguard_pet return challenge mode
            Map.entry(12158, PetData.boss(HiscoreSkill.VARDORVIS)), // vardorvis_pet
            Map.entry(8204, PetData.boss(HiscoreSkill.CHAMBERS_OF_XERIC_CHALLENGE_MODE)), // vasa_pet return challenge mode
            Map.entry(5557, PetData.boss(HiscoreSkill.VENENATIS)), // venenatispet
            Map.entry(11985, PetData.boss(HiscoreSkill.VENENATIS)), // venenatispet_legacy
            Map.entry(8337, PetData.boss(HiscoreSkill.THEATRE_OF_BLOOD)), // verzik_pet
            Map.entry(10871, PetData.boss(HiscoreSkill.THEATRE_OF_BLOOD_HARD_MODE)), // verzik_pet_bloat return hard mode
            Map.entry(10870, PetData.boss(HiscoreSkill.THEATRE_OF_BLOOD_HARD_MODE)), // verzik_pet_maiden return hard mode
            Map.entry(10872, PetData.boss(HiscoreSkill.THEATRE_OF_BLOOD_HARD_MODE)), // verzik_pet_nylocas return hard mode
            Map.entry(10873, PetData.boss(HiscoreSkill.THEATRE_OF_BLOOD_HARD_MODE)), // verzik_pet_sotetseg return hard mode
            Map.entry(10874, PetData.boss(HiscoreSkill.THEATRE_OF_BLOOD_HARD_MODE)), // verzik_pet_xarpus return hard mode
            Map.entry(9514, PetData.boss(HiscoreSkill.THEATRE_OF_BLOOD_HARD_MODE)), // vespula_flying_pet return hard mode
            Map.entry(8205, PetData.boss(HiscoreSkill.THEATRE_OF_BLOOD_HARD_MODE)), // vespula_pet return hard mode
            Map.entry(5559, PetData.boss(HiscoreSkill.VETION)), // vetionpet
            Map.entry(5560, PetData.boss(HiscoreSkill.VETION)), // vetionpet_2
            Map.entry(11988, PetData.boss(HiscoreSkill.VETION)), // vetionpet_2_legacy
            Map.entry(11987, PetData.boss(HiscoreSkill.VETION)), // vetionpet_legacy
            Map.entry(8029, PetData.boss(HiscoreSkill.VORKATH)), // vorkath_pet
            Map.entry(11846, PetData.boss(HiscoreSkill.TOMBS_OF_AMASCUT_EXPERT)), // warden_pet_akkha return expert
            Map.entry(11847, PetData.boss(HiscoreSkill.TOMBS_OF_AMASCUT_EXPERT)), // warden_pet_baba return expert
            Map.entry(11813, PetData.boss(HiscoreSkill.TOMBS_OF_AMASCUT)), // warden_pet_elidinis return regular kc?
            Map.entry(11851, PetData.boss(HiscoreSkill.TOMBS_OF_AMASCUT_EXPERT)), // warden_pet_elidinis_destroyed return expert
            Map.entry(11848, PetData.boss(HiscoreSkill.TOMBS_OF_AMASCUT_EXPERT)), // warden_pet_kephri return expert
            Map.entry(11812, PetData.boss(HiscoreSkill.TOMBS_OF_AMASCUT)), // warden_pet_tumeken return regular kc?
            Map.entry(11850, PetData.boss(HiscoreSkill.TOMBS_OF_AMASCUT_EXPERT)), // warden_pet_tumeken_destroyed return expert
            Map.entry(11849, PetData.boss(HiscoreSkill.TOMBS_OF_AMASCUT_EXPERT)), // warden_pet_zebak return expert
            Map.entry(12157, PetData.boss(HiscoreSkill.THE_WHISPERER)), // whisperer_pet
            Map.entry(14204, PetData.boss(HiscoreSkill.YAMA)), // yama_pet
            Map.entry(8739, PetData.boss(HiscoreSkill.ZALCANO)), // zalcano_pet
            Map.entry(6634, PetData.boss(HiscoreSkill.KRIL_TSUTSAROTH)), // zamorak_pet
            Map.entry(8011, PetData.boss(HiscoreSkill.TZKAL_ZUK)) // zuk_pet

            // Hope that's all of them

    );

    static boolean isPet(int npcId)
    {
        return PET_DATA.containsKey(npcId);
    }

    static PetData get(int npcId)
    {
        return PET_DATA.get(npcId);
    }
}
