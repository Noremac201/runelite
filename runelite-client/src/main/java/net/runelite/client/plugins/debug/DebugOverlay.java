package net.runelite.client.plugins.debug;

import com.google.common.collect.Sets;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import net.runelite.api.*;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;
import net.runelite.rs.api.ChatLineBuffer;
import net.runelite.rs.api.MessageNode;
import sun.management.counter.Units;

import java.awt.*;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;

/**
 * Created by bold on 1/19/17.
 */
public class DebugOverlay extends Overlay
{

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
        return null;
    }

}