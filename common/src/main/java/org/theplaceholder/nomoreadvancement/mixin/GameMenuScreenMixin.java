package org.theplaceholder.nomoreadvancement.mixin;

import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin {

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/GameMenuScreen;addDrawableChild(Lnet/minecraft/client/gui/Element;)Lnet/minecraft/client/gui/Element;", ordinal = 1), method = "initWidgets")
    private Element openScreenButton(GameMenuScreen instance, Element element) {
        if (element instanceof ButtonWidget button) {
            button.active = false;
            button.visible = false;
        }
        return element;
    }
}
