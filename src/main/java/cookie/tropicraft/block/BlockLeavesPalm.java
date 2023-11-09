package cookie.tropicraft.block;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLeavesBase;
import net.minecraft.core.block.material.Material;

public class BlockLeavesPalm extends BlockLeavesBase {

	public BlockLeavesPalm(String key, int id, Material material, boolean flag) {
		super(key, id, material, flag);
	}

	@Override
	protected Block getSapling() {
		return TropicraftBlocks.saplingPalm;
	}
}
