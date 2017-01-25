package net.runelite.client.plugins.debug;

import com.google.common.collect.Sets;
import net.runelite.api.*;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by bold on 1/19/17.
 */
public class DebugOverlay extends Overlay
{
    private static Client c = RuneLite.getClient();
    private static HashSet<NPC> npc1;
    private static HashSet<NPC> npc2;
    public static boolean npcChange = false;
    private static int npcChangeCount = 0;

    public DebugOverlay(OverlayPosition position, OverlayPriority priority)
    {
        super(position, priority);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (RuneLite.getClient().getGameState() == GameState.LOGIN_SCREEN)
            RuneLite.getClient().setUsername("noremac201");
        if (RuneLite.getClient().getGameState() != GameState.LOGGED_IN)
            return null;

        if (!npcChange)
            return null;
        npcChange = false;
        RuneLite.getClient().sendGameMessage("hellO");
        NPC[] arr = RuneLite.getClient().getNpcs();
        npc1 = new HashSet<>(Arrays.asList(arr));

        if (npcChangeCount++ == 0)
            npc2 = new HashSet<>(Arrays.asList(RuneLite.getClient().getNpcs()));

        Sets.SetView<NPC> diff = Sets.difference(npc1, npc2);
        if (diff.isEmpty())
            return null;
        Iterator<NPC> iter = diff.iterator();
        while (iter.hasNext())
        {
            System.out.println(iter.next().getName());
        }
        return null;
    }
}
