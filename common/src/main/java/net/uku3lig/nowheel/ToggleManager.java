package net.uku3lig.nowheel;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.uku3lig.nowheel.config.NoWheelConfig;

public final class ToggleManager {
    public static final KeyMapping.Category CATEGORY =
            KeyMapping.Category.register(Identifier.fromNamespaceAndPath("nowheel", "nowheel"));

    private static KeyMapping toggle;

    private ToggleManager() {
    }

    public static KeyMapping createToggle() {
        return new KeyMapping("nowheel.key.toggle", InputConstants.Type.KEYBOARD, InputConstants.UNKNOWN.getValue(), CATEGORY);
    }

    public static void setToggle(KeyMapping mapping) {
        toggle = mapping;
    }

    public static KeyMapping getToggle() {
        return toggle;
    }

    public static void onTick(Minecraft client) {
        if (toggle == null || client == null) {
            return;
        }

        while (toggle.consumeClick()) {
            toggleEnabled(client);
        }
    }

    private static void toggleEnabled(Minecraft client) {
        NoWheelConfig config = NoWheelConfig.get();
        boolean enabled = !config.isEnabled();
        config.setEnabled(enabled);
        NoWheelConfig.manager.saveConfig();

        if (client.player != null) {
            Component state = Component.literal(enabled ? "ON" : "OFF")
                    .withStyle(enabled ? ChatFormatting.GREEN : ChatFormatting.RED);
            client.player.sendOverlayMessage(Component.literal("NoWheel ").append(state));
        }
    }
}
