package com.waterstylus331.shartmod.effect;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.UUID;

public class StinkyEffect extends MobEffect {
    // unique identifier
    private static final UUID STINKY_SPEED_UUID = UUID.fromString("a0a82e95-6a52-4e3c-a6a5-fcb3c2cfb3b5");

    public StinkyEffect(MobEffectCategory p_19451_) {
        super(p_19451_, 0);

        this.addAttributeModifier(
                Attributes.MOVEMENT_SPEED,
                ResourceLocation.parse(STINKY_SPEED_UUID.toString()),
                -0.3,
                AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        );
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
