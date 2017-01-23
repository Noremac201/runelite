/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.plugins.opponentinfo;

import net.runelite.api.*;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;
import java.text.DecimalFormat;
import java.time.Instant;

class OpponentInfoOverlay extends Overlay
{
    private static final int WIDTH = 140;

    private static final int TOP_BORDER = 2;
    private static final int BOTTOM_BORDER = 2;

    private static final int BAR_WIDTH = 124;
    private static final int BAR_HEIGHT = 20;
    //private static Font currFont = new Font("Inconsolata", Font.TRUETYPE_FONT, 16);
    private static DecimalFormat df = new DecimalFormat("0.0");
    private static final Color BACKGROUND = new Color(Color.gray.getRed(), Color.gray.getGreen(), Color.gray.getBlue(), 127);
    private static final Color HP_GREEN = new Color(0, 146, 54, 230);
    private static final Color HP_RED = new Color(102, 15, 16, 230);

    private static float lastRatio = 0;
    private static Instant lastTime = Instant.now();
    private static String str = "";

    OpponentInfoOverlay()
    {
        super(OverlayPosition.TOP_LEFT, OverlayPriority.HIGH);
    }

    private Actor getOpponent()
    {
        Client client = RuneLite.getClient();

        Player player = client.getLocalPlayer();
        if (player == null)
            return null;

        return player.getInteracting();
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        if (RuneLite.getClient().getGameState() != GameState.LOGGED_IN)
            return null;

        Actor opponent = getOpponent();

        if (opponent != null && opponent.getHealth() != -1)
        {
            lastTime = Instant.now();
            lastRatio = (float) opponent.getHealthRatio() / (float) opponent.getHealth() * 100;
            str = opponent.getName() + " (" + opponent.getID() + ")";
        }

        if (Instant.now().toEpochMilli() - lastTime.toEpochMilli() > 3000) //and 3 seconds have passed.
            return null;

        //graphics.setFont(currFont);
        FontMetrics fm = graphics.getFontMetrics();

        int height = TOP_BORDER
                + fm.getHeight(); // opponent name
        if (lastRatio >= 0)
            height += 2 // between name and hp bar
                    + BAR_HEIGHT; // bar
        height += BOTTOM_BORDER;

        graphics.setColor(BACKGROUND);
        graphics.fillRect(0, 0, WIDTH, height);

        int x = (WIDTH - fm.stringWidth(str)) / 2;
        graphics.setColor(Color.white);
        graphics.drawString(str, x, fm.getHeight() + TOP_BORDER);

        if (lastRatio >= 0)
        {
            int barWidth = (int) (lastRatio / 100 * (float) BAR_WIDTH);
            int barY = TOP_BORDER + fm.getHeight() + 1;

            graphics.setColor(HP_GREEN);
            graphics.fillRect((WIDTH - BAR_WIDTH) / 2, barY, barWidth, BAR_HEIGHT);

            graphics.setColor(HP_RED);
            graphics.fillRect(((WIDTH - BAR_WIDTH) / 2) + barWidth, barY, BAR_WIDTH - barWidth, BAR_HEIGHT);

            graphics.setColor(Color.white);
            String percent = df.format(lastRatio);
            graphics.drawString(percent, (WIDTH - fm.stringWidth(percent)) / 2, barY + fm.getHeight());
        }

        return new Dimension(WIDTH, height);
    }
}
