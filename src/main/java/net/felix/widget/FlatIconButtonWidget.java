package net.felix.widget;

import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextIconButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class FlatIconButtonWidget extends TextIconButtonWidget.IconOnly {
    protected FlatIconButtonWidget(int i, int j, Text text, int k, int l, Identifier identifier, PressAction pressAction, @Nullable ButtonWidget.NarrationSupplier narrationSupplier) {
        super(i, j, text, k, l, identifier, pressAction, narrationSupplier);
    }
}
