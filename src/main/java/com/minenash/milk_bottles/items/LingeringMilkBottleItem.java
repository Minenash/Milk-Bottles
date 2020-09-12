package com.minenash.milk_bottles.items;//package net.fabricmc.example.items;
//
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.fabricmc.example.MilkBottles;
//import net.minecraft.client.item.TooltipContext;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.*;
//import net.minecraft.potion.PotionUtil;
//import net.minecraft.text.Text;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
//import net.minecraft.world.World;
//
//import java.util.List;
//
//public class LingeringMilkBottleItem extends LingeringPotionItem {
//
//    public LingeringMilkBottleItem() {
//        super(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).maxCount(1).group(ItemGroup.MISC));
//    }
//
//    @Environment(EnvType.CLIENT)
//    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
//        PotionUtil.buildTooltip(stack, tooltip, 0.25F);
//    }
//
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
//        PotionUtil.setCustomPotionEffects(user.getStackInHand(hand), MilkBottles.CLEARING_LIST);
//        return super.use(world, user, hand);
//    }
//
//}
