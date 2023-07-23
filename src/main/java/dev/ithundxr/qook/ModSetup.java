package dev.ithundxr.qook;

import dev.ithundxr.qook.registry.*;

public class ModSetup {
    public static void register() {
        Qook.REGISTRATE.defaultCreativeTab(QookCreativeModeTab.getBaseTabKey());
        QookCreativeModeTab.register();
        QookBlocks.register();
        QookItems.register();
    }
}
