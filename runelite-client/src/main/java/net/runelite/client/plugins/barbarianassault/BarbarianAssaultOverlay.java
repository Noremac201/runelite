/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
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
package net.runelite.client.plugins.barbarianassault;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import javax.annotation.Nullable;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

public class BarbarianAssaultOverlay extends Overlay
{
	private final Client client;
	private final BarbarianAssaultPlugin plugin;
	private Round currentRound;
	private BarbarianAssaultConfig config;

	@Inject
	BarbarianAssaultOverlay(@Nullable Client client, BarbarianAssaultPlugin plugin, BarbarianAssaultConfig config)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
		this.config = config;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (!config.enabled() || client.getGameState() != GameState.LOGGED_IN || currentRound == null)
		{
			return null;
		}

		Role role = currentRound.getRoundRole();
		Widget roleText = (role != null) ? client.getWidget(role.getRoleText()) : null;
		Widget roleSprite = (role != null) ? client.getWidget(role.getRoleSprite()) : null;

		if (config.showTimer() && roleText != null && roleSprite != null)
		{
			roleText.setText(String.format("00:%02d", currentRound.getTimeToChange()));
			Rectangle spriteBounds = roleSprite.getBounds();
			roleSprite.setHidden(true);
			graphics.drawImage(plugin.getClockImage(), spriteBounds.x, spriteBounds.y, null);
		}

		return null;
	}

	public Round getCurrentRound()
	{
		return currentRound;
	}

	public void setRound(Round round)
	{
		this.currentRound = round;
	}
}
