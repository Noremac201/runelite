/*
 * Copyright (c) 2016-2017, Cameron Moberg <Moberg@tuta.io>
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

package net.runelite.client.plugins.bosstimer;

import com.google.common.eventbus.Subscribe;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.runelite.api.NPC;
import net.runelite.client.RuneLite;
import net.runelite.client.events.NPCChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.opponentinfo.OpponentInfo;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class BossTimers extends Plugin
{
	private final BossTimersOverlay overlay = new BossTimersOverlay(OverlayPosition.TOP_LEFT, OverlayPriority.LOW);
	private static HashMap<Integer, Boss> bossMap = loadJSON();
	private static NPC[] cachedNPCs = RuneLite.getClient().getNpcs();

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void npcChange(NPCChanged e)
	{
		if (bossMap.containsKey(e.getIndex()))
		{
			cachedNPCs = RuneLite.getClient().getNpcs();
			Boss boss = bossMap.get(e.getIndex());
			if (cachedNPCs[e.getIndex()] == null && boss.isDead())
			{
				boss.setTimeToSpawn(Instant.now().plus(boss.getSpawnTime(), ChronoUnit.SECONDS)); //convert to ms
				boss.setIsDead(false);
				overlay.addBoss(boss);
			}
		}
	}

	static void updateHealth()
	{
		for (Map.Entry<Integer, Boss> boss : bossMap.entrySet())
		{
			if (cachedNPCs[boss.getKey()] != null && cachedNPCs[boss.getKey()].getHealthRatio() == 0)
			{
				boss.getValue().setIsDead(true);
			}
		}
	}

	static HashMap<Integer, Boss> loadJSON()
	{
		Gson gson = new Gson();
		Type type = new TypeToken<Map<Integer, Boss>>()
		{
		}.getType();

		InputStream healthFile = OpponentInfo.class.getResourceAsStream("/boss_timers.json");
		return gson.fromJson(new InputStreamReader(healthFile), type);
	}

}
