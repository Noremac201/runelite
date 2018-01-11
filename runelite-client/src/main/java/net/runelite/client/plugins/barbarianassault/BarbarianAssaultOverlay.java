package net.runelite.client.plugins.barbarianassault;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.time.Instant;
import javax.annotation.Nullable;
import javax.imageio.ImageIO;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Varbits;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.menus.MenuManager;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.util.QueryRunner;

public class BarbarianAssaultOverlay extends Overlay
{
	private final Client client;
	private final BarbarianAssaultPlugin plugin;
	private final QueryRunner queryRunner;
	private BufferedImage clockImage;
	private Round currentRound;

	@Inject
	BarbarianAssaultOverlay(@Nullable Client client, BarbarianAssaultPlugin plugin, QueryRunner queryRunner)
	{
		setPosition(OverlayPosition.DYNAMIC);
		this.client = client;
		this.plugin = plugin;
		this.queryRunner = queryRunner;
	}

	@Override
	public Dimension render(Graphics2D graphics, Point parent)
	{
		if (client.getGameState() != GameState.LOGGED_IN || currentRound == null)
		{
			return null;
		}

		Role role = currentRound.getRoundRole();
		Widget roleText = (role != null) ? client.getWidget(currentRound.getRoundRole().getRoleText()) : null;
		if (roleText != null)
		{
			System.out.println("roleText");
			roleText.setText(String.format("00:%02d", currentRound.timeToChange()));
		}

		return null;
	}

	public void setRound(Round round)
	{
		System.out.println("round set");
		this.currentRound = round;
	}
}
