package dev.ithundxr.qook.util;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockStateHelper {
    public static final BlockBehaviour.StatePredicate NEVER_PREDICATE = (state, world, pos) -> false;
    public static final BlockBehaviour.StatePredicate ALWAYS_PREDICATE = (state, world, pos) -> true;
    public static final BlockBehaviour.StateArgumentPredicate<EntityType<?>> INVALID_SPAWN = (state, world, pos, type) -> false;
    public static final BlockBehaviour.StateArgumentPredicate<EntityType<?>> VALID_SPAWN = (state, world, pos, type) -> true;
}
