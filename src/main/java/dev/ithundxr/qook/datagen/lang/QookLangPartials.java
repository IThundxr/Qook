package dev.ithundxr.qook.datagen.lang;

import com.google.gson.JsonElement;
import dev.ithundxr.qook.Qook;

import java.util.Locale;
import java.util.function.Supplier;

/*
 * Taken From Create-Fabric
 */
public enum QookLangPartials implements LangPartial {
    INTERFACE("UI & Messages"),
    TOOLTIPS("Item Descriptions"),

    ;

    private final String displayName;
    private final Supplier<JsonElement> provider;

    private QookLangPartials(String displayName) {
        this.displayName = displayName;
        String fileName = name().toLowerCase(Locale.ROOT);
        this.provider = () -> LangPartial.fromResource(Qook.MOD_ID, fileName);
    }

    private QookLangPartials(String displayName, Supplier<JsonElement> provider) {
        this.displayName = displayName;
        this.provider = provider;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public JsonElement provide() {
        return provider.get();
    }

}
