package com.github.p1k0chu.mcOneSlot.mixin.client;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.Function;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @ModifyConstant(method = "renderHotbar", constant = @Constant(intValue = 9))
    private int modifyHotbarLength(int value) {
        return 1;
    }

    @Redirect(method = "renderHotbar", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Ljava/util/function/Function;Lnet/minecraft/util/Identifier;IIII)V", ordinal = 0))
    void renderHotbarGuiTexture(DrawContext instance, Function<Identifier, RenderLayer> renderLayers, Identifier sprite, int x, int y, int width, int height) {
        // crop the texture to one slot
        instance.drawGuiTexture(renderLayers, sprite, width, height, 0, 0, x, y, 22, height);
    }
}
