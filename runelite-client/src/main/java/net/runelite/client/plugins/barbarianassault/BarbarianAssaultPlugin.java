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

import com.google.common.eventbus.Subscribe;
import com.google.inject.Binder;
import com.google.inject.Provides;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.MenuEntry;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.events.ChatMessage;
import net.runelite.client.events.MenuEntryAdded;
import net.runelite.client.events.VarbitChanged;
import net.runelite.client.events.WidgetGroupLoaded;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;

@PluginDescriptor(
		name = "Barbarian Assault Plugin"
)
public class BarbarianAssaultPlugin extends Plugin
{
	private static final int BA_ATTACKER_GROUP_ID = 485;
	private static final int BA_COLLECTOR_GROUP_ID = 486;
	private static final int BA_DEFENDER_GROUP_ID = 487;
	private static final int BA_HEALER_GROUP_ID = 488;
	private static final int BA_ALL_KILLED_INDEX = 4;

	private Font font;
	private Image clockImage;
	private int inGameBit = 0;

	@Inject
	Client client;

	@Inject
	BarbarianAssaultConfig config;

	@Inject
	BarbarianAssaultOverlay overlay;

	@Provides
	BarbarianAssaultConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(BarbarianAssaultConfig.class);
	}

	@Override
	public void configure(Binder binder)
	{
		binder.bind(BarbarianAssaultOverlay.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		font = FontManager.getRunescapeFont()
				.deriveFont(Font.BOLD, 24);
		clockImage = ImageIO.read(getClass().getResourceAsStream("clock.png"));
	}

	@Subscribe
	public void onMenuOpen(MenuEntryAdded event)
	{
		if (config.removeWrong() && overlay.getCurrentRound() != null && event.getTarget().endsWith("horn"))
		{
			MenuEntry[] entryCopy = Arrays.copyOf(client.getMenuEntries(), client.getMenuEntries().length);
			List<MenuEntry> entries = new ArrayList<>();
			for (MenuEntry entry : entryCopy)
			{
				WidgetInfo callInfo = overlay.getCurrentRound().getRoundRole().getCall();
				Widget call = client.getWidget(callInfo);

				if (!entry.getOption().startsWith("Tell-") ||
						entry.getOption().contains(Calls.getOption(call.getText())))
				{
					entries.add(entry);
				}
			}
			client.setMenuEntries(entries.toArray(new MenuEntry[entries.size()]));
		}
	}

	@Subscribe
	public void onVarbitChange(VarbitChanged event)
	{
		if (inGameBit != client.getSetting(Varbits.IN_GAME_BA) && inGameBit == 1)
		{
			overlay.setRound(null);
		}
		inGameBit = client.getSetting(Varbits.IN_GAME_BA);
	}

	@Subscribe
	public void onWidgetGroupLoaded(WidgetGroupLoaded event)
	{
		if (client.getSetting(Varbits.IN_GAME_BA) == 1 && overlay.getCurrentRound() == null)
		{
			switch (event.getGroupId())
			{
				case BA_ATTACKER_GROUP_ID:
					overlay.setRound(new Round(Role.ATTACKER));
					break;
				case BA_COLLECTOR_GROUP_ID:
					overlay.setRound(new Round(Role.COLLECTOR));
					break;
				case BA_DEFENDER_GROUP_ID:
					overlay.setRound(new Round(Role.DEFENDER));
					break;
				case BA_HEALER_GROUP_ID:
					overlay.setRound(new Round(Role.HEALER));
					break;
			}

		}
	}

	@Subscribe
	public void onMessageEvent(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.SERVER &&
				event.getMessage().startsWith("All of the Penance"))
		{
			String[] message = event.getMessage().split(" ");
			Round round = overlay.getCurrentRound();
			if (round != null)
			{
				switch (message[BA_ALL_KILLED_INDEX])
				{
					case "Healers":
						round.setHealersKilled(true);
						break;
					case "Runners":
						round.setRunnersKilled(true);
						break;
					case "Fighters":
						round.setFightersKilled(true);
						break;
					case "Rangers":
						round.setRangersKilled(true);
						break;
				}
			}
		}
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	public Font getFont()
	{
		return font;
	}

	public Image getClockImage()
	{
		return clockImage;
	}
}
