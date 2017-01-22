package net.runelite.rs.api;

import net.runelite.mapping.Import;

import java.util.Iterator;

/**
 * Created by bold on 1/21/17.
 */
public interface CombatInfoList
{
    @Import("node")
    Node getNode();
}
