package com.petexamine;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("petexamine")
public interface PetExamineConfig extends Config
{
    @ConfigItem(
            keyName = "showOwnerInMenu",
            name = "Show owner name in menu",
            description = "Display the pet owner's name in the examine menu option"
    )
    default boolean showOwnerInMenu()
    {
        return true;
    }
}