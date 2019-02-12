package com.thesledgehammer.retrobees.bees.alleles;

import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeHousing;
import forestry.api.genetics.IEffectData;
import forestry.apiculture.genetics.alleles.AlleleEffect;
import moze_intel.projecte.utils.WorldTransmutations;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

import java.util.List;

public class AlleleEffectPhilosophersStone extends AlleleEffect {

    //AlleleBeeSpecies: parent1 and parent2
    //BeeSpecies must be related to the Philosophers Bee for this effect

    //Area: Territory
    //Speed: Rate of Block Change
    //Blocks to Change: Random transmutation into any allowed form of that block: e.g. stone could randomly transmutate into any other variant as provided by the philosphers stone

    public AlleleEffectPhilosophersStone() {
        super("transmutate", true);
    }

    @Override
    public IEffectData doEffect(IBeeGenome genome, IEffectData storedData, IBeeHousing housing) {
        World world = housing.getWorldObj();
        BlockPos housingPos = housing.getCoordinates();

        List<WorldTransmutations.Entry> transmutations = WorldTransmutations.getWorldTransmutations();

        double X = genome.getTerritory().getX();
        double Y = genome.getTerritory().getY();
        double Z = genome.getTerritory().getZ();


        Vec3i area = new Vec3i(X, Y, Z);

        int wait = 20;
        int counter = 0;

        //BlockPos randomPos = VectUtil.getRandomPositionInArea(world.rand, area);
        //BlockPos pos = randomPos.add(housingPos);

        //IBlockState result = WorldTransmutations.getWorldTransmutation(world, housingPos, false);
        //IBlockState resultAlt = WorldTransmutations.getWorldTransmutation(world, housingPos, true);
        //TODO: Implement area of effect from bee Territory
        //Alternate between a sneaking and non-sneaking with philosophers stone

        for(EnumFacing face : EnumFacing.VALUES) {
            BlockPos pos = housingPos.offset(face.getOpposite());
            if (world.isBlockLoaded(pos)) {
                IBlockState target = world.getBlockState(pos);
                Block block = target.getBlock();
                for(int i = 0; i < transmutations.size(); i++) {
                    if (block == transmutations.get(i).input.getBlock()) {
                        IBlockState result = WorldTransmutations.getWorldTransmutation(world, pos, true);
                        //TODO: Implement a time lag between each tranmutation
                        world.setBlockState(pos, result);
                    }
                }
            }
        }
        return storedData;
    }
}
