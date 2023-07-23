package dev.ithundxr.qook;

import com.tterrag.registrate.Registrate;
import dev.ithundxr.qook.datagen.lang.LangMerger;
import dev.ithundxr.qook.datagen.lang.QookLangPartials;
import dev.ithundxr.qook.datagen.recipe.QookRecipeGen;
import dev.ithundxr.qook.datagen.recipe.QookRecipeProvider;
import dev.ithundxr.qook.registry.QookBlocks;
import dev.ithundxr.qook.util.Utils;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Qook implements ModInitializer {
    public static final String MOD_ID = "qook";
    public static final String NAME = "Qook";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final String VERSION = Utils.findVersion();

    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);


    @Override
    public void onInitialize() {
        ModSetup.register();

        LOGGER.info("Version: {} of {} has been successfully Initialized", VERSION, NAME);
    }

    public static ResourceLocation asResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static void gatherData(FabricDataGenerator.Pack pack) {
        pack.addProvider((FabricDataOutput output) -> new LangMerger(output, MOD_ID, NAME, QookLangPartials.values()));
        pack.addProvider(QookRecipeGen::new);
    }
}
