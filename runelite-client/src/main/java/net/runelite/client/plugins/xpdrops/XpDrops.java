package net.runelite.client.plugins.xpdrops;

import com.google.common.eventbus.Subscribe;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.client.RuneLite;
import net.runelite.client.events.ExperienceChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.Overlay;
import java.util.Stack;

@PluginDescriptor(
		name = "Xp drops plugin"
)
public class XpDrops extends Plugin
{
	private final Overlay overlay = new XpDropOverlay(this);
	private final Client client = RuneLite.getClient();
	private final int[] xpCache = new int[Skill.values().length - 1];
	private static Stack<Integer> xpList = new Stack<>();

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	@Subscribe
	public void onExperienceChanged(ExperienceChanged event)
	{
		Skill skillChanged = event.getSkill();
		int currentXp = client.getSkillExperience(skillChanged);
		int skillIdx = skillChanged.ordinal();
		int cachedXp = xpCache[skillIdx];

		if (xpCache[skillIdx] == 0)
		{
			xpCache[skillIdx] = currentXp;
		}
		else
		{
			xpList.push(currentXp - cachedXp);
		}

	}

	public Stack<Integer> getXpList()
	{
		return xpList;
	}

	@Override
	protected void startUp() throws Exception
	{

	}

	@Override
	protected void shutDown() throws Exception
	{

	}
}
