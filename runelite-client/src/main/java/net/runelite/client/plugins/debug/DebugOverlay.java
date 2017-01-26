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
    private static Instant t = Instant.now();

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
        c.addMenuEntry("hello", "there", 30, 0, 0, 0);

        if (Instant.now().toEpochMilli() - t.toEpochMilli() > 1000)
        {

            t = Instant.now();
            for (Player p : c.getPlayers())
            {
                if (p == null)
                    continue;
                //p.addPlayerActions(10, 10, 10);
            }
        }
        return null;

    }
}