package net.runelite.client.plugins.barbarianassault;

import com.google.common.eventbus.Subscribe;
import com.google.errorprone.annotations.Var;
import com.google.inject.Binder;
import java.awt.Font;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.ItemID;
import net.runelite.api.Varbits;
import net.runelite.client.events.ChatMessage;
import net.runelite.client.events.VarbitChanged;
import net.runelite.client.game.ItemManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.FontManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.util.QueryRunner;

@PluginDescriptor(
		name = "Barbarian Assault Plugin"
)
public class BarbarianAssaultPlugin extends Plugin
{
	private Font font;
	private Image clockImage;
	private Round round;
	private int inGameVarbit = 0;

	@Inject
	QueryRunner queryRunner;

	@Inject
	Client client;

	@Inject
	BarbarianAssaultOverlay overlay;

	@Override
	public void configure(Binder binder)
	{
		binder.bind(BarbarianAssaultOverlay.class);
	}

	@Override
	protected void startUp() throws Exception
	{
		font = FontManager.getRunescapeFont()
				.deriveFont(Font.BOLD, 24);
		clockImage = ImageIO.read(getClass().getResourceAsStream("clock.png"));
	}

	@Subscribe
	public void onVarbitChanged(VarbitChanged event)
	{
		System.out.println(client.getSetting(Varbits.IN_GAME_BA));
		if (inGameVarbit != client.getSetting(Varbits.IN_GAME_BA))
		{
			if (client.getSetting(Varbits.IN_GAME_BA) == 1)
			{
				overlay.setRound(new Round(client));
			}
			else
			{
				overlay.setRound(null);
			}
			inGameVarbit = client.getSetting(Varbits.IN_GAME_BA);
		}
	}

//	private Role checkHornForRole()
//	{
//
//	}

	@Subscribe
	public void onChatMessage(ChatMessage event)
	{
		if (event.getType() == ChatMessageType.PUBLIC && event.getMessage().equals("!Stop"))
		{
			overlay.setRound(null);
		}

		if (event.getType() == ChatMessageType.SERVER)
		{
			if (event.getMessage().contains("Wave: "))
			{
				overlay.setRound(new Round(client));
			}
			else if (event.getMessage().equals("The game ended early because one of your team-mates died."))
			{
				overlay.setRound(null);
			}
			//else if (event.getMessage().equals("All of the Penance .... have been killed!"));
		}
	}

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	public Font getFont()
	{
		return font;
	}

	public Image getClockImage()
	{
		return clockImage;
	}
}
