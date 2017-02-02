package net.runelite.client.events;

import net.runelite.client.plugins.bosstimers.BossTimersOverlay;

/**
 * Created by bold on 1/29/17.
 */
public class NPCChanged
{
	public NPCChanged()

	{
		BossTimersOverlay.npcChange = true;
	}
}
