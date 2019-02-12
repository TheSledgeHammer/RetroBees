/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.items;

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

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemDropType extends ItemForestry implements IColoredItem, IInitModel {

	public ItemDropType() {
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setCreativeTab(Tabs.tabApiculture);
	}
	
	@Override
	public boolean isDamageable() {
		return false;
	}
	
	@Override
	public boolean isRepairable() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void initModel() {
		for(int i = 0; i < EnumDropType.VALUES.length; i++) {
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(this.getRegistryName(), "inventory"));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		EnumDropType honeyDrop = EnumDropType.VALUES[stack.getItemDamage()];
		return super.getUnlocalizedName(stack) + "." + honeyDrop.name;
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if(this.isInCreativeTab(tab)) {
			for(int i = 0; i < EnumDropType.VALUES.length; i++) {
				EnumDropType honeyDrop = EnumDropType.get(i);
				if(!honeyDrop.isSecret()) {
					subItems.add(new ItemStack(this, 1, i));
				}
			}
		}
	}

	@Nullable
	private static EnumDropType getRandomDropType(Random random, boolean includeSecret) {
		List<EnumDropType> validDrops = new ArrayList<>(EnumDropType.VALUES.length);
		for(int i = 0; i < EnumDropType.VALUES.length; i++) {
			EnumDropType honeyDrop = EnumDropType.get(i);
			if(!honeyDrop.isSecret() || includeSecret) {
				validDrops.add(honeyDrop);
			}
		}
		if(validDrops.isEmpty()) {
			return null;
		} else {
			return validDrops.get(random.nextInt(validDrops.size()));
		}
	}

	public ItemStack getRandomComb(int amount, Random random, boolean includeSecret) {
		EnumDropType honeyDrop = getRandomDropType(random, includeSecret);
		if(honeyDrop == null) {
			return ItemStack.EMPTY;
		}
		return getDrop(honeyDrop, amount);
	}
	
	public ItemStack getDrop(EnumDropType honeyDrop, int amount) {
		return new ItemStack(this, amount, honeyDrop.ordinal());
	}

	@Override
	public int getColorFromItemstack(ItemStack stack, int tintIndex) {
		EnumDropType drop = EnumDropType.VALUES[stack.getItemDamage()];
		return drop != null ? tintIndex == 0 ? drop.getPrimaryColor() : drop.getSecondaryColor() : 16777215;
	}
/*
	public ItemStack getWildcard() {
		return new ItemStack(this, 1, OreDictionary.WILDCARD_VALUE);
	}*/
}