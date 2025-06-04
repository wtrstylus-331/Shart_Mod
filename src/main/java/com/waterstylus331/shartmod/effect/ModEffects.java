package com.waterstylus331.shartmod.effect;

import com.waterstylus331.shartmod.ShartMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS,
            ShartMod.MODID);

    public static final RegistryObject<MobEffect> STINKY = EFFECTS.register("stinky",
            () -> new StinkyEffect(MobEffectCategory.NEUTRAL));

    public static void register(IEventBus bus) {
        EFFECTS.register(bus);
    }
}
