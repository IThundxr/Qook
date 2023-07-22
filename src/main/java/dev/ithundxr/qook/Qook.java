package dev.ithundxr.qook;

import com.tterrag.registrate.Registrate;
import dev.ithundxr.qook.util.Utils;
import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Qook implements ModInitializer {
    public static final String MOD_ID = "qook";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final String VERSION = Utils.findVersion();

    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);


    @Override
    public void onInitialize() {
        ModSetup.register();
        finalizeRegistrate();

        LOGGER.info("Version: {} of {} has been successfully Initialized", VERSION, MOD_ID);
    }

    public static void finalizeRegistrate() {
        REGISTRATE.register();
    }

    public static ResourceLocation asResource(String name) {
        return new ResourceLocation(MOD_ID, name);
    }

    public static void gatherData(FabricDataGenerator.Pack pack, ExistingFileHelper helper) {
//        REGISTRATE.addDataGenerator(ProviderType.BLOCK_TAGS, CRTagGen::generateBlockTags);
//        REGISTRATE.addDataGenerator(ProviderType.ITEM_TAGS, CRTagGen::generateItemTags);
//        gen.addProvider(RailwaysSequencedAssemblyRecipeGen::new);
//        gen.addProvider(RailwaysStandardRecipeGen::new);
//        PonderLocalization.provideRegistrateLang(REGISTRATE);
//        gen.addProvider((PackOutput output) -> CRLangPartials.createMerger(output, MODID, "Steam 'n Rails", CRLangPartials.values()));
    }
}
