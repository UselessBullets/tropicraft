package cookie.tropicraft.item;

import cookie.tropicraft.block.TropicraftBlocks;
import cookie.tropicraft.entity.EntityCoconut;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemCoconut extends Item {

	public ItemCoconut(String name, int id) {
		super(name, id);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		itemstack.consumeItem(entityplayer);
		world.playSoundAtEntity(entityplayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!world.isClientSide) {
			world.entityJoinedWorld(new EntityCoconut(world, entityplayer));
		}
		return itemstack;
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		blockX += side.getOffsetX();
		blockY += side.getOffsetY();
		blockZ += side.getOffsetZ();
		if (world.canBlockBePlacedAt(TropicraftBlocks.coconut.id, blockX, blockY, blockZ, false, side)) {
			world.setBlockWithNotify(blockX, blockY, blockZ, TropicraftBlocks.coconut.id);
			world.playSoundAtEntity(entityplayer, "step.wood", 1.0f, 0.75f);
			world.playSoundAtEntity(entityplayer, "liquid.splash", 0.075f, 2.0f);
			itemstack.consumeItem(entityplayer);
		}
		return true;
	}
}
