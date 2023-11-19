package cookie.tropicraft.entity;

import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class EntityVervet extends EntityAnimal {
	public ItemStack[] normalRewards = new ItemStack[]{
		new ItemStack(Item.cherry, 1, 0),
		new ItemStack(TropicraftItems.foodCranberries, 1, 0),
		new ItemStack(TropicraftItems.foodCoconutChunk, 1, 0)
	};
	public ItemStack[] rareRewards = new ItemStack[] {
		new ItemStack(Item.oreRawIron, 1, 0),
		new ItemStack(Item.oreRawGold, 1, 0),
		new ItemStack(Item.diamond, 1, 0)
	};

	public EntityVervet(World world) {
		super(world);
		skinName = "vervet";
		highestSkinVariant = 0;
		health = 20;
	}

	@Override
	public boolean interact(EntityPlayer entityplayer) {
		if (!world.isClientSide) {
			int randAcceptShells = random.nextInt(3);
			ItemStack currentItem = entityplayer.getHeldItem();

			if (currentItem != null && currentItem.stackSize > 0) {

				currentItem.consumeItem(entityplayer);

				if (currentItem.getItem() == TropicraftItems.shell && currentItem.getMetadata() == randAcceptShells || currentItem.getMetadata() == 4) {
					int randReward = random.nextInt(3);

					switch (randReward) {
						case 0:
							world.dropItem((int) x, (int) y, (int) z, new ItemStack(Item.cherry, 1));
							break;
						case 1:
							world.dropItem((int) x, (int) y, (int) z, new ItemStack(TropicraftItems.foodCranberries, 1));
							break;
						case 2:
							world.dropItem((int) x, (int) y, (int) z, new ItemStack(TropicraftItems.foodCoconutChunk, 1));
					}
				}

				if (currentItem.getItem() == TropicraftItems.shell && currentItem.getMetadata() == 3) {
					int randReward = random.nextInt(3);

					switch (randReward) {
						case 0:
							world.dropItem((int) x, (int) y, (int) z, new ItemStack(Item.oreRawIron, 1));
							break;
						case 1:
							world.dropItem((int) x, (int) y, (int) z, new ItemStack(Item.oreRawGold, 1));
							break;
						case 2:
							world.dropItem((int) x, (int) y, (int) z, new ItemStack(Item.diamond, 1));
					}
				}
				return true;
			}
		}
		return super.interact(entityplayer);
	}

	@Override
	public boolean canClimb() {
		return horizontalCollision;
	}
}
