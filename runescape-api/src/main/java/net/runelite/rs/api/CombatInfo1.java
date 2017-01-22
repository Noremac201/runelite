package net.runelite.rs.api;

import net.runelite.mapping.Export;
import net.runelite.mapping.Import;

/**
 * Created by bold on 1/21/17.
 */
public interface CombatInfo1 extends Node
{
    @Import("health")
    int getHealth();

    @Import("healthRatio")
    int getHealthRatio();

}
