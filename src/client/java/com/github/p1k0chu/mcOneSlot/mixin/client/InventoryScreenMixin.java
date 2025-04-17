package com.github.p1k0chu.mcOneSlot.mixin.client;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InventoryScreen.class)
public class InventoryScreenMixin {

    @Inject(method = "drawBackground", at = @At("RETURN"))
    void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY, CallbackInfo ci, @Local(ordinal = 2) int i, @Local(ordinal = 3) int j) {
        final int x1 = 7;
        final int y1 = 83;

        final int x2 = 169;
        final int y2 = 137;

        final int color = 0xffc7c7c7;
        context.fill(i + x1, j + y1, i + x2, j + y2, color);

        final int x3 = 26;
        final int y3 = 141;
        final int y4 = 159;

        context.fill(i + x3, j + y3, i + x2, j + y4, color);
    }
}
