package com.thesledgehammer.retrobees.bees.alleles;

import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.apiculture.genetics.alleles.AlleleEffect;
import moze_intel.projecte.utils.WorldTransmutations;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

public class AlleleEffectPhilosophersStone extends AlleleEffect {

    public AlleleEffectPhilosophersStone() {
        super("philosopher_stone", true);
    }

    @Override
    public IEffectData doEffect(IBeeGenome genome, IEffectData storedData, IBeeHousing housing) {
        World world = housing.getWorldObj();
        BlockPos housingPos = housing.getCoordinates();

        double X = genome.getTerritory().getX();
        double Y = genome.getTerritory().getY();
        double Z = genome.getTerritory().getZ();

        BlockPos minPos = housingPos.add(-X, -Y, -Z);
        BlockPos maxPos = housingPos.add(X, Y, Z);

        Iterable<BlockPos> iterable = BlockPos.getAllInBox(minPos, maxPos);
        ArrayList<BlockPos> list = new ArrayList<>();

        for(BlockPos curr : iterable) {
            if (world.isBlockLoaded(curr)) {
                list.add(curr);
            }
        }

        int blockPosSeed = generateRandomInteger(0, list.size() - 1);
        int blockStateSeed = generateRandomInteger(0, WorldTransmutations.getWorldTransmutations().size() - 1);

        BlockPos curr = list.get(blockPosSeed);
        if (world.isBlockLoaded(curr)) {
            IBlockState target = world.getBlockState(curr);
            Block block = target.getBlock();
            for (int i = 0; i < WorldTransmutations.getWorldTransmutations().size(); i++) {
                if (block == WorldTransmutations.getWorldTransmutations().get(i).input.getBlock()) {
                    if(blockStateSeed % 2 == 0) {
                        IBlockState result = WorldTransmutations.getWorldTransmutation(world, curr, true);
                        world.setBlockState(curr, result);
                    }
                    if(blockStateSeed % 2 != 0) {
                        IBlockState result = WorldTransmutations.getWorldTransmutation(world, curr, false);
                        world.setBlockState(curr, result);
                    }
                }
            }
        }
        return storedData;
    }

    private int generateRandomInteger(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }
}
