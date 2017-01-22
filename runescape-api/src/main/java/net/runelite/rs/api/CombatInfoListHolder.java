package net.runelite.rs.api;

import net.runelite.mapping.*;

import java.awt.*;
import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;

public interface CombatInfoListHolder extends Node
{
    @Import("combatInfo1")
    CombatInfoList getCombatInfo1();

    @Import("combatInfo2")
    CombatInfo2 getCombatInfo2();
}
