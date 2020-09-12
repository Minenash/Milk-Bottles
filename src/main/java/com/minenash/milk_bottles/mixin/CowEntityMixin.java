package com.minenash.milk_bottles.mixin;

import com.minenash.milk_bottles.MilkBottles;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CowEntity.class)
public class CowEntityMixin {
	@Inject(method = "interactMob", at = @At("HEAD"), cancellable = true)
	public void interactMob(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> info) {
		ItemStack itemStack = player.getStackInHand(hand);
		if (itemStack.getItem() == Items.GLASS_BOTTLE && !((CowEntity)(Object)this).isBaby()) {
			player.playSound(SoundEvents.ENTITY_COW_MILK, 1.0F, 1.0F);
			ItemStack itemStack2 = ItemUsage.method_30012(itemStack, player, MilkBottles.MILK_BOTTLE.getStackForRender());
			player.setStackInHand(hand, itemStack2);
			info.setReturnValue(ActionResult.success(((CowEntity)(Object)this).world.isClient));
			info.cancel();
		}
	}
}
