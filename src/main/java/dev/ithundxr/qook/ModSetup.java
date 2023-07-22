package dev.ithundxr.qook;

import dev.ithundxr.qook.registry.*;

public class ModSetup {
    public static void register() {
        Qook.REGISTRATE.defaultCreativeTab(QookCreativeModeTab.getBaseTabKey());
        QookCreativeModeTab.register();
        QookItems.register();
        QookBlocks.register();
    }
}
