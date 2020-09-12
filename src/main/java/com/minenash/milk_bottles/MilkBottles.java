package com.minenash.milk_bottles;

import com.minenash.milk_bottles.items.MilkBottleItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class MilkBottles {

	public static final StatusEffect CLEARING = Registry.register(Registry.STATUS_EFFECT, id("clearing"), new InstantStatusEffect(StatusEffectType.NEUTRAL, 16777215));
	//public static final Collection<StatusEffectInstance> CLEARING_LIST = Collections.singletonList(new StatusEffectInstance(CLEARING, 1));
	public static final Potion CLEARING_POTION = Registry.register(Registry.POTION, "clearing", new Potion(new StatusEffectInstance(CLEARING, 1)));

	public static final Item MILK_BOTTLE = Registry.register(Registry.ITEM, id("milk_bottle"), new MilkBottleItem());;

	public static Identifier id(String path) {
		return new Identifier("milk_bottles", path);
	}
}
