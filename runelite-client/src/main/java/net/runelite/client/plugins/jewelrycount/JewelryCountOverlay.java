/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.client.plugins.jewelrycount;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.api.widgets.WidgetItem;
import net.runelite.client.RuneLite;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;

class JewelryCountOverlay extends Overlay
{
	private final JewelryCountConfig config;

	JewelryCountOverlay(JewelryCount plugin)
	{
		super(OverlayPosition.DYNAMIC);
		this.config = plugin.getConfig();
	}

	@Override
	public Dimension render(Graphics2D graphics)
	{
		Client client = RuneLite.getClient();

		if (client.getGameState() != GameState.LOGGED_IN
			|| !config.enabled()
			|| client.getWidget(WidgetInfo.LOGIN_CLICK_TO_PLAY_SCREEN) != null)
		{
			return null;
		}

		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null)
		{
			return null;
		}

		if (!inventory.isHidden())
		{
			for (WidgetItem item : inventory.getWidgetItems())
			{
				JewelryCharges charges = JewelryCharges.getCharges(item.getId());

				if (charges == null)
				{
					continue;
				}

				renderWidgetText(graphics, item.getCanvasBounds(), charges.getCharges(), Color.white);

			}
		}

		Widget equipment = client.getWidget(WidgetInfo.EQUIPMENT);

		if (equipment != null)
		{
			Widget[] equipmentSlots =
			{
				client.getWidget(WidgetInfo.EQUIPMENT_AMULET).getChild(1), client.getWidget(WidgetInfo.EQUIPMENT_RING).getChild(1),
				client.getWidget(WidgetInfo.EQUIPMENT_GLOVES).getChild(1)
			};

			for (Widget widget : equipmentSlots)
			{
				JewelryCharges charges = JewelryCharges.getCharges(widget.getItemId());

				if (charges == null || widget.isHidden())
				{
					continue;
				}

				Rectangle widgetBounds = widget.getBounds();

				//to match inventory text
				widgetBounds.x -= 5;
				widgetBounds.y -= 1;

				renderWidgetText(graphics, widgetBounds, charges.getCharges(), Color.white);

			}
		}

		return null;
	}

	private void renderWidgetText(Graphics2D graphics, Rectangle bounds, int charges, Color color)
	{
		String text = charges + "";
		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D textBounds = fm.getStringBounds(text, graphics);

		int textX = (int) (bounds.getX() + bounds.getWidth() - textBounds.getWidth());
		int textY = (int) (bounds.getY() + (textBounds.getHeight()));

		//text shadow
		graphics.setColor(Color.BLACK);
		graphics.drawString(text, textX + 1, textY + 1);

		graphics.setColor(color);
		graphics.drawString(text, textX, textY);
	}

}
