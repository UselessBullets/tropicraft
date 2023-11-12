package cookie.tropicraft.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.season.Seasons;

import java.util.Random;

public class BlockLeavesFlowering extends BlockLeavesBase {
	public BlockLeavesFlowering(String key, int id, Material material, boolean flag) {
		super(key, id, material, flag);
	}

	@Override
	protected Block getSapling() {
		return TropicraftBlocks.saplingFlowering;
	}

	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		int flowerDrop = new Random().nextInt(4 - 1) + 1;
		if (!world.isClientSide) {
			if (world.getBlockMetadata(x, y, z) == 1) {
				world.dropItem(x, y, z, new ItemStack(Block.flowerYellow, flowerDrop));
				world.setBlockMetadataWithNotify(x, y, z, 0);
				world.markBlockNeedsUpdate(x, y, z);
			}
		}
		return super.blockActivated(world, x, y, z, player);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isClientSide) {
			if (world.getBlockMetadata(x, y, z) == 0 && rand.nextInt(30) == 0 && world.seasonManager.getCurrentSeason() == Seasons.OVERWORLD_WINTER)
				world.setBlockMetadataWithNotify(x, y, z, 1);

			if (world.getBlockMetadata(x, y, z) == 1 && world.seasonManager.getCurrentSeason() != Seasons.OVERWORLD_WINTER)
				world.setBlockMetadataWithNotify(x, y, z, 1);
		}
		super.updateTick(world, x, y, z, rand);
	}

	@Override
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		world.setBlockAndMetadata(x, y, z, this.id, 1);
	}
}
