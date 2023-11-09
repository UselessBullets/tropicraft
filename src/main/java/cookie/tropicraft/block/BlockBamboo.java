package cookie.tropicraft.block;

import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.BlockSugarcane;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockBamboo extends BlockSugarcane {

	public BlockBamboo(String key, int id) {
		super(key, id);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return new ItemStack[]{new ItemStack(TropicraftItems.itemBamboo)};
	}
}
