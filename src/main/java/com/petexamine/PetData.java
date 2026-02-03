package com.petexamine;

import net.runelite.api.Skill;
import net.runelite.client.hiscore.HiscoreSkill;

final class PetData
{
    final PetType type;
    final Skill skill;
    final HiscoreSkill boss;

    private PetData(PetType type, Skill skill, HiscoreSkill boss)
    {
        this.type = type;
        this.skill = skill;
        this.boss = boss;
    }

    static PetData skill(Skill skill)
    {
        return new PetData(PetType.SKILL_XP, skill, null);
    }

    static PetData boss(HiscoreSkill boss)
    {
        return new PetData(PetType.BOSS_KC, null, boss);
    }
}
