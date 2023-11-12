package cookie.tropicraft.world.feature;

import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeaturePineapple extends WorldFeature {
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z).hasTag(BlockTags.GROWS_FLOWERS)) {
			world.setBlockAndMetadata(x, y, z, TropicraftBlocks.cropsPineapple.id, 0);
			world.setBlockAndMetadata(x, y + 1, z, TropicraftBlocks.cropsPineapple.id, 1);

			return true;
		}
		return false;
	}
}
