package com.ppoitier.esmeraldas.core;

import com.ppoitier.esmeraldas.Esmeraldas;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Esmeraldas.ID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Esmeraldas.ID);

    public static final RegistryObject<Block> SPEEDER = registerBlock(
            "speeder",
            () -> new Block(
                    BlockBehaviour.Properties
                            .of(Material.METAL, MaterialColor.EMERALD)
                            .strength(5.0F, 6.0F)
                            .sound(SoundType.METAL)
            )
    );

    public static final RegistryObject<Item> SPEEDER_ITEM = registerBlockItem(
            "speeder",
            SPEEDER,
            CreativeModeTab.TAB_REDSTONE
    );

    private static RegistryObject<Block> registerBlock(String name, Supplier<Block> blockSupplier) {
        return BLOCKS.register(name, blockSupplier);
    }

    private static RegistryObject<Item> registerBlockItem(String name, RegistryObject<Block> block, CreativeModeTab tab) {
        return BLOCK_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

}
