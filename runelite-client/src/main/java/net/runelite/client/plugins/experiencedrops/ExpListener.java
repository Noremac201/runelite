package net.runelite.client.plugins.experiencedrops;

import com.google.common.eventbus.Subscribe;
import net.runelite.client.events.ExperienceChanged;

import java.time.Instant;
import java.util.Stack;

/**
 * Created by bold on 2/1/17.
 */
public class ExpListener
{
	private static Stack<Integer> index = new Stack<>();
	private static Instant t = Instant.now();

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
