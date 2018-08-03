package com.thesledgehammer.retrobees.bees.mutation;

import com.thesledgehammer.retrobees.recipes.EmcRecipes;

import forestry.api.apiculture.BeeManager;
import forestry.api.apiculture.IAlleleBeeSpecies;
import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.apiculture.IBeeMutation;
import forestry.api.apiculture.IBeeMutationBuilder;
import forestry.api.apiculture.IBeeRoot;
import forestry.api.genetics.IAllele;
import forestry.api.genetics.IAlleleSpecies;
import forestry.core.genetics.mutations.Mutation;
import moze_intel.projecte.api.tile.IEmcProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BeeMutationEMC extends Mutation implements IBeeMutation, IBeeMutationBuilder {

	protected BeeMutationEMC(IAlleleSpecies species0, IAlleleSpecies species1, IAllele[] template, int chance) {
		super(species0, species1, template, chance);
	}

	@Override
	public IBeeMutation build() {
		return this;
	}

	@Override
	public IBeeRoot getRoot() {
		return BeeManager.beeRoot;
	}

	@Override
	public float getChance(IBeeHousing housing, IAlleleBeeSpecies allele0, IAlleleBeeSpecies allele1, IBeeGenome genome0, IBeeGenome genome1) {
		World world = housing.getWorldObj();
		BlockPos housingPos = housing.getCoordinates();

		float chance = super.getChance(world, housingPos, allele0, allele1, genome0, genome1, housing);
		
		double emcStored = 0;
		double emcRequired = 0;
		
		for (EnumFacing face : EnumFacing.VALUES) {
			TileEntity tile = housing.getWorldObj().getTileEntity(housingPos.offset(face.getOpposite()));
			if (tile instanceof IEmcProvider) {
				IEmcProvider emc = (IEmcProvider) tile;
				
				emcStored = emc.getStoredEmc();
				
				//Get matching Recipe from EmcRecipes
				for (int i = 0; i < EmcRecipes.emcMutation.size(); i++) {
					if (EmcRecipes.emcMutation.getRecipes().contains(allele0, allele1)) {
						if (EmcRecipes.emcMutation.getRecipes().get(allele0, allele1) != null) {
							emcRequired = EmcRecipes.emcMutation.getRecipes().get(allele0, allele1);
						}
					}
					//Swap alleles to match alternate queen & drone mating 
					if(EmcRecipes.emcMutation.getRecipes().contains(allele1, allele0)) {
						//Swap alleles back to registered recipe
						if(EmcRecipes.emcMutation.getRecipes().get(allele0, allele1) != null) {
							emcRequired = EmcRecipes.emcMutation.getRecipes().get(allele0, allele1);
						}
					}
				}
				
				if (emcStored < emcRequired) {
					//emc.provideEMC(face, emcStored);
					return 0;
				}
				
				if (emcStored >= emcRequired) {
					emc.provideEMC(face, emcRequired);
					return 100;
				}
			}
		}
		return chance;
	}
}

/*
 * TileEmc: Works IEmcProvider: Works IEmcStorage: Works IEmcAcceptor: Works
 */
