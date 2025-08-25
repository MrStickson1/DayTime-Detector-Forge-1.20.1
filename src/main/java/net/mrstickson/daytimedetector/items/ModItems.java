package net.mrstickson.daytimedetector.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.mrstickson.daytimedetector.DayTimeDetector;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DayTimeDetector.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
