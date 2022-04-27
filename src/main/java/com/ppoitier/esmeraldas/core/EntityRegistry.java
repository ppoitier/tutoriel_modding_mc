package com.ppoitier.esmeraldas.core;

import com.ppoitier.esmeraldas.Esmeraldas;
import com.ppoitier.esmeraldas.entities.ExampleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityRegistry {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Esmeraldas.ID);

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = registerEntity(
            "example_entity",
            EntityType.Builder
                    .of(ExampleEntity::new, MobCategory.CREATURE)
                    .sized(.8f, .6f)
    );

    public static <T extends Entity> RegistryObject<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        ResourceLocation location = new ResourceLocation(Esmeraldas.ID, name);
        return ENTITIES.register(name, () -> builder.build(location.toString()));
    }

}
