package cookie.tropicraft.block;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import net.minecraft.core.world.WorldSource;
import turniplabs.halplibe.helper.TextureHelper;

public class BlockFlowerIris extends Block {

	public BlockFlowerIris(String key, int id) {
		super(key, id, Material.plant);
	}

	int[][] flowerTexture = new int[][]{
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "flower_iris_bottom.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "flower_iris_top.png")
	};

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z).hasTag(BlockTags.GROWS_FLOWERS)) {
            return world.getBlockId(x, y, z) == this.id && world.getBlockId(x, y + 1, z) == this.id;
		}
		return false;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockID) {
		if (!world.isClientSide) {
			if (world.getBlockMetadata(x, y, z) != 1 && world.getBlockId(x, y + 1, z) != this.id && world.getBlockMetadata(x, y + 1, z) != 1)
				world.setBlockWithNotify(x, y, z, 0);

			if (world.getBlockId(x, y, z) != this.id && world.getBlockMetadata(x, y, z) != 0)
				world.setBlockWithNotify(x, y + 1, z, 0);

			if (world.getBlockId(x, y - 1, z) == 0)
				world.setBlockWithNotify(x, y, z, 0);
		}
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		if (world.getBlockId(x, y + 1, z) == 0 && world.getBlockId(x, y - 1, z) != 0) {
			return world.getBlock(x, y - 1, z).hasTag(BlockTags.GROWS_FLOWERS);
		}
		return false;
	}

	@Override
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		world.setBlock(x, y, z, this.id);
		world.setBlockAndMetadata(x, y + 1, z, this.id, 1);
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
		int sideID = side.getId();
		if (meta == 1)
			atlasIndices[sideID] = texCoordToIndex(flowerTexture[1][0], flowerTexture[1][1]);
		else
			atlasIndices[sideID] = texCoordToIndex(flowerTexture[0][0], flowerTexture[0][1]);

		return atlasIndices[sideID];
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

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(TropicraftItems.itemFlowerIris)};
	}
}
