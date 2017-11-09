package net.runelite.client.plugins.xpdrops;

public class XpDrop
{
	private int xpAmount;

	public XpDrop()
	{
		this.xpAmount = 0;
	}

	public XpDrop(int xpAmount)
	{
		this.xpAmount = xpAmount;
	}

	public void addXp(int xp)
	{
		this.xpAmount += xp;
	}

	public int getXp()
	{
		return this.xpAmount;
	}
}
