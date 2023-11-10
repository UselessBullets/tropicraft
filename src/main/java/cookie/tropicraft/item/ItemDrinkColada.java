package cookie.tropicraft.item;

import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemDrinkColada extends ItemDrink {

    public ItemDrinkColada(int id) {
        super(id);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
        world.playSoundAtEntity(entityplayer, "tropicraft.gulp", 1.0f, 1.0f);

        if (!world.isClientSide) {
            if (world.getWorldTime() > 10500 && world.getWorldTime() < 11100)
                entityplayer.handlePortal(TropicraftBlocks.tropicsPortal.id);

            if (entityplayer.gamemode.consumeBlocks) {
                itemstack.consumeItem(entityplayer);
                return new ItemStack(TropicraftItems.mugEmpty);
            }
        }
        return itemstack;
    }
}
