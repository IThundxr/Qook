package dev.ithundxr.qook.registry;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.block.BlossomLeavesBlock;
import dev.ithundxr.qook.util.BlockStateHelper;
import dev.ithundxr.qook.world.tree.AbstractAncientTreeGrower;
import dev.ithundxr.qook.world.tree.AbstractBlossomTreeGrower;
import io.github.fabricators_of_create.porting_lib.models.generators.ConfiguredModel;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

// Ignore these errors that have no purpose lol
@SuppressWarnings({"unused", "SameParameterValue", "Duplicates"})
public class QookBlocks {
    private static final Registrate REGISTRATE = Qook.REGISTRATE;


    // Ancient Sapling
    public static final BlockEntry<SaplingBlock> ANCIENT_SAPLING = makeSaplingBlock("ancient", MapColor.TERRACOTTA_WHITE, new AbstractAncientTreeGrower());
    
    // Ancient Leaves
    public static final BlockEntry<LeavesBlock> ANCIENT_LEAVES = makeLeavesBlock("ancient", MapColor.TERRACOTTA_WHITE, ANCIENT_SAPLING,true);

    // Ancient Logs
    public static final BlockEntry<RotatedPillarBlock> ANCIENT_LOG = makeLogBlock("ancient", MapColor.TERRACOTTA_WHITE, MapColor.TERRACOTTA_WHITE, QookTags.QookItemTags.ANCIENT_LOGS, true);
    public static final BlockEntry<RotatedPillarBlock> STRIPPED_ANCIENT_LOG = makeStrippedLogBlock("ancient", MapColor.TERRACOTTA_WHITE, QookTags.QookItemTags.ANCIENT_LOGS, true);

    // Ancient Woods
    public static final BlockEntry<RotatedPillarBlock> ANCIENT_WOOD = makeWoodBlock("ancient", MapColor.COLOR_BROWN, QookTags.QookItemTags.ANCIENT_LOGS, true);
    public static final BlockEntry<RotatedPillarBlock> STRIPPED_ANCIENT_WOOD = makeStrippedWoodBlock("ancient", MapColor.TERRACOTTA_WHITE, QookTags.QookItemTags.ANCIENT_LOGS, true);

    // Ancient Planks
    public static final BlockEntry<Block> ANCIENT_PLANKS = makePlanksBlock("ancient", MapColor.TERRACOTTA_WHITE, true);

    // Ancient Slabs
    public static final BlockEntry<SlabBlock> ANCIENT_SLABS = makeSlabsBlock("ancient", MapColor.TERRACOTTA_WHITE, true);

    // Ancient Stairs
    public static final BlockEntry<StairBlock> ANCIENT_STAIRS = makeStairsBlock("ancient", MapColor.TERRACOTTA_WHITE, true);

    // Ancient Fence
    public static final BlockEntry<FenceBlock> ANCIENT_FENCE = makeFenceBlock("ancient", MapColor.TERRACOTTA_WHITE, true);

    // Ancient Fence Gate
    public static final BlockEntry<FenceGateBlock> ANCIENT_FENCE_GATE = makeFenceGateBlock("ancient", MapColor.TERRACOTTA_WHITE, true);

    // Ancient Door
    public static final BlockEntry<DoorBlock> ANCIENT_DOOR = makeDoorBlockWithRenderType("ancient", MapColor.TERRACOTTA_WHITE, true, RenderType::cutout);

    // Ancient Trapdoor
    public static final BlockEntry<TrapDoorBlock> ANCIENT_TRAPDOOR = makeTrapDoorBlockWithRenderType("ancient", MapColor.TERRACOTTA_WHITE, true, RenderType::cutout);

    // Ancient Button
    public static final BlockEntry<ButtonBlock> ANCIENT_BUTTON = makeButtonBlock("ancient", MapColor.TERRACOTTA_WHITE);

    // Ancient Pressure Plate
    public static final BlockEntry<PressurePlateBlock> ANCIENT_PRESSURE_PLATE = makePressurePlateBlock("ancient", MapColor.TERRACOTTA_WHITE, true);

    // Ancient Ladder
    public static final BlockEntry<LadderBlock> ANCIENT_LADDER = makeLadderBlock("ancient", MapColor.TERRACOTTA_WHITE);

    // Vertical Ancient Planks
    public static final BlockEntry<Block> VERTICAL_ANCIENT_PLANKS = makeVerticalPlanksBlock("ancient", MapColor.TERRACOTTA_WHITE, true);



    // Azalea Logs
    public static final BlockEntry<RotatedPillarBlock> AZALEA_LOG = makeLogBlock("azalea", MapColor.COLOR_LIGHT_GREEN, MapColor.COLOR_BROWN, QookTags.QookItemTags.AZALEA_LOGS, true);
    public static final BlockEntry<RotatedPillarBlock> STRIPPED_AZALEA_LOG = makeStrippedLogBlock("azalea", MapColor.COLOR_LIGHT_GREEN, QookTags.QookItemTags.AZALEA_LOGS, true);

    // Azalea Woods
    public static final BlockEntry<RotatedPillarBlock> AZALEA_WOOD = makeWoodBlock("azalea", MapColor.COLOR_BROWN, QookTags.QookItemTags.AZALEA_LOGS, true);
    public static final BlockEntry<RotatedPillarBlock> STRIPPED_AZALEA_WOOD = makeStrippedWoodBlock("azalea", MapColor.COLOR_LIGHT_GREEN, QookTags.QookItemTags.AZALEA_LOGS, true);

    // Azalea Planks
    public static final BlockEntry<Block> AZALEA_PLANKS = makePlanksBlock("azalea", MapColor.COLOR_LIGHT_GREEN, true);

    // Azalea Slabs
    public static final BlockEntry<SlabBlock> AZALEA_SLABS = makeSlabsBlock("azalea", MapColor.COLOR_LIGHT_GREEN, true);

    // Azalea Stairs
    public static final BlockEntry<StairBlock> AZALEA_STAIRS = makeStairsBlock("azalea", MapColor.COLOR_LIGHT_GREEN, true);

    // Azalea Fence
    public static final BlockEntry<FenceBlock> AZALEA_FENCE = makeFenceBlock("azalea", MapColor.COLOR_LIGHT_GREEN, true);

    // Azalea Fence Gate
    public static final BlockEntry<FenceGateBlock> AZALEA_FENCE_GATE = makeFenceGateBlock("azalea", MapColor.COLOR_LIGHT_GREEN, true);

    // Azalea Door
    public static final BlockEntry<DoorBlock> AZALEA_DOOR = makeDoorBlockWithRenderType("azalea", MapColor.COLOR_LIGHT_GREEN, true, RenderType::cutout);

    // Azalea Trapdoor
    public static final BlockEntry<TrapDoorBlock> AZALEA_TRAPDOOR = makeTrapDoorBlockWithRenderType("azalea", MapColor.COLOR_LIGHT_GREEN, true, RenderType::cutout);

    // Azalea Button
    public static final BlockEntry<ButtonBlock> AZALEA_BUTTON = makeButtonBlock("azalea", MapColor.COLOR_LIGHT_GREEN);

    // Azalea Pressure Plate
    public static final BlockEntry<PressurePlateBlock> AZALEA_PRESSURE_PLATE = makePressurePlateBlock("azalea", MapColor.COLOR_LIGHT_GREEN, true);

    // Azalea Ladder
    public static final BlockEntry<LadderBlock> AZALEA_LADDER = makeLadderBlock("azalea", MapColor.COLOR_LIGHT_GREEN);

    // Vertical AzaleaPlanks
    public static final BlockEntry<Block> VERTICAL_AZALEA_PLANKS = makeVerticalPlanksBlock("azalea", MapColor.COLOR_LIGHT_GREEN, true);



    // BLossom Saplings
    // Blossom Saplings
    public static final BlockEntry<SaplingBlock> BLUE_BLOSSOM_SAPLING = makeBlossomSaplingBlock("blue", "Frosty", MapColor.COLOR_LIGHT_BLUE, new AbstractBlossomTreeGrower("blue"));
    public static final BlockEntry<SaplingBlock> LAVENDER_BLOSSOM_SAPLING = makeBlossomSaplingBlock("lavender", "Serene", MapColor.COLOR_PINK, new AbstractBlossomTreeGrower("lavender"));
    public static final BlockEntry<SaplingBlock> ORANGE_BLOSSOM_SAPLING = makeBlossomSaplingBlock("orange", "Warm", MapColor.TERRACOTTA_ORANGE, new AbstractBlossomTreeGrower("orange"));
    public static final BlockEntry<SaplingBlock> PINK_BLOSSOM_SAPLING = makeBlossomSaplingBlock("pink", "Sweet", MapColor.COLOR_PINK, new AbstractBlossomTreeGrower("pink"));
    public static final BlockEntry<SaplingBlock> YELLOW_BLOSSOM_SAPLING = makeBlossomSaplingBlock("yellow", "Sunny", MapColor.COLOR_YELLOW, new AbstractBlossomTreeGrower("yellow"));
    public static final BlockEntry<SaplingBlock> RED_BLOSSOM_SAPLING = makeBlossomSaplingBlock("red", "Fiery", MapColor.COLOR_RED, new AbstractBlossomTreeGrower("red"));


    // Blossom Leaves
    public static final BlockEntry<BlossomLeavesBlock> BLUE_BLOSSOM_LEAVES = makeBlossomLeavesBlock("blue", "Frosty", MapColor.COLOR_LIGHT_BLUE, BLUE_BLOSSOM_SAPLING,true);
    public static final BlockEntry<BlossomLeavesBlock> LAVENDER_BLOSSOM_LEAVES = makeBlossomLeavesBlock("lavender", "Serene", MapColor.COLOR_PINK, LAVENDER_BLOSSOM_SAPLING,true);
    public static final BlockEntry<BlossomLeavesBlock> ORANGE_BLOSSOM_LEAVES = makeBlossomLeavesBlock("orange", "Warm", MapColor.TERRACOTTA_ORANGE, ORANGE_BLOSSOM_SAPLING,true);
    public static final BlockEntry<BlossomLeavesBlock> PINK_BLOSSOM_LEAVES = makeBlossomLeavesBlock("pink", "Sweet", MapColor.COLOR_PINK, PINK_BLOSSOM_SAPLING,true);
    public static final BlockEntry<BlossomLeavesBlock> YELLOW_BLOSSOM_LEAVES = makeBlossomLeavesBlock("yellow", "Sunny", MapColor.COLOR_YELLOW, YELLOW_BLOSSOM_SAPLING,true);
    public static final BlockEntry<BlossomLeavesBlock> RED_BLOSSOM_LEAVES = makeBlossomLeavesBlock("red", "Fiery", MapColor.COLOR_RED, RED_BLOSSOM_SAPLING,true);

    // Blossom Logs
    public static final BlockEntry<RotatedPillarBlock> BLOSSOM_LOG = makeLogBlock("blossom", MapColor.COLOR_RED, MapColor.COLOR_BROWN, QookTags.QookItemTags.BLOSSOM_LOGS, true);
    public static final BlockEntry<RotatedPillarBlock> STRIPPED_BLOSSOM_LOG = makeStrippedLogBlock("blossom", MapColor.COLOR_RED, QookTags.QookItemTags.BLOSSOM_LOGS, true);

    // Blossom Woods
    public static final BlockEntry<RotatedPillarBlock> BLOSSOM_WOOD = makeWoodBlock("blossom", MapColor.COLOR_BROWN, QookTags.QookItemTags.BLOSSOM_LOGS, true);
    public static final BlockEntry<RotatedPillarBlock> STRIPPED_BLOSSOM_WOOD = makeStrippedWoodBlock("blossom", MapColor.COLOR_RED, QookTags.QookItemTags.BLOSSOM_LOGS, true);

    // Blossom Planks
    public static final BlockEntry<Block> BLOSSOM_PLANKS = makePlanksBlock("blossom", MapColor.COLOR_RED, true);

    // Blossom Slabs
    public static final BlockEntry<SlabBlock> BLOSSOM_SLABS = makeSlabsBlock("blossom", MapColor.COLOR_RED, true);

    // Blossom Stairs
    public static final BlockEntry<StairBlock> BLOSSOM_STAIRS = makeStairsBlock("blossom", MapColor.COLOR_RED, true);

    // Blossom Fence
    public static final BlockEntry<FenceBlock> BLOSSOM_FENCE = makeFenceBlock("blossom", MapColor.COLOR_RED, true);

    // Blossom Fence Gate
    public static final BlockEntry<FenceGateBlock> BLOSSOM_FENCE_GATE = makeFenceGateBlock("blossom", MapColor.COLOR_RED, true);

    // Blossom Door
    public static final BlockEntry<DoorBlock> BLOSSOM_DOOR = makeDoorBlock("blossom", MapColor.COLOR_RED, true);

    // Blossom Trapdoor
    public static final BlockEntry<TrapDoorBlock> BLOSSOM_TRAPDOOR = makeTrapDoorBlock("blossom", MapColor.COLOR_RED, true);

    // Blossom Button
    public static final BlockEntry<ButtonBlock> BLOSSOM_BUTTON = makeButtonBlock("blossom", MapColor.COLOR_RED);

    // Blossom Pressure Plate
    public static final BlockEntry<PressurePlateBlock> BLOSSOM_PRESSURE_PLATE = makePressurePlateBlock("blossom", MapColor.COLOR_RED, true);

    // Blossom Ladder
    public static final BlockEntry<LadderBlock> BLOSSOM_LADDER = makeLadderBlock("blossom", MapColor.COLOR_RED);

    // Vertical Blossom Planks
    public static final BlockEntry<Block> VERTICAL_BLOSSOM_PLANKS = makeVerticalPlanksBlock("blossom", MapColor.COLOR_RED, true);








    // Hello! this funny space helps me stay sane
    // when im looking at this very funny confusing file :)









    static BlockEntry<SaplingBlock> makeSaplingBlock(String name, MapColor mapColor, AbstractTreeGrower treeGrower) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_sapling" , p -> new SaplingBlock(treeGrower, p))
                .initialProperties(() -> Blocks.OAK_SAPLING)
                .properties(p -> p
                        .mapColor(mapColor)
                )
                .tag(BlockTags.SAPLINGS)
                .addLayer(() -> RenderType::cutout)
                .blockstate((c, p) -> p.simpleBlock(c.get(), p.models().cross(c.getName(), p.blockTexture(c.get()))))
                .lang(capitalizedName + " Sapling")
                .item()
                .tag(ItemTags.SAPLINGS)
                .model((c, p) -> p.blockSprite(c))
                .build()
                .register();
    }

    private static BlockEntry<LeavesBlock> makeLeavesBlock(String name, MapColor mapColor, BlockEntry<SaplingBlock> drop, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_leaves" , LeavesBlock::new)
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
                .loot((loot, block) -> loot.add(block, loot.createLeavesDrops(block, drop.get(),
                        // Rates
                        0.0046875f, 0.00520833337f, 0.005859375f, 0.00781250025f, 0.01875f
                )))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Leaves")
                .item()
                .build()
                .register();
    }

    static BlockEntry<SaplingBlock> makeBlossomSaplingBlock(String color, String name, MapColor mapColor, AbstractTreeGrower treeGrower) {
        return REGISTRATE.block(color + "_blossom_sapling" , p -> new SaplingBlock(treeGrower, p))
                .initialProperties(() -> Blocks.OAK_SAPLING)
                .properties(p -> p
                        .mapColor(mapColor)
                )
                .tag(BlockTags.SAPLINGS)
                .addLayer(() -> RenderType::cutout)
                .blockstate((c, p) -> p.simpleBlock(c.get(), p.models().cross(c.getName(), p.blockTexture(c.get()))))
                .lang(name + " Blossom Sapling")
                .item()
                .tag(ItemTags.SAPLINGS)
                .model((c, p) -> p.blockSprite(c))
                .build()
                .register();
    }

    private static BlockEntry<BlossomLeavesBlock> makeBlossomLeavesBlock(String color, String name, MapColor mapColor, BlockEntry<SaplingBlock> drop, boolean flammable) {
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
                .loot((loot, block) -> loot.add(block, loot.createLeavesDrops(block, drop.get(),
                        // Rates
                        0.0046875f, 0.00520833337f, 0.005859375f, 0.00781250025f, 0.01875f
                )))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(name + " Blossom Leaves")
                .item()
                .build()
                .register();
    }

    private static BlockEntry<RotatedPillarBlock> makeLogBlock(String name, MapColor topColor, MapColor sideColor, TagKey<Item> tagKey, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_log" , RotatedPillarBlock::new)
                .initialProperties(() -> Blocks.OAK_LOG)
                .properties(p -> p
                        .mapColor(
                                s -> s.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor
                        )
                )
                .tag(BlockTags.LOGS)
                .blockstate((c, p) -> p.logBlock(c.get()))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 5, 5) : null)
                .lang(capitalizedName + " Log")
                .item()
                .tag(tagKey)
                .build()
                .register();
    }

    private static BlockEntry<RotatedPillarBlock> makeStrippedLogBlock(String name, MapColor color, TagKey<Item> tagKey, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block("stripped_" + name + "_log" , RotatedPillarBlock::new)
                .initialProperties(() -> Blocks.STRIPPED_OAK_LOG)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.LOGS)
                .blockstate((c, p) -> p.logBlock(c.get()))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 5, 5) : null)
                .lang("Stripped " + capitalizedName + " Log")
                .item()
                .tag(tagKey)
                .build()
                .register();
    }

    private static BlockEntry<RotatedPillarBlock> makeWoodBlock(String name, MapColor color, TagKey<Item> tagKey, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_wood" , RotatedPillarBlock::new)
                .initialProperties(() -> Blocks.OAK_WOOD)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.LOGS)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStates((state) -> ConfiguredModel.builder()
                                .modelFile(p.models().cubeColumn(c.getName(),
                                                Qook.asResource("block/" + name + "_log"),
                                                Qook.asResource("block/" + name + "_log")
                                        )
                                )
                                .rotationX(state.getValue(RotatedPillarBlock.AXIS) != Direction.Axis.Y ? 90 : 0)
                                .rotationY(state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.X ? 90 : 0)
                                .build()
                        )
                )
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 5, 5) : null)
                .lang(capitalizedName + " Wood")
                .item()
                .tag(tagKey)
                .build()
                .register();
    }

    private static BlockEntry<RotatedPillarBlock> makeStrippedWoodBlock(String name, MapColor color, TagKey<Item> tagKey, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block("stripped_" + name + "_wood" , RotatedPillarBlock::new)
                .initialProperties(() -> Blocks.STRIPPED_OAK_WOOD)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.LOGS)
                .blockstate((c, p) -> p.getVariantBuilder(c.get())
                        .forAllStates((state) -> ConfiguredModel.builder()
                                .modelFile(p.models().cubeColumn(c.getName(),
                                                Qook.asResource("block/stripped_" + name + "_log"),
                                                Qook.asResource("block/stripped_" + name + "_log")
                                        )
                                )
                                .rotationX(state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? 0 : 90)
                                .rotationY(state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.X ? 90 : 0)
                                .build()
                        )
                )
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 5, 5) : null)
                .lang("Stripped " + capitalizedName + " Wood")
                .item()
                .tag(tagKey)
                .build()
                .register();
    }

    private static BlockEntry<Block> makePlanksBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_planks", Block::new)
                .initialProperties(() -> Blocks.OAK_PLANKS)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.PLANKS)
                .lang(capitalizedName + " Planks")
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .item()
                .build()
                .register();
    }

    private static BlockEntry<SlabBlock> makeSlabsBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);
        ResourceLocation texture = Qook.asResource("block/" + name + "_planks");

        return REGISTRATE.block(name + "_slabs", SlabBlock::new)
                .initialProperties(() -> Blocks.OAK_STAIRS)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.SLABS, BlockTags.MINEABLE_WITH_AXE)
                .blockstate((c, p)-> p.slabBlock(c.get(), texture, texture))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Slabs")
                .item()
                .build()
                .register();
    }

    private static BlockEntry<StairBlock> makeStairsBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_stairs", p -> new StairBlock(Blocks.OAK_STAIRS.defaultBlockState(), p))
                .initialProperties(() -> Blocks.OAK_STAIRS)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.STAIRS, BlockTags.MINEABLE_WITH_AXE)
                .blockstate((c, p) -> p.stairsBlock(c.get(), Qook.asResource("block/" + name + "_planks")))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Stairs")
                .item()
                .build()
                .register();
    }

    private static BlockEntry<FenceBlock> makeFenceBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_fence", FenceBlock::new)
                .initialProperties(() -> Blocks.OAK_FENCE)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.WOODEN_FENCES)
                .blockstate((c, p) -> p.fenceBlock(c.get(), Qook.asResource("block/" + name + "_planks")))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Fence")
                .item()
                .model((c, p) -> p.fenceInventory(c.getName(), Qook.asResource("block/" + name + "_planks")))
                .build()
                .register();
    }

    private static BlockEntry<FenceGateBlock> makeFenceGateBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_fence_gate", p -> new FenceGateBlock(p, WoodType.OAK))
                .initialProperties(() -> Blocks.OAK_FENCE_GATE)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.FENCE_GATES)
                .blockstate((c, p) -> p.fenceGateBlock(c.get(), Qook.asResource("block/" + name + "_planks")))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Fence Gate")
                .item()
                .build()
                .register();
    }

    private static BlockEntry<DoorBlock> makeDoorBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_door", p -> new DoorBlock(p, BlockSetType.OAK))
                .initialProperties(() -> Blocks.OAK_DOOR)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.WOODEN_DOORS)
                .loot((registrateBlockLootTables, doorBlock) -> registrateBlockLootTables.add(doorBlock, registrateBlockLootTables.createDoorTable(doorBlock)))
                .blockstate((c, p) -> p.doorBlock(c.get(), Qook.asResource("block/" + name + "_door_bottom"), Qook.asResource("block/" + name + "_door_top")))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Door")
                .item()
                .model((c, p) -> p.generated(c))
                .build()
                .register();
    }

    private static BlockEntry<DoorBlock> makeDoorBlockWithRenderType(String name, MapColor color, boolean flammable, Supplier<RenderType> renderType) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_door", p -> new DoorBlock(p, BlockSetType.OAK))
                .initialProperties(() -> Blocks.OAK_DOOR)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.WOODEN_DOORS)
                .loot((registrateBlockLootTables, doorBlock) -> registrateBlockLootTables.add(doorBlock, registrateBlockLootTables.createDoorTable(doorBlock)))
                .blockstate((c, p) -> p.doorBlock(c.get(), Qook.asResource("block/" + name + "_door_bottom"), Qook.asResource("block/" + name + "_door_top")))
                .addLayer(() -> renderType)
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Door")
                .item()
                .model((c, p) -> p.generated(c))
                .build()
                .register();
    }

    private static BlockEntry<TrapDoorBlock> makeTrapDoorBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_trapdoor", p -> new TrapDoorBlock(p, BlockSetType.OAK))
                .initialProperties(() -> Blocks.OAK_TRAPDOOR)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.WOODEN_TRAPDOORS)
                .blockstate((c, p) -> p.trapdoorBlock(c.get(), Qook.asResource("block/" + name + "_trapdoor"), true))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Trapdoor")
                .item()
                .model((c, p) -> p.trapdoorBottom(c.getName(), Qook.asResource( "block/" + name + "_trapdoor")))
                .build()
                .register();
    }

    private static BlockEntry<TrapDoorBlock> makeTrapDoorBlockWithRenderType(String name, MapColor color, boolean flammable, Supplier<RenderType> renderType) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_trapdoor", p -> new TrapDoorBlock(p, BlockSetType.OAK))
                .initialProperties(() -> Blocks.OAK_TRAPDOOR)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.WOODEN_TRAPDOORS)
                .blockstate((c, p) -> p.trapdoorBlock(c.get(), Qook.asResource("block/" + name + "_trapdoor"), true))
                .addLayer(() -> renderType)
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Trapdoor")
                .item()
                .model((c, p) -> p.trapdoorBottom(c.getName(), Qook.asResource( "block/" + name + "_trapdoor")))
                .build()
                .register();
    }

    private static BlockEntry<ButtonBlock> makeButtonBlock(String name, MapColor color) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_button", p -> new ButtonBlock(p, BlockSetType.OAK, 30, true))
                .initialProperties(() -> Blocks.OAK_TRAPDOOR)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.WOODEN_TRAPDOORS)
                .blockstate((c, p) -> p.buttonBlock(c.get(), Qook.asResource("block/" + name + "_planks")))
                .lang(capitalizedName + " Button")
                .item()
                .model((c, p) -> p.buttonInventory(c.getName(), Qook.asResource("block/" + name + "_planks")))
                .build()
                .register();
    }

    private static BlockEntry<PressurePlateBlock> makePressurePlateBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_pressure_plate", p -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, p, BlockSetType.OAK))
                .initialProperties(() -> Blocks.OAK_PRESSURE_PLATE)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.WOODEN_PRESSURE_PLATES)
                .blockstate((c, p) -> p.pressurePlateBlock(c.get(), Qook.asResource("block/" + name + "_planks")))
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .lang(capitalizedName + " Pressure Plate")
                .item()
                .build()
                .register();
    }

    private static BlockEntry<LadderBlock> makeLadderBlock(String name, MapColor color) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block(name + "_ladder", LadderBlock::new)
                .initialProperties(() -> Blocks.LADDER)
                .properties(p -> p
                        .mapColor(color)
                )
                .addLayer(() -> RenderType::cutout)
                .tag(BlockTags.CLIMBABLE)
                .blockstate((c, p) -> p.horizontalBlock(c.getEntry(), p.models()
                        .withExistingParent(c.getName(), "block/ladder")
                            .texture("texture", p.blockTexture(c.getEntry()))
                            .texture("particle", p.blockTexture(c.getEntry()))
                        )
                )
                .lang(capitalizedName + " Ladder")
                .item()
                .model((c, p) -> p.blockSprite(c))
                .build()
                .register();
    }

    private static BlockEntry<Block> makeVerticalPlanksBlock(String name, MapColor color, boolean flammable) {
        String capitalizedName = name.substring(0, 1).toUpperCase() + name.substring(1);

        return REGISTRATE.block("vertical_" + name + "_planks", Block::new)
                .initialProperties(() -> Blocks.OAK_PLANKS)
                .properties(p -> p
                        .mapColor(color)
                )
                .tag(BlockTags.PLANKS)
                .blockstate((c, p) -> p.simpleBlock(c.getEntry(), p.models()
                        .withExistingParent(c.getName(), Qook.asResource("block/vertical_planks"))
                        .texture("all", Qook.asResource("block/" + name + "_planks"))
                ))
                .lang("Vertical " + capitalizedName + " Planks")
                .onRegister(flammable ? c -> FlammableBlockRegistry.getDefaultInstance().add(c, 30, 60) : null)
                .item()
                .build()
                .register();
    }

    public static void register() {
        Qook.LOGGER.info("Successfully Registered Blocks for {}", Qook.NAME);
    }
}
