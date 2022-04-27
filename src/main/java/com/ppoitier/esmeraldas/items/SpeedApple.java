package com.ppoitier.esmeraldas.items;

import com.ppoitier.esmeraldas.core.FoodRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class SpeedApple extends Item {

    public SpeedApple() {
        super(
                new Properties()
                        .tab(CreativeModeTab.TAB_FOOD)
                        .stacksTo(16)
                        .food(FoodRegistry.SPEEDY_FOOD)
        );
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
        if (entity instanceof LivingEntity target) {
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 3));
            stack.shrink(1);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}
