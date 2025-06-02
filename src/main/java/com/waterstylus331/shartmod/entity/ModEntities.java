package com.waterstylus331.shartmod.entity;

import com.waterstylus331.shartmod.ShartMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            ShartMod.MODID);

    public static final RegistryObject<EntityType<PoopProjectile>> POOP_ENTITY = ENTITIES.register("poop_entity",
            () -> EntityType.Builder.<PoopProjectile>of(PoopProjectile::new, MobCategory.MISC).sized(0.5f,1.15f)
                    .build("poop_entity"));

    public static void register(IEventBus bus) {
        ENTITIES.register(bus);
    }
}
