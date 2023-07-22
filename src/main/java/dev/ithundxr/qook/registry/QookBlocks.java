package dev.ithundxr.qook.registry;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.block.BlossomLeavesBlock;
import dev.ithundxr.qook.util.BlockStateHelper;
import io.github.fabricators_of_create.porting_lib.models.generators.ConfiguredModel;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;

public class QookBlocks {
    private static final Registrate REGISTRATE = Qook.REGISTRATE;

    private static BlockEntry<BlossomLeavesBlock> makeBlossomLeaves(String color, String name, MapColor mapColor) {
        return REGISTRATE.block(color + "_blossom_leaves" , BlossomLeavesBlock::new)
                .properties(p -> p
                        .mapColor(mapColor)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(SoundType.GRASS)
                        .noOcclusion()
                        .isValidSpawn(BlockStateHelper.INVALID_SPAWN)
                        .isSuffocating(BlockStateHelper.NEVER_PREDICATE)
                        .isViewBlocking(BlockStateHelper.NEVER_PREDICATE)
                )
                .addLayer(() -> RenderType::cutoutMipped)
                .lang(name + " Blossom Leaves")
                .item()
                .build()
                .register();
    }

    private static BlockEntry<RotatedPillarBlock> makeLogBlock(String name, MapColor color) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block( name + "_log" , RotatedPillarBlock::new)
                .initialProperties(() -> Blocks.OAK_LOG)
                .properties(p -> p
                        .mapColor(color)
                )
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStates((state) -> ConfiguredModel.builder()
                                        .modelFile(p.models().cubeColumn(c.getName(),
                                                        Qook.asResource("block/" + name + "_log"),
                                                        Qook.asResource("block/" + name + "_log_top"))
                                                .texture("particle", Qook.asResource("block/" + name + "_log"))
                                        )
                                .rotationX(90)
                                .build()
                        )
                )
                .lang(capitalizedName + " Log")
                .item()
                .build()
                .register();
    }

    // Blossom Leaves
    public static final BlockEntry<BlossomLeavesBlock> BLUE_BLOSSOM_LEAVES = makeBlossomLeaves("blue", "Frosty", MapColor.COLOR_LIGHT_BLUE);
    public static final BlockEntry<BlossomLeavesBlock> LAVENDER_BLOSSOM_LEAVES = makeBlossomLeaves("lavender", "Serene", MapColor.COLOR_PINK);
    public static final BlockEntry<BlossomLeavesBlock> ORANGE_BLOSSOM_LEAVES = makeBlossomLeaves("orange", "Warm", MapColor.TERRACOTTA_ORANGE);
    public static final BlockEntry<BlossomLeavesBlock> PINK_BLOSSOM_LEAVES = makeBlossomLeaves("pink", "Sweet", MapColor.COLOR_PINK);
    public static final BlockEntry<BlossomLeavesBlock> YELLOW_BLOSSOM_LEAVES = makeBlossomLeaves("yellow", "Sunny", MapColor.COLOR_YELLOW);
    public static final BlockEntry<BlossomLeavesBlock> RED_BLOSSOM_LEAVES = makeBlossomLeaves("red", "Fiery", MapColor.COLOR_RED);
    // Blossom Log
    public static final BlockEntry<RotatedPillarBlock> BLOSSOM_LOG = makeLogBlock("blossom", MapColor.COLOR_BROWN);

    public static void register() {
        // fabric: just load the class
    }
}
