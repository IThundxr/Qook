package dev.ithundxr.qook;

import dev.ithundxr.qook.registry.*;
import dev.ithundxr.qook.world.QookConfiguredFeatures;
import dev.ithundxr.qook.world.gen.QookWorldGeneration;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;

public class ModSetup {
    public static void register() {
        // Creative Tab Stuff
        Qook.REGISTRATE.defaultCreativeTab(QookCreativeModeTab.getBaseTabKey());
        QookCreativeModeTab.register();

        // Blocks & Items
        QookBlocks.register();
        QookItems.register();
        
        // Tags
        QookTags.register();

        // Register Registrate (Registers all items and blocks
        Qook.REGISTRATE.register();

        // Register World Generation
        QookWorldGeneration.generateQookWorldGen();

        // Register Strippable Blocks
        QookStrippableBlocks.register();

        ServerWorldEvents.LOAD.register((server, level) -> QookConfiguredFeatures.overrideAzaleaTrunk(server));
    }
}
