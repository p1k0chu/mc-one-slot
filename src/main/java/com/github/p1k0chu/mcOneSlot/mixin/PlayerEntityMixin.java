package com.github.p1k0chu.mcOneSlot.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {
    @Shadow
    @Final
    public PlayerInventory inventory;

    @Inject(method = "readCustomDataFromTag", at = @At("RETURN"))
    void readCustomDataFromTag(CompoundTag tag, CallbackInfo ci) {
        this.inventory.selectedSlot = 0;
    }
}
