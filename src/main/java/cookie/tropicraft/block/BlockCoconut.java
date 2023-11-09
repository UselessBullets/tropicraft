package cookie.tropicraft.block;

import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockCoconut extends Block {

	public BlockCoconut(String key, int id) {
		super(key, id, Material.wood);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		Random random = new Random();
		if (dropCause == EnumDropCause.EXPLOSION || dropCause == EnumDropCause.PROPER_TOOL)
			return new ItemStack[]{new ItemStack(TropicraftItems.foodCoconutChunk, random.nextInt(4 - 1) + 1)};
		else
			return new ItemStack[]{new ItemStack(this)};
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
	public AABB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
}
