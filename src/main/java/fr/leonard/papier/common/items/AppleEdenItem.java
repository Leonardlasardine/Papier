package fr.leonard.papier.common.items;

import fr.leonard.papier.Papier;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Random;

public class AppleEdenItem extends Item {

    public AppleEdenItem(Properties properties) {
        super(properties);
    }

    @Override
    public void setDamage(ItemStack stack, int damage) {
        stack.setDamage(-4);
    }

    @ParametersAreNonnullByDefault
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        Random random = new Random();
        int r = random.nextInt(5);
        Papier.LOGGER.debug(r);
        if (r == 0) {
            //TODO Ajouter un truc
        } else if (r == 1) {
            //TODO Ajouter un truc
        } else if (r == 2) {
            //Éclair sur le joueur
            LightningBoltEntity light = new LightningBoltEntity(worldIn, playerIn.chasingPosX, playerIn.chasingPosY, playerIn.chasingPosZ, false);
            worldIn.addEntity(light);
        } else if (r == 3) {
            //Plusieurs éclairs à une distance variable de 10 blocks et 3 de hauteur
            for (int i = 0; i < 21; i++) {
                    Random random1 = new Random();
                    int dist = random1.nextInt(10);

                    Random random2 = new Random();
                    int positif = random2.nextInt(1);

                    Random random3 = new Random();
                    int distY = random3.nextInt(3);

                    double x;
                    double y;
                    double z;

                    if (positif == 0) {
                        x = playerIn.chasingPosX - dist;
                        y = playerIn.chasingPosY;
                        z = playerIn.chasingPosZ - dist;
                    } else {
                        x = playerIn.chasingPosX + dist;
                        y = playerIn.chasingPosY + distY;
                        z = playerIn.chasingPosZ + dist;
                    }

                    LightningBoltEntity light = new LightningBoltEntity(worldIn, x, y, z, false);
                    worldIn.addEntity(light);
            }
        } else if (r == 4) {
            //TODO Ajouter un truc
        } else  if (r == 5) {
            //TODO Ajouter un truc
        }

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
