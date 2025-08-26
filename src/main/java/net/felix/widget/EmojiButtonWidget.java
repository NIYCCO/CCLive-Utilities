package net.felix.widget;

import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.widget.TexturedButtonWidget;

public class EmojiButtonWidget extends TexturedButtonWidget {

    public static final int BUTTON_SIZE = 12;
    public static final int GRID_SPACING = BUTTON_SIZE + 1;

    public EmojiButtonWidget(int x, int y, int width, int height, ButtonTextures textures, PressAction pressAction) {
        super(x, y, width, height, textures, pressAction);
    }
}
