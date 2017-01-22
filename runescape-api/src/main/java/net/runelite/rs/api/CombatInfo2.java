package net.runelite.rs.api;

import net.runelite.mapping.Import;

/**
 * Created by bold on 1/21/17.
 */
public interface CombatInfo2 extends CacheableNode
{
    @Import("healthScale")
    int getHealthScale();
}
