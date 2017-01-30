package net.runelite.client.plugins.debug;

import com.google.common.collect.Sets;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import net.runelite.api.*;
import net.runelite.client.RuneLite;
import net.runelite.client.plugins.bosstimers.Boss;
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
public class BossTimersOverlay extends Overlay
{
    private static final int TOP_BORDER = 2;
    private static final int LEFT_BORDER = 2;
    private static final int RIGHT_BORDER = 2;
    private static final int WIDTH = 140;

    private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
    private static final int SEPARATOR = 2;
    private String timeLeft = "";
    private static HashMap<Integer, Boss> bosses = new HashMap<>();
    private static NPC[] oldNPC;
    private static Client c = RuneLite.getClient();
    private static NPC[] newNPC = c.getNpcs();
    public static boolean npcChange = false;
    private static Instant timeToSpawn;
    private static boolean waitingToSpawn = false;
    private static boolean loaded = false;
    private static String bossToSpawn = "";

    public BossTimersOverlay(OverlayPosition position, OverlayPriority priority)
    {
        super(position, priority);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (!loaded)
            load();
        if (RuneLite.getClient().getGameState() != GameState.LOGGED_IN)
            return null;
        if (waitingToSpawn)
        {
            if (timeToSpawn.toEpochMilli() < Instant.now().toEpochMilli())
            {
                waitingToSpawn = false;
                bossToSpawn = "";
                timeLeft = "";
            } else
            {
                timeLeft = String.valueOf((timeToSpawn.toEpochMilli() - Instant.now().toEpochMilli()) / 1000);
            }
        }
        if (npcChange)
        {
            checkSpawns();
        }
        FontMetrics metrics = graphics.getFontMetrics();
        graphics.setColor(Color.white);
        graphics.drawString(bossToSpawn, LEFT_BORDER, TOP_BORDER + metrics.getHeight());

        graphics.drawString(timeLeft, WIDTH - RIGHT_BORDER - metrics.stringWidth(timeLeft), TOP_BORDER + metrics.getHeight());

        return null;
    }

    private void checkSpawns()
    {
        npcChange = false;
        oldNPC = newNPC;
        newNPC = c.getNpcs();
        for (Map.Entry<Integer, Boss> currBoss : bosses.entrySet())
        {
            updateHealth();
            if (oldNPC[currBoss.getKey()] != null && newNPC[currBoss.getKey()] == null && !waitingToSpawn)
            {
                if (currBoss.getValue().getLastHealth() == 0)
                {
                    timeToSpawn = Instant.now().plus(currBoss.getValue().getSpawnTime(), ChronoUnit.SECONDS);
                    bossToSpawn = currBoss.getValue().getBossName();
                    waitingToSpawn = true;
                }
            }
        }

    }

    private void updateHealth()
    {
        for (Map.Entry<Integer, Boss> boss : bosses.entrySet())
        {
            if (oldNPC[boss.getKey()] != null)
                boss.getValue().setLastHealth(oldNPC[boss.getKey()].getHealthRatio());
        }
    }

    private void load()
    {
        bosses.put(10942, new Boss(10942, 90, "Bandos")); //bandos
        bosses.put(15628, new Boss(15629, 90, "Saradomin")); //sara
        bosses.put(6516, new Boss(6516, 90, "Zamorak")); //zammy
    }
}