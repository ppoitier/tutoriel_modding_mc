package com.ppoitier.esmeraldas.core;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class FoodRegistry {

    public static final FoodProperties SPEEDY_FOOD = (new FoodProperties.Builder())
            .nutrition(4)
            .saturationMod(1.2F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 3), 1.0F)
            .alwaysEat()
            .build();


}
