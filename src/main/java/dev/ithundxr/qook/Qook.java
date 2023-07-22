package dev.ithundxr.scooper;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Scooper implements ModInitializer {
    public static final String MOD_ID = "scooper";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static final String VERSION = findVersion();

    @Override
    public void onInitialize() {
        LOGGER.info("Version: {} of {} has been successfully Initialized", VERSION, MOD_ID);
    }

    public static String findVersion() {
        return FabricLoader.getInstance()
                .getModContainer(MOD_ID)
                .orElseThrow()
                .getMetadata()
                .getVersion()
                .getFriendlyString();
    }
}
