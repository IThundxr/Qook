package dev.ithundxr.qook.registry.util;

import dev.ithundxr.qook.block.BlossomLeavesBlock;
import dev.ithundxr.qook.registry.QookBlocks;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.world.level.block.RotatedPillarBlock;

public class QookFlammableBlocks {
    public static void register() {
        FlammableBlockRegistry flammableBlockRegistry =  FlammableBlockRegistry.getDefaultInstance();

        // Flammable Leaves
        BlossomLeavesBlock[] blossomLeaves = {
                QookBlocks.BLUE_BLOSSOM_LEAVES.get(),
                QookBlocks.LAVENDER_BLOSSOM_LEAVES.get(),
                QookBlocks.ORANGE_BLOSSOM_LEAVES.get(),
                QookBlocks.PINK_BLOSSOM_LEAVES.get(),
                QookBlocks.RED_BLOSSOM_LEAVES.get(),
                QookBlocks.YELLOW_BLOSSOM_LEAVES.get()
        };

        // Flammable Logs
        RotatedPillarBlock[] logs = {
                QookBlocks.BLOSSOM_LOG.get(),
                QookBlocks.STRIPPED_BLOSSOM_LOG.get()
        };


        // Flammable Leaves
        for (BlossomLeavesBlock leavesBlock : blossomLeaves) {
            flammableBlockRegistry.add(leavesBlock, 30, 60);
        }

        // Flammable Logs
        for (RotatedPillarBlock logBlock : logs) {
            flammableBlockRegistry.add(logBlock, 5, 5);
        }
    }
}
