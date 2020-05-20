package fr.leonard.papier;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Papier.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Papier.MODID)
public class ItemPapier {

    //public static final Item item = null;

    @SubscribeEvent
    public static void registerItem(final RegistryEvent.Register<Item> e){
        e.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("item"));
    }
}