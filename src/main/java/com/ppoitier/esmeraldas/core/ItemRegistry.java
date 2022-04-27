package com.ppoitier.esmeraldas.core;

import com.ppoitier.esmeraldas.Esmeraldas;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ItemRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Esmeraldas.ID);

    public static final RegistryObject<Item> SPEED_APPLE = register(
            "speed_apple",
            () -> new Item(
                    new Item.Properties()
                            .tab(CreativeModeTab.TAB_FOOD)
                            .stacksTo(16)
            )
    );

    private static RegistryObject<Item> register(String name, Supplier<Item> itemSupplier) {
        return ITEMS.register(name, itemSupplier);
    }

}
