package com.ppoitier.esmeraldas;

import com.mojang.logging.LogUtils;
import com.ppoitier.esmeraldas.client.events.RenderingEvents;
import com.ppoitier.esmeraldas.core.BlockRegistry;
import com.ppoitier.esmeraldas.core.EntityRegistry;
import com.ppoitier.esmeraldas.core.ItemRegistry;
import com.ppoitier.esmeraldas.core.events.EntityEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod("esmeraldas")
public class Esmeraldas {

    public static final String ID = "esmeraldas";
    public static final Logger logger = LogUtils.getLogger();

    public Esmeraldas() {
        IEventBus eventBus = FMLJavaModLoadingContext
                .get()
                .getModEventBus();

        eventBus.addListener(this::onCommonSetup);
        eventBus.addListener(this::onClientSetup);

        ItemRegistry.ITEMS.register(eventBus);
        BlockRegistry.BLOCKS.register(eventBus);
        BlockRegistry.BLOCK_ITEMS.register(eventBus);
        EntityRegistry.ENTITIES.register(eventBus);

        eventBus.register(EntityEvents.class);
        eventBus.register(RenderingEvents.class);
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
        logger.info("COMMON SETUP!");
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        logger.info("CLIENT SETUP!");
    }

}


