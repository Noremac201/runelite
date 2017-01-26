package net.runelite.rs.api;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import net.runelite.mapping.Import;

/**
 * Created by bold on 1/25/17.
 */
public interface ChatLineBuffer
{
    @Import("lines")
    MessageNode[] getLines();

    @Import("length")
    int getLength();
}
