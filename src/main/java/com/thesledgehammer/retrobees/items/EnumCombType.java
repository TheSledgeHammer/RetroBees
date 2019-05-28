/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.items;

import net.minecraft.util.IStringSerializable;

import java.awt.*;
import java.util.Locale;

public enum EnumCombType implements IStringSerializable {
	/**
	 * @param HoneyComb Name, @param Primary Color, @param Secondary Color, @param (Optinal) IsSecret(true or false)
	 */

	/*
	NEXT RELEASE: 1.2.0
	ALLOYS:
	REFINED_IRON(new Color(TBA), new Color(0xE8D56A)),
	BRONZE(new Color(TBA), new Color(0xE8D56A)),
	MIXED_METAL(new Color(TBA), new Color(0xE8D56A)),
	ADVANCED_ALLOY(new Color(TBA), new Color(0xE8D56A)),
	IRIDIUM_ALLOY(new Color(TBA), new Color(0xE8D56A)),
	*/

	//Energy Matter Convertis
	DARKENED(new Color(0x33EBCB), new Color(0xE8D56A)),
	REDDENED(new Color(0x6200E7), new Color(0xE8D56A)),
	OMEGA(new Color(0x6DCFF6), new Color(0xE8D56A)),
	DARKMATTER(new Color(0x470E51), new Color(0xE8D56A)),
	REDMATTER(new Color(0x870606), new Color(0xE8D56A)),
	//Transmutated
	PHILOSOPHERS(new Color(0xC60310/*Change this Colour*/), new Color(0xE8D56A)),
	ALCHEMICAL_COAL(new Color(0xC60310), new Color(0xE8D56A)),
	MOBIUS(new Color(0x870009), new Color(0xE8D56A)),
	AETERNALIS(new Color(0x9D9D9D), new Color(0xE8D56A)),

	REDSTONE(new Color(0x490000), new Color(0xE8D56A)),
	GLOWSTONE(new Color(0x868600), new Color(0xE8D56A)),
	//Oscillate
	COAL(new Color(0x070707), new Color(0xE8D56A)),
	IRON(new Color(0xBCBCBC), new Color(0xE8D56A)),
	COPPER(new Color(0xBB6F4D), new Color(0xE8D56A)),
	SILVER(new Color(0xC9D7D9), new Color(0xE8D56A)),
	GOLD(new Color(0xF2DA57), new Color(0xE8D56A)),
	//Scintillate
	TIN(new Color(0xF1F1F1), new Color(0xE8D56A)),
	ALUMINUM(new Color(0xDADDDD), new Color(0xE8D56A)),
	LEAD(new Color(0x615D68), new Color(0xE8D56A)),
	//Luminesce
	RUBY(new Color(0xD32B37), new Color(0xE8D56A)),
	SAPPHIRE(new Color(0x3979BE), new Color(0xE8D56A)),
	DIAMOND(new Color(0x8CF4E2), new Color(0xE8D56A)),
	EMERALD(new Color(0x50C878), new Color(0xE8D56A)),
	//Phosphoresce
	SULFUR(new Color(0xBD8742), new Color(0xE8D56A)),
	CALCITE(new Color(0xBFB18A), new Color(0xE8D56A)),
	PHOSPHOROUS(new Color(0xC2B15A), new Color(0xE8D56A)),
	//Coruscate
	GALENA(new Color(0x625864), new Color(0xE8D56A)),
	GARNIERITE(new Color(0x95C74E), new Color(0xE8D56A)),
	BAUXITE(new Color(0x7b4028), new Color(0xE8D56A)),
	//Fulgurate
	RED_GARNET(new Color(0xA03A3F), new Color(0xE8D56A)),
	YELLOW_GARNET(new Color(0xB29A69), new Color(0xE8D56A)),
	//Obfuscate
	MAGNESIUM(new Color(0xAF8F8F), new Color(0xE8D56A)),
	MANGANESE(new Color(0xBCCCC3), new Color(0xE8D56A)),
	//Monotonous
	ENDER_PEARL(new Color(0x063931), new Color(0xE8D56A)),
	PERIDOT(new Color(0x98DA49), new Color(0xE8D56A)),
	SODALITE(new Color(0x2B3E52), new Color(0xE8D56A)),
	TUNGSTEN(new Color(0x4F5559), new Color(0xE8D56A)),
	//Cadaverousness
	NETHER_QUARTZ(new Color(0xDFD8CF), new Color(0xE8D56A)),
	PYRITE(new Color(0xEC9B7F), new Color(0xE8D56A)),
	CINNABAR(new Color(0xB18073), new Color(0xE8D56A)),
	SPHALERITE(new Color(0x96A164), new Color(0xE8D56A)),
	//Platitudinous
	PYROPE(new Color(0x5D3753), new Color(0xE8D56A)),
	SPESSARTINE(new Color(0xA44A45), new Color(0xE8D56A)),
	//Achromatic
	ALMANDINE(new Color(0xD96763), new Color(0xE8D56A)),
	UVAROVITE(new Color(0x50FF50), new Color(0xE8D56A)),
	CHROME(new Color(0xFFEEF3), new Color(0xE8D56A)),
	//Irradiate
	PLATINUM(new Color(0xE5E4E2), new Color(0xE8D56A)),
	TITANIUM(new Color(0xD3D3DD), new Color(0xE8D56A)),
	IRIDIUM(new Color(0x3D3C3A), new Color(0xE8D56A)),
	UUMATTER(new Color(0xFF1493), new Color(0xE8D56A)),
	//Sepulchral
	CARBON(new Color(0x000000), new Color(0xE8D56A)),
	METHANE(new Color(0xFB05DE), new Color(0xE8D56A)),
	//Anemic
	HYDROGEN(new Color(0x043AFF), new Color(0xE8D56A)),
	DEUTERIUM(new Color(0xFFFF00), new Color(0xE8D56A)),
	TRITIUM(new Color(0xFF0004), new Color(0xE8D56A)),
	//Radiate
	HELIUM_3(new Color(0xBCBC1B), new Color(0xE8D56A)),
	HELIUM_PLASMA(new Color(0xF5F6BD), new Color(0xE8D56A)),
	HELIUM(new Color(0xF5F51E), new Color(0xE8D56A)),

	WOLFRAMIUM(new Color(0x620F7E), new Color(0xE8D56A), true);

	public static final EnumCombType[] VALUES = values();

	public final String name;
	public final int primaryColor;
	public final int secondaryColor;
	private final boolean secret;

	EnumCombType(Color primary, Color secondary) {
		this(primary, secondary, false);
	}

	EnumCombType(Color primary, Color secondary, boolean secret) {
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

	public static EnumCombType get(int meta) {
		if(meta >= VALUES.length) {
			meta = 0;
		}
		return VALUES[meta];
	}
}
