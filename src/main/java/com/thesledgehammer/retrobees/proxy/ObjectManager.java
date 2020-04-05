/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.proxy;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IEnviromentBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.HashSet;
import java.util.Set;

public class ObjectManager {

	private final static Set<IItemColor> itemColorList = new HashSet<>();
	private final static Set<IBlockColor> blockColorList = new HashSet<>();
	
	public static void RegisterColors() {
		registerItemColor();
		registerBlockColor();
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerBlockClient(Block block) {
		if(block instanceof IBlockColor) {
			blockColorList.add((IBlockColor) block);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static void registerItemClient(Item item) {
		if(item instanceof IItemColor) {
			itemColorList.add((IItemColor) item);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static void registerItemColor() {
		for (IItemColor itemColor : itemColorList) {
			if (itemColor instanceof Item) {
				Minecraft.getInstance().getItemColors().register(ColoredItemItemColor.INSTANCE, (Item) itemColor);
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static void registerBlockColor() {
		for (IBlockColor blockColor : blockColorList) {
			if (blockColor instanceof Block) {
				Minecraft.getInstance().getBlockColors().register(ColoredBlockBlockColor.INSTANCE, (Block) blockColor);
			}
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class ColoredItemItemColor implements IItemColor {
		private static final ColoredItemItemColor INSTANCE = new ColoredItemItemColor();

		private ColoredItemItemColor() {

		}

		@Override
		public int getColor(ItemStack stack, int tintIndex) {
			Item item = stack.getItem();
			if(item instanceof IItemColor) {
				return ((IItemColor) item).getColor(stack, tintIndex);
			}
			return 0xffffff;
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class ColoredBlockBlockColor implements IBlockColor {
		private static final ColoredBlockBlockColor INSTANCE = new ColoredBlockBlockColor();

		private ColoredBlockBlockColor() {

		}

		@Override
		public int getColor(BlockState state, @Nullable IEnviromentBlockReader worldIn, @Nullable BlockPos pos, int tintIndex) {
			Block block = state.getBlock();
			if (block instanceof IBlockColor) {
				return ((IBlockColor) block).getColor(state, worldIn, pos, tintIndex);
			}
			return 0xffffff;
		}
	}
}
