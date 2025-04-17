package com.github.p1k0chu.mcOneSlot.mixin.client;

import net.minecraft.client.gui.hud.InGameHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(InGameHud.class)
public class InGameHudMixin {
    @ModifyConstant(method = "renderHotbar", constant = @Constant(intValue = 9))
    private int modifyHotbarLength(int value) {
        return 1;
    }

    @ModifyConstant(method = "renderHotbar", constant = @Constant(intValue = 182))
    private int modifyHotbarRenderWidth(int value) {
        return 22;
    }
}
