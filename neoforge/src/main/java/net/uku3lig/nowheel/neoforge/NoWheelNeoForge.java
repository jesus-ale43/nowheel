package net.uku3lig.nowheel.neoforge;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.uku3lig.nowheel.ToggleManager;
import net.uku3lig.nowheel.config.UkulibHook;
import net.uku3lig.ukulib.neoforge.UkulibNFProvider;

@Mod(value = "nowheel", dist = Dist.CLIENT)
public class NoWheelNeoForge {
    private KeyMapping toggle;

    public NoWheelNeoForge(IEventBus modBus, ModContainer container) {
        container.registerExtensionPoint(UkulibNFProvider.class, UkulibHook::new);

        modBus.addListener((RegisterKeyMappingsEvent event) -> {
            toggle = ToggleManager.createToggle();
            event.register(toggle);
        });

        NeoForge.EVENT_BUS.addListener((ClientTickEvent.Post event) -> {
            if (toggle == null) {
                return;
            }

            while (toggle.consumeClick()) {
                ToggleManager.toggle(Minecraft.getInstance());
            }
        });
    }
}
