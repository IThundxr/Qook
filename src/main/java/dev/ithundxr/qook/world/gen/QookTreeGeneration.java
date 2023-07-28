package dev.ithundxr.qook.world.gen;

import dev.ithundxr.qook.world.QookPlacedFeatures;
import me.alphamode.forgetags.Tags;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class QookTreeGeneration {
    public static void generateTrees() {
        addBlossomTree(QookPlacedFeatures.BLUE_BLOSSOM_PLACED_KEY, Tags.Biomes.IS_SNOWY);
        addBlossomTree(QookPlacedFeatures.LAVENDER_BLOSSOM_PLACED_KEY, Tags.Biomes.IS_SWAMP);
        addBlossomTree(QookPlacedFeatures.ORANGE_BLOSSOM_PLACED_KEY, BiomeTags.IS_SAVANNA);
        addBlossomTree(QookPlacedFeatures.PINK_BLOSSOM_PLACED_KEY, BiomeTags.IS_MOUNTAIN);
        addBlossomTree(QookPlacedFeatures.YELLOW_BLOSSOM_PLACED_KEY, Tags.Biomes.IS_PLAINS);
        addBlossomTree(QookPlacedFeatures.RED_BLOSSOM_PLACED_KEY, BiomeTags.IS_BADLANDS);
    }

    public static void addBlossomTree(ResourceKey<PlacedFeature> key, TagKey<Biome> biomeTagKey) {
        BiomeModifications.addFeature(BiomeSelectors.tag(biomeTagKey),
                GenerationStep.Decoration.VEGETAL_DECORATION, key);
    }
}
