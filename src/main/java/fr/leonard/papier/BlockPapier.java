package fr.leonard.papier;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Papier.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Papier.MODID)
public class BlockPapier {

    public static final Block spirale = null;

    @SubscribeEvent
    public static void registerBlock(final RegistryEvent.Register<Block> e){
        e.getRegistry().register(new Block(Block.Properties.
                create(Material.ROCK).
                hardnessAndResistance(2F, 6F).
                sound(SoundType.STONE).
                harvestTool(ToolType.PICKAXE).
                harvestLevel(1)).
                setRegistryName("spirale"));
    }

    @SubscribeEvent
    public static void registerBlockItem(final RegistryEvent.Register<Item> e){
        e.getRegistry().register(new BlockItem(spirale, new Item.Properties().group(ItemGroup.MISC)).setRegistryName("spirale"));
    }
}
