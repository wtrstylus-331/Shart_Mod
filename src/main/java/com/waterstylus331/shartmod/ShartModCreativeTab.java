package com.waterstylus331.shartmod;

import com.waterstylus331.shartmod.block.ModBlocks;
import com.waterstylus331.shartmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ShartModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, ShartMod.MODID
    );

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = TABS.register("shartmod_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("creativetab.shartmod.shartmod_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.POOP_ITEM.get());
                        output.accept(ModBlocks.POOP_BLOCK.get());
                    }).build());

    public static void register(IEventBus iEventBus) {
        TABS.register(iEventBus);
    }
}
