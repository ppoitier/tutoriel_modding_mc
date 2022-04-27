package com.ppoitier.esmeraldas;

import com.mojang.logging.LogUtils;
import com.ppoitier.esmeraldas.core.ItemRegistry;
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
    }

    public void onCommonSetup(FMLCommonSetupEvent event) {
        logger.info("COMMON SETUP!");
    }

    public void onClientSetup(FMLClientSetupEvent event) {
        logger.info("CLIENT SETUP!");
    }

}


