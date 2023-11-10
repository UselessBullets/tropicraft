package cookie.tropicraft.item;

import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class ItemFoodPineapple extends ItemFood {

	public ItemFoodPineapple(String name, int id) {
		super(name, id, 3, false);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		if (entityplayer.health < 20 && itemstack.consumeItem(entityplayer)) {
			entityplayer.heal(healAmount);
			if (itemRand.nextInt(2) == 0)
				return new ItemStack(TropicraftItems.seedsPineapple);
			else
				return itemstack;
		}
		return itemstack;
	}
}
