package com.github.p1k0chu.mcOneSlot.mixin;

import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 36))
    private int modifyMainInventorySize(int value) {
        return 1;
    }

    @ModifyConstant(method = "isValidHotbarIndex", constant = @Constant(intValue = 9))
    private static int modifyHotbarSize(int value) {
        return 1;
    }

    @ModifyConstant(method = "getSwappableHotbarSlot", constant = @Constant(intValue = 9))
    private int modifyHotbarSizeInSwappableHotbarSlot(int value) {
        return 1;
    }

    @Inject(method = "scrollInHotbar", cancellable = true, at = @At("HEAD"))
    private void cancelScroll(double scrollAmount, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(method = "getHotbarSize", at = @At("HEAD"), cancellable = true)
    private static void getHotbarSize(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(1);
    }
}
