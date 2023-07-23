package dev.ithundxr.qook.datagen.recipe;

import com.tterrag.registrate.util.entry.ItemProviderEntry;
import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.registry.QookBlocks;
import dev.ithundxr.qook.registry.QookTags;
import dev.ithundxr.qook.util.RegisteredObjects;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@SuppressWarnings("unused")
public class QookRecipeGen extends QookRecipeProvider {

    /*
     * Recipes are added through fields, so one can navigate to the right one easily
     */

    GeneratedRecipe

    BLOSSOM_WOOD = create(QookBlocks.BLOSSOM_WOOD)
            .returns(3)
            .unlockedBy(QookBlocks.BLOSSOM_LOG)
            .viaShaped(b -> b
                    .define('B', QookBlocks.BLOSSOM_LOG)
                    .pattern("BB ")
                    .pattern("BB ")
            ),

    STRIPPED_BLOSSOM_WOOD = create(QookBlocks.STRIPPED_BLOSSOM_WOOD)
            .returns(3)
            .unlockedBy(QookBlocks.STRIPPED_BLOSSOM_LOG)
            .viaShaped(b -> b
                .define('B', QookBlocks.STRIPPED_BLOSSOM_LOG)
                .pattern("BB ")
                .pattern("BB ")
            ),

    BLOSSOM_PLANKS = create(QookBlocks.BLOSSOM_PLANKS)
            .returns(4)
            .unlockedBy(QookBlocks.BLOSSOM_LOG)
            .viaShapeless(b -> b
                    .requires(QookTags.QookItemTags.BLOSSOM_LOGS)
            )

    ;

    /*
     * End of recipe list
     */

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
    public String getName() {
        return "Qook Recipes";
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
