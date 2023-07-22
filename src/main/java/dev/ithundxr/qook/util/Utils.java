package dev.ithundxr.qook.util;

import dev.ithundxr.qook.Qook;
import net.fabricmc.loader.api.FabricLoader;

public class Utils {
    public static String findVersion() {
        return FabricLoader.getInstance()
                .getModContainer(Qook.MOD_ID)
                .orElseThrow()
                .getMetadata()
                .getVersion()
                .getFriendlyString();
    }
}
