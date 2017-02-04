package net.runelite.client.events;

import net.runelite.client.plugins.bosstimers.BossTimersOverlay;

/**
 * Created by bold on 1/29/17.
 */
public class NPCChanged
{
	private int index;

	public NPCChanged(int index)
	{
		System.out.println("npc changed");
		this.index = index;
	}

	public int getIndex()
	{
		return this.index;
	}

}
