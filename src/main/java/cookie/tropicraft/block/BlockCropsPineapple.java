package cookie.tropicraft.block;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

import java.util.Random;

public class BlockCropsPineapple extends Block {

	private final int[][] cropTextures = new int[][] {
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "pineapple_top.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "pineapple_bottom.png")
	};

	public BlockCropsPineapple(String key, int id) {
		super(key, id, Material.plant);
		setBlockBounds(0.125f, 0.0f, 0.125f, 0.75f, 1.0f, 0.75f);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isClientSide) {
			int meta = world.getBlockMetadata(x, y, z);
			if (meta == 0 && world.getBlockId(x, y + 1, z) == 0)
				if (rand.nextInt((int) (10 / world.seasonManager.getCurrentSeason().cropGrowthFactor)) == 0)
					world.setBlockAndMetadataWithNotify(x, y + 1, z, this.id, 1);
		}
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
        if (world.getBlockId(x, y - 1, z) == 0) {
			dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, world.getBlockMetadata(x, y, z), null);
			return false;
		}
		return true;
    }

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.getBlock(x, y - 1, z).hasTag(BlockTags.GROWS_FLOWERS);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (world.getBlockId(x, y - 1, z) == 0)
			world.setBlockWithNotify(x, y, z, 0);
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
		int sideID = side.getId();
		if (meta == 1)
			atlasIndices[sideID] = texCoordToIndex(cropTextures[0][0], cropTextures[0][1]);
		else
			atlasIndices[sideID] = texCoordToIndex(cropTextures[1][0], cropTextures[1][1]);

		return atlasIndices[sideID];
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		if (meta == 1) {
			return new ItemStack[]{new ItemStack(TropicraftItems.foodPineapple)};
		} else
			return new ItemStack[]{new ItemStack(TropicraftItems.seedsPineapple)};
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
}
