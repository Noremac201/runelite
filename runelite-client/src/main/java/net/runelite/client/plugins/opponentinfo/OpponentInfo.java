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

package net.runelite.client.plugins.opponentinfo;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.ui.overlay.Overlay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

public class OpponentInfo extends Plugin
{
	private final Overlay overlay = new OpponentInfoOverlay();

	@Override
	public Overlay getOverlay()
	{
		return overlay;
	}

	public static Map<String, Integer> loadJSON()
	{
		Gson gson = new Gson();
		Type type = new TypeToken<Map<String, Integer>>()
		{
		}.getType();
		Map<String, Integer> myMap = null;
		try
		{
			FileReader healthFile = new FileReader(OpponentInfo.class.getClassLoader().getResource("npcHealth.json").getFile());
			myMap = gson.fromJson(healthFile, type);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return myMap;
	}

}
