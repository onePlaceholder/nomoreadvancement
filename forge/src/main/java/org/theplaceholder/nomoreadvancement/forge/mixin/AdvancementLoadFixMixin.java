package org.theplaceholder.nomoreadvancement.forge.mixin;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementProgress;
import net.minecraft.advancement.PlayerAdvancementTracker;
import net.minecraftforge.common.AdvancementLoadFix;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

@Mixin(value = AdvancementLoadFix.class, remap = false)
public class AdvancementLoadFixMixin {
    @Inject(method = "loadVisibility", at = @At("HEAD"), cancellable = true)
    private static void loadVisibility(PlayerAdvancementTracker playerAdvancements, Set<Advancement> visible, Set<Advancement> visibilityChanged, Map<Advancement, AdvancementProgress> progress, Set<Advancement> progressChanged, Predicate<Advancement> shouldBeVisible, CallbackInfo ci) {
        ci.cancel();
    }
}