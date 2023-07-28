package dev.ithundxr.qook.datagen.recipe;

import com.tterrag.registrate.util.entry.ItemProviderEntry;
import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.registry.QookBlocks;
import dev.ithundxr.qook.registry.QookTags;
import dev.ithundxr.qook.util.RegisteredObjects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@SuppressWarnings({"unused", "SameParameterValue"})
public class QookRecipeGen extends QookRecipeProvider {

    /*
     * Recipes are added through fields, so one can navigate to the right one easily
     */

    GeneratedRecipe
    // Ancient

    ANCIENT_WOOD = createWoodRecipe(QookBlocks.ANCIENT_WOOD, QookBlocks.ANCIENT_LOG),

    STRIPPED_ANCIENT_WOOD = createWoodRecipe(QookBlocks.STRIPPED_ANCIENT_WOOD, QookBlocks.STRIPPED_ANCIENT_LOG),

    ANCIENT_PLANKS = createPlanksRecipe(QookBlocks.ANCIENT_PLANKS, QookBlocks.ANCIENT_LOG, QookTags.QookItemTags.ANCIENT_LOGS),

    ANCIENT_PLANKS_FROM_VERT = createVerticalPlanksintoPlanksRecipe(QookBlocks.ANCIENT_PLANKS, QookBlocks.VERTICAL_ANCIENT_PLANKS),

    ANCIENT_SLABS = createSlabsRecipe(QookBlocks.ANCIENT_SLABS, QookBlocks.ANCIENT_PLANKS),

    ANCIENT_STAIRS = createStairsRecipe(QookBlocks.ANCIENT_STAIRS, QookBlocks.ANCIENT_PLANKS),

    ANCIENT_FENCE = createFenceRecipe(QookBlocks.ANCIENT_FENCE, QookBlocks.ANCIENT_PLANKS),

    ANCIENT_FENCE_GATE = createFenceGateRecipe(QookBlocks.ANCIENT_FENCE_GATE, QookBlocks.ANCIENT_PLANKS),

    ANCIENT_DOOR = createDoorRecipe(QookBlocks.ANCIENT_DOOR, QookBlocks.ANCIENT_PLANKS),

    ANCIENT_TRAPDOOR = createTrapDoorRecipe(QookBlocks.ANCIENT_TRAPDOOR, QookBlocks.ANCIENT_PLANKS),

    ANCIENT_BUTTON = createButtonRecipe(QookBlocks.ANCIENT_BUTTON, QookBlocks.ANCIENT_PLANKS),

    ANCIENT_PRESSURE_PLATE = createPressurePlateRecipe(QookBlocks.ANCIENT_PRESSURE_PLATE, QookBlocks.ANCIENT_PLANKS),

    ANCIENT_LADDER = createLadderRecipe(QookBlocks.ANCIENT_LADDER, QookBlocks.ANCIENT_PLANKS),

    VERTICAL_ANCIENT_PLANKS = createVerticalPlanksRecipe(QookBlocks.VERTICAL_ANCIENT_PLANKS, QookBlocks.ANCIENT_PLANKS),


    // Azalea

    AZALEA_WOOD = createWoodRecipe(QookBlocks.AZALEA_WOOD, QookBlocks.AZALEA_LOG),

    STRIPPED_AZALEA_WOOD = createWoodRecipe(QookBlocks.STRIPPED_AZALEA_WOOD, QookBlocks.STRIPPED_AZALEA_LOG),

    AZALEA_PLANKS = createPlanksRecipe(QookBlocks.AZALEA_PLANKS, QookBlocks.AZALEA_LOG, QookTags.QookItemTags.AZALEA_LOGS),

    AZALEA_PLANKS_FROM_VERT = createVerticalPlanksintoPlanksRecipe(QookBlocks.AZALEA_PLANKS, QookBlocks.VERTICAL_AZALEA_PLANKS),

    AZALEA_SLABS = createSlabsRecipe(QookBlocks.AZALEA_SLABS, QookBlocks.AZALEA_PLANKS),

    AZALEA_STAIRS = createStairsRecipe(QookBlocks.AZALEA_STAIRS, QookBlocks.AZALEA_PLANKS),

    AZALEA_FENCE = createFenceRecipe(QookBlocks.AZALEA_FENCE, QookBlocks.AZALEA_PLANKS),

    AZALEA_FENCE_GATE = createFenceGateRecipe(QookBlocks.AZALEA_FENCE_GATE, QookBlocks.AZALEA_PLANKS),

    AZALEA_DOOR = createDoorRecipe(QookBlocks.AZALEA_DOOR, QookBlocks.AZALEA_PLANKS),

    AZALEA_TRAPDOOR = createTrapDoorRecipe(QookBlocks.AZALEA_TRAPDOOR, QookBlocks.AZALEA_PLANKS),

    AZALEA_BUTTON = createButtonRecipe(QookBlocks.AZALEA_BUTTON, QookBlocks.AZALEA_PLANKS),

    AZALEA_PRESSURE_PLATE = createPressurePlateRecipe(QookBlocks.AZALEA_PRESSURE_PLATE, QookBlocks.AZALEA_PLANKS),

    AZALEA_LADDER = createLadderRecipe(QookBlocks.AZALEA_LADDER, QookBlocks.AZALEA_PLANKS),

    VERTICAL_AZALEA_PLANKS = createVerticalPlanksRecipe(QookBlocks.VERTICAL_AZALEA_PLANKS, QookBlocks.AZALEA_PLANKS),


    // Blossom

    BLOSSOM_WOOD = createWoodRecipe(QookBlocks.BLOSSOM_WOOD, QookBlocks.BLOSSOM_LOG),

    STRIPPED_BLOSSOM_WOOD = createWoodRecipe(QookBlocks.STRIPPED_BLOSSOM_WOOD, QookBlocks.STRIPPED_BLOSSOM_LOG),

    BLOSSOM_PLANKS = createPlanksRecipe(QookBlocks.BLOSSOM_PLANKS, QookBlocks.BLOSSOM_LOG, QookTags.QookItemTags.BLOSSOM_LOGS),

    BLOSSOM_PLANKS_FROM_VERT = createVerticalPlanksintoPlanksRecipe(QookBlocks.BLOSSOM_PLANKS, QookBlocks.VERTICAL_BLOSSOM_PLANKS),

    BLOSSOM_SLABS = createSlabsRecipe(QookBlocks.BLOSSOM_SLABS, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_STAIRS = createStairsRecipe(QookBlocks.BLOSSOM_STAIRS, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_FENCE = createFenceRecipe(QookBlocks.BLOSSOM_FENCE, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_FENCE_GATE = createFenceGateRecipe(QookBlocks.BLOSSOM_FENCE_GATE, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_DOOR = createDoorRecipe(QookBlocks.BLOSSOM_DOOR, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_TRAPDOOR = createTrapDoorRecipe(QookBlocks.BLOSSOM_TRAPDOOR, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_BUTTON = createButtonRecipe(QookBlocks.BLOSSOM_BUTTON, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_PRESSURE_PLATE = createPressurePlateRecipe(QookBlocks.BLOSSOM_PRESSURE_PLATE, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_LADDER = createLadderRecipe(QookBlocks.BLOSSOM_LADDER, QookBlocks.BLOSSOM_PLANKS),

    VERTICAL_BLOSSOM_PLANKS = createVerticalPlanksRecipe(QookBlocks.VERTICAL_BLOSSOM_PLANKS, QookBlocks.BLOSSOM_PLANKS)

    ;

    /*
     * End of recipe list
     */

    GeneratedRecipe createWoodRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(3)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient.get())
                        .pattern("BB ")
                        .pattern("BB ")
                );
    }

    GeneratedRecipe createPlanksRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient, TagKey<Item> tag) {
        return create(result)
                .returns(4)
                .unlockedBy(ingredient)
                .viaShapeless(b -> b
                        .requires(tag)
                );
    }

    GeneratedRecipe createSlabsRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(6)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .pattern("   ")
                        .pattern("BBB")
                );
    }

    GeneratedRecipe createStairsRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(4)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .pattern("B  ")
                        .pattern("BB ")
                        .pattern("BBB")
                );
    }

    GeneratedRecipe createFenceRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(3)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .define('S', Items.STICK)
                        .pattern("BSB")
                        .pattern("BSB")
                );
    }

    GeneratedRecipe createFenceGateRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(3)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .define('S', Items.STICK)
                        .pattern("SBS")
                        .pattern("SBS")
                );
    }

    GeneratedRecipe createDoorRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(3)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .pattern("BB ")
                        .pattern("BB ")
                        .pattern("BB ")
                );
    }

    GeneratedRecipe createTrapDoorRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(2)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .pattern("BBB")
                        .pattern("BBB")
                );
    }

    GeneratedRecipe createButtonRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(2)
                .unlockedBy(ingredient)
                .viaShapeless(b -> b
                        .requires(ingredient)
                );
    }

    GeneratedRecipe createPressurePlateRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(1)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .pattern("   ")
                        .pattern("BB ")
                );
    }

    GeneratedRecipe createLadderRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(4)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .define('S', Items.STICK)
                        .pattern("S S")
                        .pattern("SBS")
                        .pattern("S S")
                );
    }

    GeneratedRecipe createVerticalPlanksRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .returns(3)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .pattern(" B ")
                        .pattern(" B ")
                        .pattern(" B ")
                );
    }

    GeneratedRecipe createVerticalPlanksintoPlanksRecipe(ItemProviderEntry<? extends ItemLike> result, ItemProviderEntry<? extends ItemLike> ingredient) {
        return create(result)
                .withSuffix("_from_vertical")
                .returns(1)
                .unlockedBy(ingredient)
                .viaShaped(b -> b
                        .define('B', ingredient)
                        .pattern("   ")
                        .pattern(" B ")
                );
    }


    GeneratedRecipeBuilder create(Supplier<ItemLike> result) {
        return new GeneratedRecipeBuilder("/", result);
    }

    GeneratedRecipeBuilder create(ResourceLocation result) {
        return new GeneratedRecipeBuilder("/", result);
    }

    GeneratedRecipeBuilder create(ItemProviderEntry<? extends ItemLike> result) {
        return create(result::get);
    }

    public QookRecipeGen(FabricDataOutput pOutput) {
        super(pOutput);
    }

    @Override
    public @NotNull String getName() {
        return "Qook's Recipes";
    }

    class GeneratedRecipeBuilder {

        private final String path;
        private String suffix;
        private Supplier<? extends ItemLike> result;
        private Supplier<ItemPredicate> unlockedBy;
        private int amount;

        private GeneratedRecipeBuilder(String path) {
            this.path = path;
            this.suffix = "";
            this.amount = 1;
        }

        public GeneratedRecipeBuilder(String path, Supplier<? extends ItemLike> result) {
            this(path);
            this.result = result;
        }

        public GeneratedRecipeBuilder(String path, ResourceLocation result) {
            this(path);
        }

        GeneratedRecipeBuilder returns(int amount) {
            this.amount = amount;
            return this;
        }

        GeneratedRecipeBuilder unlockedBy(Supplier<? extends ItemLike> item) {
            this.unlockedBy = () -> ItemPredicate.Builder.item()
                    .of(item.get())
                    .build();
            return this;
        }

        GeneratedRecipeBuilder unlockedByTag(Supplier<TagKey<Item>> tag) {
            this.unlockedBy = () -> ItemPredicate.Builder.item()
                    .of(tag.get())
                    .build();
            return this;
        }

        GeneratedRecipeBuilder withSuffix(String suffix) {
            this.suffix = suffix;
            return this;
        }

        GeneratedRecipe viaShaped(UnaryOperator<ShapedRecipeBuilder> builder) {
            return register(consumer -> {
                ShapedRecipeBuilder b = builder.apply(ShapedRecipeBuilder.shaped(RecipeCategory.MISC, result.get(), amount));
                if (unlockedBy != null)
                    b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));
                b.save(consumer, createLocation("crafting"));
            });
        }

        GeneratedRecipe viaShapeless(UnaryOperator<ShapelessRecipeBuilder> builder) {
            return register(consumer -> {
                ShapelessRecipeBuilder b = builder.apply(ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, result.get(), amount));
                if (unlockedBy != null)
                    b.unlockedBy("has_item", inventoryTrigger(unlockedBy.get()));
                b.save(consumer, createLocation("crafting"));
            });
        }

        private ResourceLocation createSimpleLocation(String recipeType) {
            return Qook.asResource(recipeType + "/" + getRegistryName().getPath() + suffix);
        }

        private ResourceLocation createLocation(String recipeType) {
            return Qook.asResource(recipeType + "/" + path + "/" + getRegistryName().getPath() + suffix);
        }

        private ResourceLocation getRegistryName() {
            return RegisteredObjects.getKeyOrThrow(result.get().asItem());
        }
    }
}
