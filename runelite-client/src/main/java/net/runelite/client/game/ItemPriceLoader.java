/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package net.runelite.client.game;

import com.google.common.cache.CacheLoader;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import net.runelite.client.RuneLite;
import static net.runelite.client.game.ItemManager.EMPTY;
import static net.runelite.client.game.ItemManager.NONE;
import net.runelite.http.api.item.ItemClient;
import net.runelite.http.api.item.ItemPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ItemPriceLoader extends CacheLoader<Integer, ItemPrice>
{
	private static final Logger logger = LoggerFactory.getLogger(ItemPriceLoader.class);

	private final ListeningExecutorService executorService;
	private final ItemClient client;

	ItemPriceLoader(RuneLite runelite, ItemClient client)
	{
		this.executorService = MoreExecutors.listeningDecorator(runelite.getExecutor());
		this.client = client;
	}

	@Override
	public ItemPrice load(Integer key) throws Exception
	{
		// guava's Cache doesn't support null values
		return EMPTY;
	}

	@Override
	public ListenableFuture<ItemPrice> reload(Integer key, ItemPrice oldValue)
	{
		logger.debug("Submitting lookup for item {}", key);

		return executorService.submit(() -> fetch(key));
	}

	private ItemPrice fetch(Integer key)
	{
		try
		{
			ItemPrice itemPrice = client.lookupItemPrice(key);
			if (itemPrice == null)
			{
				return NONE;
			}
			return itemPrice;
		}
		catch (IOException ex)
		{
			logger.warn("unable to look up item!", ex);
			return NONE;
		}
	}
};
