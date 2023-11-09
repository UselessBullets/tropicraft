package cookie.tropicraft.block;

import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.season.Season;
import net.minecraft.core.world.season.Seasons;

import java.util.Random;

public class BlockLeavesCitrus extends BlockLeavesBase {

	public BlockLeavesCitrus(String key, int id, boolean flag) {
		super(key, id, Material.leaves, flag);
	}

	@Override
	protected Block getSapling() {
		return TropicraftBlocks.saplingCitrus;
	}

	private ItemStack getFruitChance() {
		int dropRand = new Random().nextInt(5 - 1) + 1;

		switch (dropRand) {
			case 1:
				return new ItemStack(TropicraftItems.foodOrange);
			case 2:
				return new ItemStack(TropicraftItems.foodLemon);
			case 3:
				return new ItemStack(TropicraftItems.foodLime);
			case 4:
				return new ItemStack(TropicraftItems.foodGrapefruit);
			default:
				throw new IllegalStateException("Unexpected value: " + dropRand);
		}
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		Season season = world.seasonManager.getCurrentSeason();
		float dropRate = season != null ? 20.0F / season.saplingDropFactor : 20.0F;
		if (dropCause == EnumDropCause.SILK_TOUCH || dropCause == EnumDropCause.PICK_BLOCK)
			return new ItemStack[]{new ItemStack(this, 1, 0)};

		else if (meta == 1) {
			if (world.rand.nextInt(MathHelper.floor_double(dropRate)) != 0)
				return new ItemStack[]{new ItemStack(getSapling())};
			return new ItemStack[]{getFruitChance()};

		} else
			return new ItemStack[0];
	}

	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		if (!world.isClientSide) {
			if (world.getBlockMetadata(x, y, z) == 1) {
				world.dropItem(x, y, z, getFruitChance());
				world.setBlockMetadataWithNotify(x, y, z, 0);
				world.markBlockNeedsUpdate(x, y, z);
			}
		}
		return super.blockActivated(world, x, y, z, player);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isClientSide) {
			if (world.getBlockMetadata(x, y, z) == 0 && rand.nextInt(30) == 0 && world.seasonManager.getCurrentSeason() == Seasons.OVERWORLD_SUMMER)
				world.setBlockMetadataWithNotify(x, y, z, 1);
		}
		super.updateTick(world, x, y, z, rand);
	}

	@Override
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		world.setBlockAndMetadata(x, y, z, this.id, 1);
	}
}
