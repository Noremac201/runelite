package net.runelite.client.plugins.experiencedrops;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ExpDropsOverlay extends Overlay
{
	private static Client client = RuneLite.getClient();
	private static int[] oldXP = new int[23];
	private static int[] newXP = new int[23];
	public static boolean expChangeFlag = false;
	private static LinkedList<Drop> xp = new LinkedList<>();
	private static ExperienceDrops listener = new ExperienceDrops();

	public ExpDropsOverlay(OverlayPosition position, OverlayPriority priority)
	{
		super(position, priority);
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		int x = client.isResized() ? client.getClientWidth() / 2 : client.getClientWidth() / 3;
		int yCutoff = client.isResized() ? client.getClientHeight() / 4 : 0;

		if (client.getGameState() != GameState.LOGGED_IN)
			return null;
		if (!listener.getIndex().isEmpty())
		{
			Stack<Integer> stack = listener.getIndex();
			xp.add(updateExp(stack));
		}
		graphics.setColor(Color.white);
		graphics.setFont(new Font(graphics.getFont().getFontName(), Font.TRUETYPE_FONT, 18));

		for (Drop d : xp)
		{
			if (d.getSumXP() == 0)
				continue;
			String s = String.valueOf(d.getSumXP());
			graphics.drawString("+" + s + "xp", x, d.getY());
			if (d.getY() <= yCutoff + graphics.getFontMetrics().getHeight())
			{
				xp.remove(d);
			}
			d.setY(d.getY() - 2);

		}
		return null;
	}

	public Drop updateExp(Stack<Integer> stack)
	{
		int sumXP = 0;
		newXP = Arrays.copyOf(client.getSkillExperiences(), 23);
		while (!stack.isEmpty())
		{
			int currIndex = stack.pop();
			sumXP += (newXP[currIndex] - oldXP[currIndex]);
		}

		oldXP = Arrays.copyOf(newXP, 23);
		int yCoord = client.isResized() ? client.getClientHeight() / 2 : client.getClientHeight() / 3;
		return new Drop(sumXP, null, yCoord);
	}
}
