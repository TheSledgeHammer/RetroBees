package com.thesledgehammer.retrobees.items;

import com.thesledgehammer.retrobees.RetroBees;
import com.thesledgehammer.retrobees.init.ModItems;
import com.thesledgehammer.retrobees.init.ObjectBatchLoader;
import com.thesledgehammer.retrobees.misc.IInitModel;

import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCombType extends Item implements IInitModel, IItemColor {
	
	public ItemCombType() {
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
		this.setCreativeTab(RetroBees.creativeTab);
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
		ModelLoader.setCustomMeshDefinition(ModItems.BeeComb, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation(ModItems.BeeComb.getRegistryName(), "inventory");
			}
		});
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		EnumCombType honeyComb = EnumCombType.VALUES[stack.getItemDamage()];
		return super.getUnlocalizedName(stack) + "." + honeyComb.name;
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for(int i = 0; i < EnumCombType.VALUES.length; i++) {
			subItems.add(new ItemStack(this, 1, i));
		}
	}
	
	public ItemStack getComb(EnumCombType honeyComb, int amount) {
		return new ItemStack(this, amount, honeyComb.ordinal());
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		EnumCombType comb = EnumCombType.VALUES[stack.getItemDamage()];
		return comb != null ? (tintIndex == 0 ? comb.getPrimaryColor() : comb.getSecondaryColor()) : 16777215;
	}
}
