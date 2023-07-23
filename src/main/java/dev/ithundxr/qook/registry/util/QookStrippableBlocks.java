package dev.ithundxr.qook.registry.util;

import dev.ithundxr.qook.registry.QookBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class QookStrippableBlocks {
    public static void register() {
        StrippableBlockRegistry.register(QookBlocks.BLOSSOM_LOG.get(), QookBlocks.STRIPPED_BLOSSOM_LOG.get());
        StrippableBlockRegistry.register(QookBlocks.BLOSSOM_WOOD.get(), QookBlocks.STRIPPED_BLOSSOM_WOOD.get());
    }
}
