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

    private ToggleManager() {
    }

    public static KeyMapping createToggle() {
        return new KeyMapping("nowheel.key.toggle", InputConstants.Type.KEYBOARD, InputConstants.UNKNOWN.getValue(), CATEGORY);
    }

    public static void toggle(Minecraft client) {
        NoWheelConfig config = NoWheelConfig.get();
        boolean enabled = !config.isEnabled();
        config.setEnabled(enabled);
        NoWheelConfig.manager.saveConfig();

        if (client != null && client.player != null) {
            client.player.sendOverlayMessage(Component.translatable(enabled ? "nowheel.toggle.on" : "nowheel.toggle.off")
                    .withStyle(enabled ? ChatFormatting.GREEN : ChatFormatting.RED));
        }
    }
}
