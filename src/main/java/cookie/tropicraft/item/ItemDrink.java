package cookie.tropicraft.item;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemDrink extends Item {

    public ItemDrink(int id) {
        super(id);
		setMaxStackSize(1);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {

		if (entityplayer.gamemode.consumeBlocks) {
			world.playSoundAtEntity(entityplayer, "tropicraft.gulp", 1.0f, 1.0f);
			if (!world.isClientSide) {
				itemstack.consumeItem(entityplayer);
				return new ItemStack(TropicraftItems.mugEmpty);
			}
		}
		return itemstack;
	}
}
