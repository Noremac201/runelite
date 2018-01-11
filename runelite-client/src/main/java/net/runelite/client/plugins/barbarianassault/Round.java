package net.runelite.client.plugins.barbarianassault;

import java.time.Duration;
import java.time.Instant;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;

public class Round
{
	private Instant roundStartTime;
	private Role roundRole;
	private boolean runnersKilled;
	private boolean rangersKilled;
	private boolean healersKilled;
	private boolean fightersKilled;
	private Client client;

	@Inject
	public Round(Client client)
	{
		this.client = client;
		roundStartTime = Instant.now();
		roundRole = null;
		System.out.println("New role: " + roundRole);
	}

	public long timeToChange()
	{
		return 29 + (Duration.between(Instant.now(), roundStartTime).getSeconds() % 30);
	}

	public boolean isRunnersKilled()
	{
		return runnersKilled;
	}

	public void setRunnersKilled(boolean runnersKilled)
	{
		this.runnersKilled = runnersKilled;
	}

	public boolean isRangersKilled()
	{
		return rangersKilled;
	}

	public void setRangersKilled(boolean rangersKilled)
	{
		this.rangersKilled = rangersKilled;
	}

	public boolean isHealersKilled()
	{
		return healersKilled;
	}

	public void setHealersKilled(boolean healersKilled)
	{
		this.healersKilled = healersKilled;
	}

	public boolean isFightersKilled()
	{
		return fightersKilled;
	}

	public void setFightersKilled(boolean fightersKilled)
	{
		this.fightersKilled = fightersKilled;
	}

	public Role getRoundRole()
	{
		return roundRole;
	}
}
