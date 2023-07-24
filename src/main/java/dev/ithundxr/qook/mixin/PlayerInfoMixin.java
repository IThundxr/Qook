package dev.ithundxr.qook.mixin;

import com.google.common.collect.ImmutableSet;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import dev.ithundxr.qook.Qook;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;
import java.util.Set;

@Mixin(value = PlayerInfo.class)
public class PlayerInfoMixin {
    @Shadow
    @Final
    private GameProfile profile;
    @Shadow @Final
    private Map<MinecraftProfileTexture.Type, ResourceLocation> textureLocations;
    @Unique
    private boolean texturesLoaded;

    @Inject(at = @At("HEAD"), method = "getCapeLocation()Lnet/minecraft/resources/ResourceLocation;")
    protected void registerTextures(CallbackInfoReturnable<ResourceLocation> cir) {
        final Set<String> DEV_UUID = Set.of(
                "8c826f34-113b-4238-a173-44639c53b6e6", // Vazkii
                "0d054077-a977-4b19-9df9-8a4d5bf20ec3", // wi0iv
                "458391f5-6303-4649-b416-e4c0d18f837a", // yrsegal
                "75c298f9-27c8-415b-9a16-329e3884054b", // minecraftvinnyq
                "6c175d10-198a-49f9-8e2b-c74f1f0178f3", // MilkBringer / Sully
                "e67eb09a-b5af-4822-b756-9065cdc49913"  // IThundxr
        );

        if (!texturesLoaded && DEV_UUID.contains(profile.getId().toString())) {
            texturesLoaded = true;
            this.textureLocations.put(MinecraftProfileTexture.Type.CAPE, Qook.asResource("textures/misc/dev_cape.png"));
        }
    }
}
