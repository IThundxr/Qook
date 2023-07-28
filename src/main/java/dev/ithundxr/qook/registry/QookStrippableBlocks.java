package dev.ithundxr.qook.registry;

import dev.ithundxr.qook.Qook;
import dev.ithundxr.qook.registry.QookBlocks;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;

public class QookStrippableBlocks {
    public static void register() {
        Qook.LOGGER.info("Started Registering Strippable Blocks for {}", Qook.NAME);

        // Ancient
        StrippableBlockRegistry.register(QookBlocks.ANCIENT_LOG.get(), QookBlocks.STRIPPED_ANCIENT_LOG.get());
        StrippableBlockRegistry.register(QookBlocks.ANCIENT_WOOD.get(), QookBlocks.STRIPPED_ANCIENT_WOOD.get());

        // Azalea
        StrippableBlockRegistry.register(QookBlocks.AZALEA_LOG.get(), QookBlocks.STRIPPED_AZALEA_LOG.get());
        StrippableBlockRegistry.register(QookBlocks.AZALEA_WOOD.get(), QookBlocks.STRIPPED_AZALEA_WOOD.get());

        // Blossom
        StrippableBlockRegistry.register(QookBlocks.BLOSSOM_LOG.get(), QookBlocks.STRIPPED_BLOSSOM_LOG.get());
        StrippableBlockRegistry.register(QookBlocks.BLOSSOM_WOOD.get(), QookBlocks.STRIPPED_BLOSSOM_WOOD.get());

        Qook.LOGGER.info("Successfully Registered Strippable Blocks for {}", Qook.NAME);
    }
}
