/**************************************************************************************************
 * Copyright (c) 2018 TheSledgeHammer.                                                            *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Lesser Public License v3                         *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/lgpl-3.0.txt                                                       *
 **************************************************************************************************/

package com.thesledgehammer.retrobees.misc;

import forestry.core.blocks.IColoredBlock;
import forestry.core.items.IColoredItem;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.BlockStateMapper;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.Set;

public class ObjectManager {

	private static final Minecraft minecraft = Minecraft.getMinecraft();
	private final static Set<IColoredItem> itemColorList = new HashSet<>();
	private final static Set<IColoredBlock> blockColorList = new HashSet<>();
	private final static Set<IStateMapper> stateMapperList = new HashSet<>();
	
	public static void ColorRegister() {
		registerItemColor();
		registerBlockColor();
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerBlockClient(Block block) {
		if(block instanceof IColoredBlock) {
			blockColorList.add((IColoredBlock) block);
		}
		if(block instanceof IStateMapper) {
			stateMapperList.add((IStateMapper) block);
		}

		for (IStateMapper stateMapper : stateMapperList) {
			if(stateMapper instanceof BlockStateMapper) {
				((BlockStateMapper) stateMapper).registerBlockStateMapper(block, stateMapper);
			}
		}
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerItemClient(Item item) {
		if(item instanceof IColoredItem) {
			itemColorList.add((IColoredItem) item);
		}
	}

	@SideOnly(Side.CLIENT)
	private static void registerItemColor() {
		final ItemColors itemColors = minecraft.getItemColors();
		for (IColoredItem itemColor : itemColorList) {
			if (itemColor instanceof Item) {
				itemColors.registerItemColorHandler(ColoredItemItemColor.INSTANCE, (Item) itemColor);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private static void registerBlockColor() {
		BlockColors blockColors = minecraft.getBlockColors();
		for (IColoredBlock blockColor : blockColorList) {
			if (blockColor instanceof Block) {
				blockColors.registerBlockColorHandler(ColoredBlockBlockColor.INSTANCE, (Block) blockColor);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	private static class ColoredItemItemColor implements IItemColor {
		private static final ColoredItemItemColor INSTANCE = new ColoredItemItemColor();

		private ColoredItemItemColor() {

		}

		@Override
		public int colorMultiplier(ItemStack stack, int tintIndex) {
			Item item = stack.getItem();
			if (item instanceof IColoredItem) {
				return ((IColoredItem) item).getColorFromItemstack(stack, tintIndex);
			}
			return 0xffffff;
		}
	}

	@SideOnly(Side.CLIENT)
	private static class ColoredBlockBlockColor implements IBlockColor {
		public static final ColoredBlockBlockColor INSTANCE = new ColoredBlockBlockColor();

		private ColoredBlockBlockColor() {

		}

		@Override
		public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
			Block block = state.getBlock();
			if (block instanceof IColoredBlock && worldIn != null && pos != null) {
				return ((IColoredBlock) block).colorMultiplier(state, worldIn, pos, tintIndex);
			}
			return 0xffffff;
		}
	}
}
