package dev.ithundxr.qook.world;

import com.tterrag.registrate.util.entry.BlockEntry;
import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.block.BlossomLeavesBlock;
import dev.ithundxr.qook.mixin.AccessorTreeConfiguration;
import dev.ithundxr.qook.registry.QookBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.RandomSpreadFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.BendingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

import java.util.OptionalInt;

public class QookConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_BLOSSOM_KEY = registerKey("blue_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAVENDER_BLOSSOM_KEY = registerKey("lavender_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_BLOSSOM_KEY = registerKey("orange_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_BLOSSOM_KEY = registerKey("pink_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YELLOW_BLOSSOM_KEY = registerKey("yellow_blossom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_BLOSSOM_KEY = registerKey("red_blossom");

//    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_KEY = registerKey("ancient");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        registerBlossomTree(context, BLUE_BLOSSOM_KEY, QookBlocks.BLUE_BLOSSOM_LEAVES);
        registerBlossomTree(context, LAVENDER_BLOSSOM_KEY, QookBlocks.LAVENDER_BLOSSOM_LEAVES);
        registerBlossomTree(context, ORANGE_BLOSSOM_KEY, QookBlocks.ORANGE_BLOSSOM_LEAVES);
        registerBlossomTree(context, PINK_BLOSSOM_KEY, QookBlocks.PINK_BLOSSOM_LEAVES);
        registerBlossomTree(context, YELLOW_BLOSSOM_KEY, QookBlocks.YELLOW_BLOSSOM_LEAVES);
        registerBlossomTree(context, RED_BLOSSOM_KEY, QookBlocks.RED_BLOSSOM_LEAVES);

        /*FeatureUtils.register(context, AZALEA_TREE, Feature.TREE, // override Azalea Tree
            new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(QookBlocks.AZALEA_LOG.get()),
                new BendingTrunkPlacer(4, 2, 0, 3, UniformInt.of(1, 2)),
                new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                    .add(Blocks.AZALEA_LEAVES.defaultBlockState(), 3)
                    .add(Blocks.FLOWERING_AZALEA_LEAVES.defaultBlockState(), 1)),
                new RandomSpreadFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), ConstantInt.of(2), 50),
                new TwoLayersFeatureSize(1, 0, 1))
                .dirt(BlockStateProvider.simple(Blocks.ROOTED_DIRT))
                .forceDirt()
                .build()
        );*/


//        register(context, ANCIENT_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
//                BlockStateProvider.simple(QookBlocks.ANCIENT_LOG.get()),
//                new StraightTrunkPlacer(6, 1, 3),
//                BlockStateProvider.simple(QookBlocks.ANCIENT_LEAVES.get()),
//                new SpruceFoliagePlacer(UniformInt.of(1, 3), UniformInt.of(2, 3), UniformInt.of(3, 3)),
//                new TwoLayersFeatureSize(3, 1, 3))
//                .ignoreVines()
//                .build());
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

    @SuppressWarnings("unchecked")
    public static void overrideAzaleaTrunk(MinecraftServer server) {
        /*context.lookup(Registries.CONFIGURED_FEATURE).get(TreeFeatures.AZALEA_TREE).ifPresent((ref) -> {
            ConfiguredFeature<?, ?> feature = ref.value();
            if (feature.config() instanceof TreeConfiguration treeConfiguration) {
                Qook.LOGGER.info("Replaced trunk for Azalea Tree");
                ((AccessorTreeConfiguration)treeConfiguration).setTrunkProvider(BlockStateProvider.simple(QookBlocks.AZALEA_LOG.get()));
            }
        });*/

        ConfiguredFeature<TreeConfiguration, ?> configured = null;
        try {
            configured = (ConfiguredFeature<TreeConfiguration, ?>) server.registryAccess()
                .registryOrThrow(Registries.CONFIGURED_FEATURE).getOrThrow(TreeFeatures.AZALEA_TREE);
        } catch (IllegalStateException e) {
            Qook.LOGGER.error("Failed to replace Azalea trunk");
            e.printStackTrace();
        }

        if (configured != null) {
            TreeConfiguration config = configured.config();
            ((AccessorTreeConfiguration) config).setTrunkProvider(BlockStateProvider.simple(QookBlocks.AZALEA_LOG.get()));
        }
    }
}
