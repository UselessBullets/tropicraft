package cookie.tropicraft.world.feature;

import cookie.tropicraft.TropicraftConfig;
import cookie.tropicraft.TropicraftTags;
import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureTropicalCactus extends WorldFeature {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if (world.getBlock(x, y - 1, z).hasTag(BlockTags.GROWS_CACTI) ||
			world.getBlock(x, y - 1, z).hasTag(TropicraftTags.GROWS_TROPICAL_CACTUS)) {

			for (int growthY = 0; growthY < random.nextInt(4 - 1) + 1; growthY++)
				world.setBlock(x, y + growthY, z, TropicraftBlocks.tropicalCactus.id);

			return true;
		}
		return false;
	}
}
