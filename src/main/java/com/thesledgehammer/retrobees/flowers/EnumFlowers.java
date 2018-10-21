package com.thesledgehammer.retrobees.flowers;

import forestry.apiculture.flowers.FlowerProvider;
import forestry.core.genetics.alleles.IAlleleValue;

import java.util.Locale;

public enum EnumFlowers implements IAlleleValue<FlowerProvider> {
	DARKMATTER(FlowerRegister.FlowerDarkMatter, true),
	REDMATTER(FlowerRegister.FlowerRedMatter, false),
	IRON(FlowerRegister.FlowerIron, true),
	GOLD(FlowerRegister.FlowerGold, false),
	COPPER(FlowerRegister.FlowerCopper, true),
	SILVER(FlowerRegister.FlowerSilver, false),
	LEAD(FlowerRegister.FlowerLead, true),
	TIN(FlowerRegister.FlowerTin, false),
	ALUMINUM(FlowerRegister.FlowerAluminium, true),
	GALENA(FlowerRegister.FlowerGalena, false),
	RUBY(FlowerRegister.FlowerRuby, true),
	SAPPHIRE(FlowerRegister.FlowerSapphire, false),
	BAUXITE(FlowerRegister.FlowerBauxite, true),
	CINNABAR(FlowerRegister.FlowerCinnabar, false),
	SPHALERITE(FlowerRegister.FlowerSphalerite, true),
	TUNGSTEN(FlowerRegister.FlowerTungsten, false),
	PERIDOT(FlowerRegister.FlowerPeridot, true),
	SODALITE(FlowerRegister.FlowerSodalite, false),
	IRIDIUM(FlowerRegister.FlowerIridium, true),
	PYRITE(FlowerRegister.FlowerPyrite, false),
	SHELDONITE(FlowerRegister.FlowerSheldonite, true);

	public static final EnumFlowers[] VALUES = values();

	private final FlowerProvider value;
	private final boolean dominant;

	EnumFlowers(String flowerType) {
		this(flowerType, false);
	}

	EnumFlowers(String flowerType, boolean dominant) {
		String lowercase = toString().toLowerCase(Locale.ENGLISH);
		this.value = new FlowerProvider(flowerType, "for.flowers." + lowercase);
		this.dominant = dominant;
	}

	@Override
	public FlowerProvider getValue() {
		return value;
	}

	@Override
	public boolean isDominant() {
		return dominant;
	}
}
