package com.github.p1k0chu.mcOneSlot.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.SlotActionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

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

    @Inject(method = "internalOnSlotClick", at = @At("HEAD"), cancellable = true)
    void internalOnSlotClick(int slotIndex, int button, SlotActionType actionType, PlayerEntity player, CallbackInfo ci) {
        if(actionType == SlotActionType.QUICK_MOVE) {
            ci.cancel();
        }
    }
}
