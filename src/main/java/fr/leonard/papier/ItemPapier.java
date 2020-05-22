package fr.leonard.papier;

import fr.leonard.papier.common.items.AppleEdenItem;
import fr.leonard.papier.common.items.SpiraleItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = Papier.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(Papier.MODID)
public class ItemPapier {


    public static final Item spiraleitem = null;
    public static final Item appleeden = null;
    
    public static final Item altairsword = null;

    @SubscribeEvent
    public static void registerItem(final RegistryEvent.Register<Item> e){
        e.getRegistry().register(new SpiraleItem(new Item.Properties()
                .group(Papier.PapierItemGroup.instance))
                .setRegistryName("spiraleitem"));

        e.getRegistry().register(new SwordItem(
                AltairTier.ALTAIR_TIER,
                6,
                8F,
                new Item.Properties().group(Papier.PapierItemGroup.instance))
                .setRegistryName("altairsword"));

        e.getRegistry().register(new AppleEdenItem(new Item.Properties()
                .group(Papier.PapierItemGroup.instance))
                .setRegistryName("appleeden"));
    }

    public enum AltairTier implements IItemTier {
        ALTAIR_TIER(6, 999999999, 16F, 6F, 800, () -> {
            return Ingredient.fromItems(ItemPapier.spiraleitem);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;

        AltairTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }
}
