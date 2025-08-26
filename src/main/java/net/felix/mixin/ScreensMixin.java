package net.felix.mixin;

import net.felix.CCLiveUtilities;
import net.felix.EmojiInsertable;
import net.felix.ScreenAccess;
import net.felix.widget.EmojiButtonWidget;
import net.felix.widget.EmojiIconButtonWidget;
import net.felix.widget.EmojiSelectionPanel;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.GridWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ChatScreen.class)
public abstract class ScreensMixin extends Screen implements ScreenAccess, EmojiInsertable {

    @Unique private static final Identifier TEXTURE = Identifier.of(CCLiveUtilities.MOD_ID, "emoji_button");

    @Unique private EmojiSelectionPanel emojiSelectionPanel;

    @Unique private EmojiIconButtonWidget symbolButtonWidget;

    protected ScreensMixin(Text title) {
        super(title);
    }

    @Override
    public void addEmojiChatComponents() {
        int padding = 2;
        int hudButtonsHeight = 15;

        int emojiButtonX = this.width - padding - EmojiButtonWidget.BUTTON_SIZE;
        int emojiButtonY = this.height - padding - EmojiButtonWidget.BUTTON_SIZE;

        int panelHeight = 200;
        int panelWidth = 120;

        int panelX = this.width - panelWidth - padding;
        int panelY = emojiButtonY - padding - panelHeight;

        System.out.println(panelX + ", " + panelY + ", " + panelHeight);

        this.emojiSelectionPanel = new EmojiSelectionPanel(panelX, panelY, panelHeight, this);
        this.addDrawableChild(emojiSelectionPanel);

        symbolButtonWidget = new EmojiIconButtonWidget(EmojiButtonWidget.BUTTON_SIZE, EmojiButtonWidget.BUTTON_SIZE, ScreenTexts.EMPTY, EmojiButtonWidget.BUTTON_SIZE, EmojiButtonWidget.BUTTON_SIZE, TEXTURE, button -> {
            emojiSelectionPanel.toggleVisible();
            button.setOutlined(!button.isOutlined());
        }, null);

        symbolButtonWidget.setPosition(emojiButtonX, emojiButtonY);
        symbolButtonWidget.setOutlined(false);
        this.addDrawableChild(symbolButtonWidget);

        GridWidget gridWidget = new GridWidget(0, 0);
        gridWidget.setColumnSpacing(padding);
        GridWidget.Adder adder = gridWidget.createAdder(Integer.MAX_VALUE);

        gridWidget.refreshPositions();
        int hudX = width - padding - gridWidget.getWidth();
        gridWidget.setX(hudX);
        int hudY = height - padding - EmojiButtonWidget.BUTTON_SIZE - padding - gridWidget.getHeight();
        gridWidget.setY(hudY);
        gridWidget.forEachChild(this::addDrawableChild);


    }
}
