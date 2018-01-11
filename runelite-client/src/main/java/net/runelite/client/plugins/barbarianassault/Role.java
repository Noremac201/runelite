package net.runelite.client.plugins.barbarianassault;

import net.runelite.api.widgets.WidgetInfo;

public enum Role
{
	ATTACKER(WidgetInfo.BA_ATK_LISTEN_TEXT, WidgetInfo.BA_ATK_CALL_TEXT, WidgetInfo.BA_ATK_ROLE_TEXT, WidgetInfo.BA_ATK_ROLE_SPRITE),
	DEFENDER(WidgetInfo.BA_DEF_LISTEN_TEXT, WidgetInfo.BA_DEF_CALL_TEXT, WidgetInfo.BA_DEF_ROLE_TEXT, WidgetInfo.BA_DEF_ROLE_SPRITE),
	COLLECTOR(WidgetInfo.BA_COLL_LISTEN_TEXT, WidgetInfo.BA_COLL_CALL_TEXT, WidgetInfo.BA_COLL_ROLE_TEXT, WidgetInfo.BA_COLL_ROLE_SPRITE),
	HEALER(WidgetInfo.BA_HEAL_LISTEN_TEXT, WidgetInfo.BA_HEAL_CALL_TEXT, WidgetInfo.BA_HEAL_ROLE_TEXT, WidgetInfo.BA_HEAL_ROLE_SPRITE);

	private final WidgetInfo listen;
	private final WidgetInfo call;
	private final WidgetInfo roleText;
	private final WidgetInfo roleSprite;

	Role(WidgetInfo listen, WidgetInfo call, WidgetInfo role, WidgetInfo roleSprite)
	{
		this.listen = listen;
		this.call = call;
		this.roleText = role;
		this.roleSprite = roleSprite;
	}

	@Override
	public String toString()
	{
		return name();
	}

	public WidgetInfo getListen()
	{
		return listen;
	}

	public WidgetInfo getCall()
	{
		return call;
	}

	public WidgetInfo getRoleText()
	{
		return roleText;
	}

	public WidgetInfo getRoleSprite()
	{
		return roleSprite;
	}
}
