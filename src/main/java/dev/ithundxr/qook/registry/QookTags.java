package dev.ithundxr.qook.registry;

import dev.ithundxr.qook.Qook;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class QookTags {
    public static class QookItemTags {
        public static final TagKey<Item> BLOSSOM_LOGS = create("blossom_logs");
        public static final TagKey<Item> ANCIENT_LOGS = create("ancient_logs");
        public static final TagKey<Item> AZALEA_LOGS = create("azalea_logs");


        private static TagKey<Item> create(String name) {
            return TagKey.create(Registries.ITEM, Qook.asResource(name));
        }

        public static void register() {
            Qook.LOGGER.info("Registered Item Tags for {}", Qook.NAME);
        }
    }

    public static class QookBlockTags {
        //public static final TagKey<Block> BLOSSOM_LOGS = create("blossom_logs");

        private static TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, Qook.asResource(name));
        }

        public static void register() {
            Qook.LOGGER.info("Registered Block Tags for {}", Qook.NAME);
        }
    }

    public static void register() {
        Qook.LOGGER.info("Started Registering Tags for {}", Qook.NAME);
        QookItemTags.register();
        QookBlockTags.register();
        Qook.LOGGER.info("Successfully Registered Tags for {}", Qook.NAME);
    }
}
