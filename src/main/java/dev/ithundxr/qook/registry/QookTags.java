package dev.ithundxr.qook.registry;

import dev.ithundxr.qook.Qook;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class QookTags {
    public static class QookItemTags {
        public static final TagKey<Item> BLOSSOM_LOGS = create("blossom_logs");

        private static TagKey<Item> create(String name) {
            return TagKey.create(Registries.ITEM, Qook.asResource(name));
        }

        public static void register() {}
    }

    public static class QookBlockTags {
        //public static final TagKey<Block> BLOSSOM_LOGS = create("blossom_logs");

        private static TagKey<Block> create(String name) {
            return TagKey.create(Registries.BLOCK, Qook.asResource(name));
        }

        public static void register() {}
    }

    public static void register() {
        QookItemTags.register();
        QookBlockTags.register();
    }
}
