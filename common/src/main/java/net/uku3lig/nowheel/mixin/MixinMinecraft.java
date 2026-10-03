package net.uku3lig.nowheel.mixin;

import net.minecraft.client.Minecraft;
import net.uku3lig.nowheel.ToggleManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    @Inject(method = "tick", at = @At("HEAD"))
    private void pollToggleKey(CallbackInfo ci) {
        ToggleManager.onTick(Minecraft.getInstance());
    }
}
