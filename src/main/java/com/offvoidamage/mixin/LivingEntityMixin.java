package com.offvoidamage.mixin;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    private void offVoidDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        if (source.is(DamageTypes.FELL_OUT_OF_WORLD)) {
            cir.setReturnValue(false);
        }
    }
}
