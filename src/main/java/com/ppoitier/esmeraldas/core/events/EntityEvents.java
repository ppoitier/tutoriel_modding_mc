package com.ppoitier.esmeraldas.core.events;

import com.ppoitier.esmeraldas.core.EntityRegistry;
import com.ppoitier.esmeraldas.entities.ExampleEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EntityEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityRegistry.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
    }

}
