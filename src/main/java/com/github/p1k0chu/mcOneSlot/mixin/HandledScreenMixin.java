package com.github.p1k0chu.mcOneSlot.mixin;

import net.minecraft.client.gui.screen.ingame.HandledScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(HandledScreen.class)
public class HandledScreenMixin {
    @ModifyConstant(method = "handleHotbarKeyPressed", constant = @Constant(intValue = 9))
    int modifyHotbarLength(int constant) {
        return 1;
    }

    @ModifyConstant(method = "handleHotbarKeyPressed", constant = @Constant(intValue = 40))
    int modifyOffhandIndex(int c) {
        return 5;
    }
}
