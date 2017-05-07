/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
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
package net.runelite.client.plugins.zulrah.patterns;

import net.runelite.client.plugins.zulrah.StandLocation;
import net.runelite.client.plugins.zulrah.ZulrahLocation;
import net.runelite.client.plugins.zulrah.ZulrahType;

public class ZulrahPatternC extends ZulrahPattern
{
	public ZulrahPatternC()
	{
		add(ZulrahLocation.NORTH, ZulrahType.RANGE, StandLocation.TOP_EAST);
		add(ZulrahLocation.EAST, ZulrahType.RANGE, StandLocation.TOP_EAST);
		add(ZulrahLocation.NORTH, ZulrahType.MELEE, StandLocation.TOP_WEST);
		add(ZulrahLocation.WEST, ZulrahType.MAGIC, StandLocation.TOP_WEST);
		add(ZulrahLocation.SOUTH, ZulrahType.RANGE, StandLocation.EAST);
		add(ZulrahLocation.EAST, ZulrahType.MAGIC, StandLocation.PILLAR_EAST_OUTSIDE);
		add(ZulrahLocation.NORTH, ZulrahType.RANGE, StandLocation.WEST);
		add(ZulrahLocation.WEST, ZulrahType.RANGE, StandLocation.PILLAR_WEST_OUTSIDE);
		add(ZulrahLocation.NORTH, ZulrahType.MAGIC, StandLocation.PILLAR_EAST_OUTSIDE);
		addJad(ZulrahLocation.EAST, ZulrahType.MAGIC, StandLocation.PILLAR_EAST_OUTSIDE);
		add(ZulrahLocation.NORTH, ZulrahType.MAGIC, StandLocation.EAST);
	}
}
