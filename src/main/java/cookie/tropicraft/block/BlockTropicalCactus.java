package cookie.tropicraft.block;

import cookie.tropicraft.TropicraftTags;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockCactus;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;

public class BlockTropicalCactus extends BlockCactus {

	public BlockTropicalCactus(String key, int id) {
		super(key, id);
	}

	@Override
	public boolean canBlockStay(World world, int x, int y, int z) {
		if (world.getBlockMaterial(x - 1, y, z).isSolid())
			return false;
        if (world.getBlockMaterial(x + 1, y, z).isSolid())
			return false;
        if (world.getBlockMaterial(x, y, z - 1).isSolid())
			return false;
        if (world.getBlockMaterial(x, y, z + 1).isSolid())
			return false;

        int blockUnder = world.getBlockId(x, y - 1, z);
        return Block.hasTag(blockUnder, BlockTags.GROWS_CACTI) || Block.hasTag(blockUnder, TropicraftTags.GROWS_TROPICAL_CACTUS);
    }
}
