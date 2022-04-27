package com.ppoitier.esmeraldas.client.renderers;

import com.ppoitier.esmeraldas.Esmeraldas;
import com.ppoitier.esmeraldas.client.models.ExampleEntityModel;
import com.ppoitier.esmeraldas.entities.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer<T extends ExampleEntity> extends MobRenderer<T, ExampleEntityModel<T>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(
            Esmeraldas.ID,
            "textures/entities/example_entity.png"
    );

    public ExampleEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }
}
