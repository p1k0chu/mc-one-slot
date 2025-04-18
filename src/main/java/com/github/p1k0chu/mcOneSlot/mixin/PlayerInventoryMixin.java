package com.github.p1k0chu.mcOneSlot.mixin;

import net.minecraft.entity.player.PlayerInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerInventory.class)
public class PlayerInventoryMixin {
    @ModifyConstant(method = "<init>", constant = @Constant(intValue = 36))
    private int modifyMainInventorySize(int value) {
        return 1;
    }
    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 36))
    private static int modifyMainInventorySizeStatic(int value) {
        return 1;
    }
    @ModifyConstant(method = "<clinit>", constant = @Constant(intValue = 40))
    private static int modifyOffhandIndexStatic(int value) {
        return 5;
    }

    @ModifyConstant(method = "getOccupiedSlotWithRoomForStack", constant = @Constant(intValue = 40))
    int getOccupiedSlotWithRoomForStack(int constant) {
        return 5;
    }


    @ModifyConstant(method = "isValidHotbarIndex", constant = @Constant(intValue = 9))
    private static int modifyHotbarSize(int value) {
        return 1;
    }

    @ModifyConstant(method = "getSwappableHotbarSlot", constant = @Constant(intValue = 9))
    private int modifyHotbarSizeInSwappableHotbarSlot(int value) {
        return 1;
    }

    @Inject(method = "getHotbarSize", at = @At("HEAD"), cancellable = true)
    private static void getHotbarSize(CallbackInfoReturnable<Integer> cir){
        cir.setReturnValue(1);
    }
}
