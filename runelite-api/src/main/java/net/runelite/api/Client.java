/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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

package net.runelite.api;

import net.runelite.mapping.Export;
import net.runelite.rs.api.ChatLineBuffer;
import net.runelite.rs.api.CombatInfo1;
import net.runelite.rs.api.MessageNode;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;

public class Client
{
    private net.runelite.rs.api.Client client;

    public Client(net.runelite.rs.api.Client client)
    {
        this.client = client;
    }

    public Player getLocalPlayer()
    {
        if (client.getLocalPlayer() == null)
            return null;

        return new Player(this, client.getLocalPlayer());
    }

    public NPC[] getNpcs()
    {
        return Arrays.stream(client.getCachedNPCs())
                .map(npc -> npc != null ? new NPC(this, npc) : null)
                .toArray(size -> new NPC[size]);
    }

    public Player[] getPlayers()
    {
        return Arrays.stream(client.getCachedPlayers())
                .map(player -> player != null ? new Player(this, player) : null)
                .toArray(size -> new Player[size]);
    }

    public int[] getBoostedSkillLevels()
    {
        return client.getBoostedSkillLevels();
    }

    public int[] getRealSkillLevels()
    {
        return client.getRealSkillLevels();
    }

    public int[] getSkillExperiences()
    {
        return client.getSkillExperiences();
    }

    public void sendGameMessage(String message)
    {
        client.sendGameMessage(99, "", message);
    }

    public GameState getGameState()
    {
        return GameState.of(client.getGameState());
    }

    public int getFPS()
    {
        return client.getFPS();
    }

    public Canvas getCanvas()
    {
        return client.getCanvas();
    }

    public int getClientWidth()
    {
        return client.getCanvas().getWidth();
    }

    public int getClientHeight()
    {
        return client.getCanvas().getHeight();
    }

    public String getUsername()
    {
        return client.getUsername();
    }

    public void setUsername(String user)
    {
        client.setUsername(user);
    }

    public String getLoginMessage2()
    {
        return client.getLoginMessage2();
    }

    public int[] getWidgetSettings()
    {
        return client.getWidgetSettings();
    }

    public boolean isResized()
    {
        return client.isResized();
    }

    public void addChatMessage(int var0, String var1, String var2, String var3)
    {
        client.addChatMessage(var0, var1, var2, var3);
    }

    public int getPacketOpcode()
    {
        return client.getPacketOpcode();
    }

    public void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5)
    {
        client.addMenuEntry(var0, var1, var2, var3, var4, var5);
    }

    public int getGameCycle()
    {
        return client.getGameCycle();
    }

    //messages sent by localPlayer.
    public String[] getMessages()
    {
        return client.getChatMessages().getMessages();
    }

    public Map<Integer, ChatLineBuffer> getChatLineMap()
    {
        return client.getChatLineMap();
    }

    public int getTotalNPC()
    {
        return client.getTotalNPC();
    }

    public int[] getTotalNPCArr()
    {
        return client.getTotalNPCArr();
    }
}
