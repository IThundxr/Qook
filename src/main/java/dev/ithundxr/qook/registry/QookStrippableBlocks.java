package dev.ithundxr.qook.registry;

import dev.ithundxr.qook.registry.QookBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class QookStrippableBlocks {
    public static void register() {
        // Ancient
        StrippableBlockRegistry.register(QookBlocks.ANCIENT_LOG.get(), QookBlocks.STRIPPED_ANCIENT_LOG.get());
        StrippableBlockRegistry.register(QookBlocks.ANCIENT_WOOD.get(), QookBlocks.STRIPPED_ANCIENT_WOOD.get());

        // Blossom
        StrippableBlockRegistry.register(QookBlocks.BLOSSOM_LOG.get(), QookBlocks.STRIPPED_BLOSSOM_LOG.get());
        StrippableBlockRegistry.register(QookBlocks.BLOSSOM_WOOD.get(), QookBlocks.STRIPPED_BLOSSOM_WOOD.get());
    }
}
