package cookie.tropicraft.block;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

import java.util.Random;

public class BlockAgave extends Block {

	int[][] texture = new int[][]{
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "agave.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "agave_bloom_bottom.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "agave_bloom_top.png")
	};

	public BlockAgave(String key, int id) {
		super(key, id, Material.plant);
		setBlockBounds(0.2F, 0.0F, 0.2F, 0.8F, 1.0F, 0.8F);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);
		if (!world.isClientSide) {
			if (rand.nextInt(100) == 0 && meta == 0) {
				world.setBlockMetadata(x, y, z, 1);
				world.setBlockAndMetadata(x, y + 1, z, this.id, 2);
			}
		}
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		int meta = world.getBlockMetadata(x, y, z);
        switch (meta) {
			case 0:
				if (world.getBlockId(x, y + 1, z) != 0) {
					world.setBlockWithNotify(x, y, z, 0);
					world.dropItem(x, y, z, new ItemStack(TropicraftItems.seedsAgave));
				}
				break;
			case 1:
				if (world.getBlockId(x, y + 1, z) == 0) {
					world.setBlockWithNotify(x, y, z, 0);
					world.dropItem(x, y, z, new ItemStack(TropicraftItems.seedsAgave));
				}
				break;
			case 2:
				if (world.getBlockId(x, y - 1, z) == 0) {
					world.setBlockWithNotify(x, y, z, 0);
					world.dropItem(x, y, z, new ItemStack(TropicraftItems.flowerAgave));
				}
				break;
		}

		if (world.getBlockId(x, y - 1, z) == 0) {
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
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		super.getBreakResult(world, dropCause, x, y, z, meta, tileEntity);
		meta = world.getBlockMetadata(x, y, z);
		if (meta != 2)
			return new ItemStack[]{new ItemStack(TropicraftItems.seedsAgave)};
		else
			return new ItemStack[]{new ItemStack(TropicraftItems.flowerAgave)};
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
	public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
		int sideID = side.getId();
        switch (meta) {
            case 0:
                atlasIndices[sideID] = texCoordToIndex(texture[0][0], texture[0][1]);
                break;
			case 1:
				atlasIndices[sideID] = texCoordToIndex(texture[1][0], texture[1][1]);
				break;
			case 2:
				atlasIndices[sideID] = texCoordToIndex(texture[2][0], texture[2][1]);
				break;
        }

		return atlasIndices[sideID];
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		if (world.getBlockId(x, y + 1, z) == 0 && world.getBlockId(x, y - 1, z) != 0) {
			return world.getBlock(x, y - 1, z).hasTag(BlockTags.GROWS_FLOWERS);
		}
		return false;
    }
}
