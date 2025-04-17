package com.github.p1k0chu.mcOneSlot.mixin;

import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {
    @ModifyConstant(method = "addPlayerInventorySlots", constant = @Constant(intValue = 3))
    int doNotAddInventorySlots(int constant) {
        return 0;
    }
    @ModifyConstant(method = "addPlayerHotbarSlots", constant = @Constant(intValue = 9))
    int changeHotbarSize(int constant) {
        return 1;
    }
}
