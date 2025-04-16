package com.github.p1k0chu.mcOneSlot.mixin;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

    @ModifyConstant(method = "handleInputEvents", constant = @Constant(intValue = 9))
    int handleInputEvents(int constant) {
        return 1;
    }
}
