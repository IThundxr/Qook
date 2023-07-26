package dev.ithundxr.qook.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LadderBlock.class)
public class LadderBlockMixin {
    @Inject(method = "canSurvive", at = @At("HEAD"), cancellable = true)
    private void canSurvive(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (canLadderSurvive(state, level, pos)) {
            cir.setReturnValue(true);
            cir.cancel();
        }
    }

    @Inject(method = "updateShape", at = @At("HEAD"), cancellable = true)
    private void updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos, CallbackInfoReturnable<BlockState> cir) {
        if(!canLadderSurvive(state, world, currentPos)) {
            cir.setReturnValue(Blocks.AIR.defaultBlockState());
            cir.cancel();
        }
    }

    @Unique
    private static boolean canLadderSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction facing = state.getValue(LadderBlock.FACING);
        Direction opposite = facing.getOpposite();
        BlockPos oppositePos = pos.relative(opposite);
        BlockState oppositeState = level.getBlockState(oppositePos);

        boolean solid = facing.getAxis() != Direction.Axis.Y && oppositeState.isFaceSturdy(level, oppositePos, facing) && !(oppositeState.getBlock() instanceof LadderBlock);
        BlockState topState = level.getBlockState(pos.above());
        return solid || (topState.getBlock() instanceof LadderBlock && (facing.getAxis() == Direction.Axis.Y || topState.getValue(LadderBlock.FACING) == facing));
    }
}
