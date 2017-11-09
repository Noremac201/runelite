package net.runelite.client.plugins.xpdrops;

import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.time.Duration;
import java.time.Instant;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class XpDropOverlay extends Overlay
{
	private final XpDrops plugin;
	private static Instant timer = Instant.now();
	private static int wholeXp = 0;
	private static Stack<Integer> xpDrops;
	private static Queue<XpDrop> xpToDraw = new ArrayBlockingQueue<>(10);

	public XpDropOverlay(XpDrops plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.plugin = plugin;
		this.xpDrops = plugin.getXpList();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		if (RuneLite.getClient().getGameState() != GameState.LOGGED_IN)
			return null;

		if (Duration.between(timer, Instant.now()).toMillis() < 20)
		{
			while (!xpDrops.isEmpty())
				wholeXp += xpDrops.pop();
		}
		else if (wholeXp != 0)
		{
			while (!xpDrops.isEmpty())
				wholeXp += xpDrops.pop();

			xpToDraw.add(new XpDrop(wholeXp));
			timer = Instant.now();
		}
		else
		{
			wholeXp = 0;
			timer = Instant.now();
		}

		for (XpDrop xpDrop : xpToDraw)
		{
			System.out.println(xpDrop.getXp());
			xpToDraw.remove();
		}
		return null;
	}
}
