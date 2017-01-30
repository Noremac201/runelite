package net.runelite.api;

/**
 * Created by bold on 1/26/17.
 */
public enum MessageType
{

    PUBLIC(2),
    PRIVATE_MESSAGE_SENT(6),
    PRIVATE_MESSAGE_RECIEVED(3),
    FRIEND_STATUS_CHANGE(5),
    FILTERABLE(105),
    NEVER_FILTER(0),
    CLAN(9),
    DUEL(103),
    TRADE(101);

    private int opcode;

    MessageType(int opcode)
    {
        this.opcode = opcode;
    }

    public int getOpcode()
    {
        return this.opcode;
    }

}
