package net.runelite.rs.api;

import net.runelite.mapping.Import;

import java.lang.reflect.Method;

/**
 * Created by bold on 1/21/17.
 */
public interface ChatMessages
{
    @Import("messages")
    String[] getMessages();
}
