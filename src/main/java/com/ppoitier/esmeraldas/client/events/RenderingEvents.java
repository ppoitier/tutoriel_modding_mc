package com.ppoitier.esmeraldas.client.events;

import com.ppoitier.esmeraldas.client.models.ExampleEntityModel;
import com.ppoitier.esmeraldas.client.renderers.ExampleEntityRenderer;
import com.ppoitier.esmeraldas.core.EntityRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public final class RenderingEvents {

    private RenderingEvents() {}

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegistry.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
    }

}
