package dev.ithundxr.qook.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class BlossomLeaves extends LeavesBlock {

    public BlossomLeaves(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(@Nonnull BlockState stateIn, @NotNull Level worldIn, @NotNull BlockPos pos, @Nonnull RandomSource rand) {
        if (rand.nextInt(5) == 0 && worldIn.isEmptyBlock(pos.below())) {
            double windStrength = 5 + Math.cos((double) worldIn.getGameTime() / 2000) * 2;
            double windX = Math.cos((double) worldIn.getGameTime() / 1200) * windStrength;
            double windZ = Math.sin((double) worldIn.getGameTime() / 1000) * windStrength;

            worldIn.addParticle(new BlockParticleOption(ParticleTypes.BLOCK, stateIn), pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, windX, -1.0, windZ);
        }

        super.animateTick(stateIn, worldIn, pos, rand);
    }
}
