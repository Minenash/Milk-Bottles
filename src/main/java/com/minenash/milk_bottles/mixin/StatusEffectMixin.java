package com.minenash.milk_bottles.mixin;

import com.minenash.milk_bottles.MilkBottles;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StatusEffect.class)
public class StatusEffectMixin {

    @Inject(method = "applyInstantEffect", at = @At("HEAD"), cancellable = true)
    public void applyInstantEffect(Entity source, Entity attacker, LivingEntity target, int amplifier, double proximity, CallbackInfo info) {
        if ( ((StatusEffect)(Object)this) == MilkBottles.CLEARING) {
            target.clearStatusEffects();
            info.cancel();
        }
    }

}
