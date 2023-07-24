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

    BLOSSOM_WOOD = createWoodRecipe(QookBlocks.BLOSSOM_WOOD, QookBlocks.BLOSSOM_LOG),

    STRIPPED_BLOSSOM_WOOD = createWoodRecipe(QookBlocks.STRIPPED_BLOSSOM_WOOD, QookBlocks.STRIPPED_BLOSSOM_LOG),

    BLOSSOM_PLANKS = createPlanksRecipe(QookBlocks.BLOSSOM_PLANKS, QookBlocks.BLOSSOM_LOG, QookTags.QookItemTags.BLOSSOM_LOGS),

    BLOSSOM_SLABS = createSlabsRecipe(QookBlocks.BLOSSOM_SLABS, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_STAIRS = createStairsRecipe(QookBlocks.BLOSSOM_STAIRS, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_FENCE = createFenceRecipe(QookBlocks.BLOSSOM_FENCE, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_FENCE_GATE = createFenceGateRecipe(QookBlocks.BLOSSOM_FENCE_GATE, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_DOOR = createDoorRecipe(QookBlocks.BLOSSOM_DOOR, QookBlocks.BLOSSOM_PLANKS),

    BLOSSOM_TRAPDOOR = createTrapDoorRecipe(QookBlocks.BLOSSOM_TRAPDOOR, QookBlocks.BLOSSOM_PLANKS)

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
