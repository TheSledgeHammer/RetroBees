/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.items;

import com.thesledgehammer.retrobees.init.ModItems;
import com.thesledgehammer.retrobees.misc.IInitModel;
import forestry.api.core.Tabs;
import forestry.core.items.IColoredItem;
import forestry.core.items.ItemForestry;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class ItemCombType extends ItemForestry implements IColoredItem, IInitModel {
	
	public ItemCombType() {
		setMaxDamage(0);
		setHasSubtypes(true);
		setCreativeTab(Tabs.tabApiculture);
	}
	
	@Override
	public boolean isDamageable() {
		return false;
	}
	
	@Override
	public boolean isRepairable() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void initModel() {
		for(int i = 0; i < EnumCombType.VALUES.length; i++) {
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(Objects.requireNonNull(getRegistryName()), "inventory"));
		}
	}

	@Override
	@Nonnull
	public String getUnlocalizedName(ItemStack stack) {
		EnumCombType honeyComb = EnumCombType.VALUES[stack.getItemDamage()];
		return super.getUnlocalizedName(stack) + "." + honeyComb.name;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if(this.isInCreativeTab(tab)) {
			for(int i = 0; i < EnumCombType.VALUES.length; i++) {
				EnumCombType honeyComb = EnumCombType.get(i);
				if(!honeyComb.isSecret()) {
					subItems.add(new ItemStack(this, 1, i));
				}
			}
		}
	}

	@Nullable
	private static EnumCombType getRandomCombType(Random random, boolean includeSecret) {
		List<EnumCombType> validComb = new ArrayList<>(EnumCombType.VALUES.length);
		for(int i = 0; i < EnumCombType.VALUES.length; i++) {
			EnumCombType honeyComb = EnumCombType.get(i);
			if(!honeyComb.isSecret() || includeSecret) {
				validComb.add(honeyComb);
			}
		}
		if(validComb.isEmpty()) {
			return null;
		} else {
			return validComb.get(random.nextInt(validComb.size()));
		}
	}

	public ItemStack getRandomComb(int amount, Random random, boolean includeSecret) {
		EnumCombType honeyComb = getRandomCombType(random, includeSecret);
		if(honeyComb == null) {
			return ItemStack.EMPTY;
		}
		return getComb(honeyComb, amount);
	}
	
	public ItemStack getComb(EnumCombType honeyComb, int amount) {
		return new ItemStack(this, amount, honeyComb.ordinal());
	}

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {
		EnumCombType comb = EnumCombType.VALUES[stack.getItemDamage()];
		return comb != null ? tintIndex == 0 ? comb.getPrimaryColor() : comb.getSecondaryColor() : 16777215;
	}
/*
	public ItemStack getWildcard() {
		return new ItemStack(this, 1, OreDictionary.WILDCARD_VALUE);
	}*/
}
