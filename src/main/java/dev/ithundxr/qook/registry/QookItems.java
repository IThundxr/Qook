package dev.ithundxr.qook.registry;

import com.tterrag.registrate.Registrate;
import dev.ithundxr.qook.Qook;

public class QookItems {
    private static final Registrate REGISTRATE = Qook.REGISTRATE;

    static {
        REGISTRATE.defaultCreativeTab(QookCreativeModeTab.getBaseTabKey());
    }

    public static void register() {
        // fabric: just load the class
    }
}
