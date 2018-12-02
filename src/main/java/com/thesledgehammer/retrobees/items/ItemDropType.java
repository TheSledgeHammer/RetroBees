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
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDropType extends Item implements IItemColor, IInitModel {

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

	@Override
	@SideOnly(Side.CLIENT)
	public void initModel() {
		for(int i = 0; i < EnumDropType.VALUES.length; i++) {
			ModelLoader.setCustomModelResourceLocation(this, i, new ModelResourceLocation(ModItems.HoneyDrop.getRegistryName(), "inventory"));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		EnumDropType honeyDrop = EnumDropType.VALUES[stack.getItemDamage()];
		return super.getUnlocalizedName(stack) + "." + honeyDrop.name;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if(this.isInCreativeTab(tab)) {
			for(int i = 0; i < EnumDropType.VALUES.length; i++) {
				subItems.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	public ItemStack getDrop(EnumDropType honeyDrop, int amount) {
		return new ItemStack(this, amount, honeyDrop.ordinal());
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		EnumDropType drop = EnumDropType.VALUES[stack.getItemDamage()];
		return drop != null ? tintIndex == 0 ? drop.getPrimaryColor() : drop.getSecondaryColor() : 16777215;
	}

	/*
	@SideOnly(Side.CLIENT)
	public void initModel() {
		ModelLoader.setCustomMeshDefinition(this, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(ModItems.HoneyDrop.getRegistryName(), "inventory");
			}
		});
	}
	*/
}
	