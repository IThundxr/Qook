package dev.ithundxr.qook.registry;

import com.tterrag.registrate.Registrate;
import dev.ithundxr.qook.Qook;

public class QookItems {
    private static final Registrate REGISTRATE = Qook.REGISTRATE;

    public static void register() {
        Qook.LOGGER.info("Successfully Registered Items for {}", Qook.NAME);
    }
}
