package net.runelite.client.plugins.bosstimers;

import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.debug.BossTimersOverlay;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayPriority;

/**
 * Created by bold on 1/19/17.
 */
public class BossTimers extends Plugin
{
    private final Overlay overlay = new BossTimersOverlay(OverlayPosition.TOP_LEFT, OverlayPriority.LOW);

    @Override
    public Overlay getOverlay()
    {
        return overlay;
    }
}
