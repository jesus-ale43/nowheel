package net.uku3lig.nowheel.neoforge;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.uku3lig.nowheel.ToggleManager;
import net.uku3lig.nowheel.config.UkulibHook;
import net.uku3lig.ukulib.neoforge.UkulibNFProvider;

@Mod(value = "nowheel", dist = Dist.CLIENT)
public class NoWheelNeoForge {
    public NoWheelNeoForge(IEventBus modBus, ModContainer container) {
        container.registerExtensionPoint(UkulibNFProvider.class, UkulibHook::new);

        modBus.addListener((RegisterKeyMappingsEvent event) -> {
            var toggle = ToggleManager.createToggle();
            ToggleManager.setToggle(toggle);
            event.register(toggle);
        });
    }
}
