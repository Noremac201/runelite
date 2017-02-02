package net.runelite.client.plugins.experiencedrops;

import com.google.common.eventbus.Subscribe;
import net.runelite.client.events.ExperienceChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

import java.time.Instant;
import java.util.Stack;

/**
 * Created by bold on 1/14/17.
 */
public class ExperienceDrops extends Plugin
{
	private static Stack<Integer> index = new Stack<>();
	private static Instant t = Instant.now();

	@Override
	public Overlay getOverlay()
	{
		return new ExpDropsOverlay(OverlayPosition.CUSTOM, OverlayPriority.HIGH);
	}


	@Subscribe
	public void gotEvent(ExperienceChanged e)
	{
		if (Instant.now().toEpochMilli() - t.toEpochMilli() > 20)
		{
			t = Instant.now();
			while (!index.isEmpty())
			{
				index.pop(); //pop everything off the stack.
			}
			index.push(e.getIndex());
		}
	}

	public Stack<Integer> getIndex()
	{
		return index;
	}

}
