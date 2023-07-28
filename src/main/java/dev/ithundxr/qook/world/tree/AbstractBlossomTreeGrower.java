package dev.ithundxr.qook.world.tree;

import dev.ithundxr.qook.world.QookConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class AbstractBlossomTreeGrower extends AbstractTreeGrower {
    private final String color;

    public AbstractBlossomTreeGrower(String color) {
        this.color = color;
    }

    @Nullable
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource random, boolean hasFlowers) {
        ResourceKey<ConfiguredFeature<?, ?>> blossomType;
        switch (color) {
            case "blue" -> blossomType = QookConfiguredFeatures.BLUE_BLOSSOM_KEY;
            case "lavender" -> blossomType = QookConfiguredFeatures.LAVENDER_BLOSSOM_KEY;
            case "orange" -> blossomType = QookConfiguredFeatures.ORANGE_BLOSSOM_KEY;
            case "pink" -> blossomType = QookConfiguredFeatures.PINK_BLOSSOM_KEY;
            case "red" -> blossomType = QookConfiguredFeatures.RED_BLOSSOM_KEY;
            case "yellow" -> blossomType = QookConfiguredFeatures.YELLOW_BLOSSOM_KEY;
            default -> {
                return null;
            }
        }

        return blossomType;
    }
}