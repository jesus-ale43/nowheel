package net.uku3lig.nowheel.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.uku3lig.nowheel.ToggleManager;

public class NoWheelFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyMapping toggle = KeyMappingHelper.registerKeyMapping(ToggleManager.createToggle());

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (toggle.consumeClick()) {
                ToggleManager.toggle(client);
            }
        });
    }
}
