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

package net.runelite.client.plugins;

import net.runelite.client.RuneLite;
import net.runelite.client.plugins.boosts.Boosts;
import net.runelite.client.plugins.bosstimers.BossTimers;
import net.runelite.client.plugins.experiencedrops.ExperienceDrops;
import net.runelite.client.plugins.fpsinfo.FPS;
import net.runelite.client.plugins.opponentinfo.OpponentInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PluginManager
{
	private final RuneLite runelite;
	private final List<Plugin> plugins = new ArrayList<>();

	public PluginManager(RuneLite runelite)
	{
		this.runelite = runelite;
	}

	public void loadAll()
	{
		load(new Boosts());
		load(new OpponentInfo());
		load(new FPS());
		load(new BossTimers());
		load(new ExperienceDrops());
	}

	private void load(Plugin plugin)
	{
		plugins.add(plugin);
		runelite.getEventBus().register(plugin);
	}

	public Collection<Plugin> getPlugins()
	{
		return plugins;
	}

}
