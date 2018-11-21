package com.thesledgehammer.retrobees.items;

import net.minecraft.util.IStringSerializable;

import java.awt.*;
import java.util.Locale;

public enum EnumDropType implements IStringSerializable {
	/**
	 * @param HoneyDrop Name, @param Primary Color, @param Secondary Color, @param (Optinal) IsSecret(true or false)
	 */
	//EMC Combs
	CHARGED(new Color(0x800505), new Color(0x9C0707)),
	OMEGA(new Color(0x191919), new Color(0x4A8CA7)),
	UUMATTER(new Color(0xFF1493), new Color(0xFF69B4), true),

	//Fluid Cell Combs
	CARBON(new Color(0x000000), new Color(0x525050)),
	DEUTERIUM(new Color(0xFFFF00), new Color(0xFFFF30)),
	HELIUM(new Color(0xF5F51E), new Color(0xF1F144)),
	HELIUM_3(new Color(0xBCBC1B), new Color(0xE9E929)),
	HELIUM_PLASMA(new Color(0xF5F6BD), new Color(0xF4F5C8)),
	HYDROGEN(new Color(0x043AFF), new Color(0x5A7DF8)),
	METHANE(new Color(0xFB05DE), new Color(0xFC62EA)),
	TRITIUM(new Color(0xFF0004), new Color(0xFC5F62)),
	WOLFRAMIUM(new Color(0x620F7E), new Color(0x712F86), true);

	public static final EnumDropType[] VALUES = values();

	public final String name;
	public final int primaryColor;
	public final int secondaryColor;
	private final boolean secret;

	EnumDropType(Color primary, Color secondary) {
		this(primary, secondary, false);
	}

	EnumDropType(Color primary, Color secondary, boolean secret) {
		this.name = toString().toLowerCase(Locale.ENGLISH);
		this.primaryColor = primary.getRGB();
		this.secondaryColor = secondary.getRGB();
		this.secret = secret;
	}

	public int getPrimaryColor() {
		return primaryColor;
	}

	public int getSecondaryColor() {
		return secondaryColor;
	}

	public boolean isSecret() {
		return secret;
	}

	@Override
	public String getName() {
		return name;
	}
}
