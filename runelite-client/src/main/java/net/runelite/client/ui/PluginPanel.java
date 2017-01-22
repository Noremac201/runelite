package net.runelite.client.ui;

import net.runelite.api.Client;
import net.runelite.client.ClientLoader;
import net.runelite.client.RuneLite;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by bold on 1/20/17.
 */
public class PluginPanel extends JPanel implements MouseListener
{
    public static final int PANEL_WIDTH = 50, PANEL_HEIGHT = 503;
    private Applet rs;

    public PluginPanel() throws Exception
    {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        setSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setMinimumSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.white);
        this.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent)
    {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent)
    {

    }
}
