package cookie.tropicraft.world.feature;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureBasaltSpike extends WorldFeature {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if (y < world.getHeightBlocks())
			if (world.getBlock(x, y - 1, z) != null)
				if (world.getBlock(x, y - 1, z) == Block.basalt) {

                    for (int spikeY = 0; spikeY < 5; spikeY++)
                        world.setBlock(x, y + spikeY, z, Block.basalt.id);

                    world.setBlock(x + 1, y, z, Block.basalt.id);
                    world.setBlock(x - 1, y, z, Block.basalt.id);
                    world.setBlock(x, y, z + 1, Block.basalt.id);
                    world.setBlock(x, y, z - 1, Block.basalt.id);

                    return true;
                }
		return false;
	}
}
