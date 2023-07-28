package dev.ithundxr.qook.world;

import com.tterrag.registrate.util.entry.BlockEntry;
import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.block.BlossomLeavesBlock;
import dev.ithundxr.qook.registry.QookBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;

import java.util.OptionalInt;

public class QookConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_BLOSSOM_KEY = registerKey("blue_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVENDER_BLOSSOM_KEY = registerKey("lavender_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_BLOSSOM_KEY = registerKey("orange_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_BLOSSOM_KEY = registerKey("pink_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_BLOSSOM_KEY = registerKey("yellow_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_BLOSSOM_KEY = registerKey("red_blossom");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        registerBlossomTree(context, BLUE_BLOSSOM_KEY, QookBlocks.BLUE_BLOSSOM_LEAVES);
        registerBlossomTree(context, LAVENDER_BLOSSOM_KEY, QookBlocks.LAVENDER_BLOSSOM_LEAVES);
        registerBlossomTree(context, ORANGE_BLOSSOM_KEY, QookBlocks.ORANGE_BLOSSOM_LEAVES);
        registerBlossomTree(context, PINK_BLOSSOM_KEY, QookBlocks.PINK_BLOSSOM_LEAVES);
        registerBlossomTree(context, YELLOW_BLOSSOM_KEY, QookBlocks.YELLOW_BLOSSOM_LEAVES);
        registerBlossomTree(context, RED_BLOSSOM_KEY, QookBlocks.RED_BLOSSOM_LEAVES);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Qook.asResource(name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static void registerBlossomTree(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, BlockEntry<BlossomLeavesBlock> blossomLeaves) {
        register(context, key, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(QookBlocks.BLOSSOM_LOG.get()),
                new FancyTrunkPlacer(8, 10, 10),
                BlockStateProvider.simple(blossomLeaves.get()),
                new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1), 4),
                new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4)))
                .ignoreVines()
                .build());
    }
}
