package com.minenash.milk_bottles.items;//package net.fabricmc.example.items;
//
//import net.fabricmc.example.MilkBottles;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.*;
//import net.minecraft.potion.PotionUtil;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
//import net.minecraft.world.World;
//
//public class SplashMilkBottleItem extends SplashPotionItem {
//
//    public SplashMilkBottleItem() {
//        super(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1).group(ItemGroup.MISC));
//    }
//
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        PotionUtil.setCustomPotionEffects(user.getStackInHand(hand), MilkBottles.CLEARING_LIST);
//        return super.use(world, user, hand);
//    }
//
//}
