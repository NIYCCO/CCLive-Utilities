package net.felix.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import net.felix.EmojiInsertable;
import net.felix.container.NonScrollableContainerWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;

public class EmojiSelectionPanel extends NonScrollableContainerWidget {

    protected final EmojiInsertable emojiInsertable;

    public EmojiSelectionPanel(int x, int y, int height, EmojiInsertable emojiInsertable) {
        super(x, y, 120, height);

        this.emojiInsertable = emojiInsertable;
        this.visible = false;


    }

    public boolean isVisible() {
        return visible;
    }

    public void toggleVisible() {
        this.visible = !this.visible;
    }

    @Override
    public void renderWidget(DrawContext drawContext, int mouseX, int mouseY, float delta) {
        drawContext.getMatrices().pushMatrix();
        drawContext.getMatrices().translate(0.0f, 0.0f);
        drawContext.fill(this.getX(), this.getY() + EmojiButtonWidget.GRID_SPACING + 1, this.getX() + width, this.getY() + height, MinecraftClient.getInstance().options.getTextBackgroundColor(Integer.MIN_VALUE));
        super.renderWidget(drawContext, mouseX, mouseY, delta);
        drawContext.getMatrices().popMatrix();
    }
}
