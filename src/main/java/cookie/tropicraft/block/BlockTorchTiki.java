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
import turniplabs.halplibe.helper.TextureHelper;

import java.util.Random;

public class BlockTorchTiki extends Block {

	public BlockTorchTiki(String key, int id) {
		super(key, id, Material.decoration);
	}

	int[][] torchTexture = new int[][]{
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "tikitorch_bottom.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "tikitorch_top.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "tikitorch_overlay.png")
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
		if (world.getBlock(x, y - 1, z) != null)
        	return world.getBlockId(x, y + 1, z) == 0 && world.getBlock(x, y - 1, z).isOpaqueCube();
		else return false;
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
			atlasIndices[sideID] = texCoordToIndex(torchTexture[1][0], torchTexture[1][1]);
		else
			atlasIndices[sideID] = texCoordToIndex(torchTexture[0][0], torchTexture[0][1]);

		return atlasIndices[sideID];
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	@Override
	public AABB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		if (world.getBlockMetadata(x, y, z) == 1)
			return AABB.getBoundingBoxFromPool(x + 0.375f, y, z + 0.375f, x + 0.625f, y + 0.75f, z + 0.625f);
		return AABB.getBoundingBoxFromPool(x + 0.375f, y, z + 0.375f, x + 0.625f, y + 1.0f, z + 0.625f);
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
		return new ItemStack[]{new ItemStack(TropicraftItems.torchTiki)};
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		int meta = world.getBlockMetadata(x, y, z);
		double particleX = (float)x + 0.5F;
		double particleY = (float)y + 0.7F;
		double particleZ = (float)z + 0.5F;

		if (meta == 1) {
			world.spawnParticle("smoke", particleX, particleY, particleZ, 0.0, 0.0, 0.0);
			world.spawnParticle("flame", particleX, particleY, particleZ, 0.0, 0.0, 0.0);
		}
	}
}
