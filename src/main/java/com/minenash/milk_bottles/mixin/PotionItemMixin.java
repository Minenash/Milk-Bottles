package com.minenash.milk_bottles.mixin;

import com.minenash.milk_bottles.MilkBottles;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.PotionUtil;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(PotionItem.class)
public class PotionItemMixin {

    @Redirect(method = "appendStacks", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/collection/DefaultedList;add(Ljava/lang/Object;)Z"))
    public boolean addPotionToStack(DefaultedList<ItemStack> stacks, Object obj) {
        ItemStack stack = (ItemStack)obj;
        if (stack.getItem() == Items.POTION && PotionUtil.getPotion(stack) == MilkBottles.CLEARING_POTION)
            return false;
        return stacks.add(stack);
    }

    @Inject(method = "hasGlint", at = @At("HEAD"), cancellable = true)
    private void hasGlint(ItemStack stack, CallbackInfoReturnable<Boolean> callback) {
        List<StatusEffectInstance> statusEffectInstances = PotionUtil.getPotionEffects(stack);
        for (StatusEffectInstance instance : statusEffectInstances) {
            if (instance.getEffectType() == MilkBottles.CLEARING) {
                callback.setReturnValue(false);
                callback.cancel();
            }
        }
    }
}
