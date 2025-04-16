package com.github.p1k0chu.mcOneSlot.mixin;

import net.minecraft.screen.PlayerScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(PlayerScreenHandler.class)
public class PlayerScreenHandlerMixin {
    // funny enough, this is the only '3' in the whole method
    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 3))
    int changeMainInventoryRows(int constant) {
        return 0;
    }

    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 9, ordinal = 2))
    int changeHotbarLength(int constant) {
        return 1;
    }

    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 40))
    int changeOffhandIndex(int constant) {
        return 5;
    }

    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 39))
    int changeArmorLastIndex(int constant) {
        return 4;
    }
}
