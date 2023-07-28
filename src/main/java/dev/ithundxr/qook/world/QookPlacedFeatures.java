package dev.ithundxr.qook.world;

import com.tterrag.registrate.util.entry.BlockEntry;
import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.block.BlossomLeavesBlock;
import dev.ithundxr.qook.registry.QookBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import org.intellij.lang.annotations.Identifier;

import java.util.List;
import java.util.OptionalInt;

public class QookPlacedFeatures {
    public static final ResourceKey<PlacedFeature> BLUE_BLOSSOM_PLACED_KEY = registerKey("blue_blossom_placed");
    public static final ResourceKey<PlacedFeature> LAVENDER_BLOSSOM_PLACED_KEY = registerKey("lavender_blossom_placed");
    public static final ResourceKey<PlacedFeature> ORANGE_BLOSSOM_PLACED_KEY = registerKey("orange_blossom_placed");
    public static final ResourceKey<PlacedFeature> PINK_BLOSSOM_PLACED_KEY = registerKey("pink_blossom_placed");
    public static final ResourceKey<PlacedFeature> YELLOW_BLOSSOM_PLACED_KEY = registerKey("yellow_blossom_placed");
    public static final ResourceKey<PlacedFeature> RED_BLOSSOM_PLACED_KEY = registerKey("red_blossom_placed");
    public static final ResourceKey<PlacedFeature> ANCIENT_PLACED_KEY = registerKey("ancient_placed");


    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.lookup(Registries.CONFIGURED_FEATURE);

        registerPlacedBlossomTree(context, BLUE_BLOSSOM_PLACED_KEY, configuredFeatureRegistryEntryLookup, QookConfiguredFeatures.BLUE_BLOSSOM_KEY, QookBlocks.BLUE_BLOSSOM_SAPLING);
        registerPlacedBlossomTree(context, LAVENDER_BLOSSOM_PLACED_KEY, configuredFeatureRegistryEntryLookup, QookConfiguredFeatures.LAVENDER_BLOSSOM_KEY, QookBlocks.LAVENDER_BLOSSOM_SAPLING);
        registerPlacedBlossomTree(context, ORANGE_BLOSSOM_PLACED_KEY, configuredFeatureRegistryEntryLookup, QookConfiguredFeatures.ORANGE_BLOSSOM_KEY, QookBlocks.ORANGE_BLOSSOM_SAPLING);
        registerPlacedBlossomTree(context, PINK_BLOSSOM_PLACED_KEY, configuredFeatureRegistryEntryLookup, QookConfiguredFeatures.PINK_BLOSSOM_KEY, QookBlocks.PINK_BLOSSOM_SAPLING);
        registerPlacedBlossomTree(context, YELLOW_BLOSSOM_PLACED_KEY, configuredFeatureRegistryEntryLookup, QookConfiguredFeatures.YELLOW_BLOSSOM_KEY, QookBlocks.YELLOW_BLOSSOM_SAPLING);
        registerPlacedBlossomTree(context, RED_BLOSSOM_PLACED_KEY, configuredFeatureRegistryEntryLookup, QookConfiguredFeatures.RED_BLOSSOM_KEY, QookBlocks.RED_BLOSSOM_SAPLING);

//        register(context, ANCIENT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(QookConfiguredFeatures.ANCIENT_KEY),
//                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2), QookBlocks.ANCIENT_SAPLING.get()));
    }

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, Qook.asResource(name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                                                                          Holder<ConfiguredFeature<?, ?>> configuration,
                                                                                          PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }

    private static void registerPlacedBlossomTree(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> placedKey, HolderGetter<ConfiguredFeature<?, ?>> configuredFeatureRegistryEntryLookup, ResourceKey<ConfiguredFeature<?, ?>> configuredKey, BlockEntry<SaplingBlock> saplingBlock) {
        register(context, placedKey, configuredFeatureRegistryEntryLookup.getOrThrow(configuredKey),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2), saplingBlock.get()));
    }
}
