package net.uku3lig.nowheel.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.uku3lig.nowheel.ToggleManager;

public class NoWheelFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ToggleManager.setToggle(KeyMappingHelper.registerKeyMapping(ToggleManager.createToggle()));
    }
}
