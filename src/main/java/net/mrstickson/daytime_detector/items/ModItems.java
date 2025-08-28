package net.mrstickson.daytime_detector.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mrstickson.daytime_detector.DayTime_Detector;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DayTime_Detector.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
