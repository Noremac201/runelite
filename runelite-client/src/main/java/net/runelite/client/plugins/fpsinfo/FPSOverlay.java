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

package net.runelite.client.plugins.fpsinfo;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;

public class FPSOverlay extends Overlay
{
	private static Client client = RuneLite.getClient();

	public FPSOverlay()
	{
		super(OverlayPosition.TOP_RIGHT, OverlayPriority.HIGH);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{

		if (client.getGameState() != GameState.LOGGED_IN)
			return null;

		FontMetrics fm = graphics.getFontMetrics();
		String str = String.valueOf(client.getFPS());

		int x = (int) (client.getClientWidth() - fm.getStringBounds(str, graphics).getWidth());
		int y = (fm.getHeight());
		//outline
		graphics.setColor(Color.black);
		graphics.drawString(str, x - 1, y + 1);
		graphics.drawString(str, x - 1, y - 1);
		graphics.drawString(str, x + 1, y + 1);
		graphics.drawString(str, x + 1, y - 1);
		//actual text
		graphics.setColor(Color.white);
		graphics.drawString(str, x, y);

		return new Dimension((int) fm.getStringBounds(str, graphics).getWidth(), (int) (fm.getStringBounds(str, graphics).getHeight()));
	}
}