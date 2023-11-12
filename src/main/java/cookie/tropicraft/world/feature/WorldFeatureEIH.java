package cookie.tropicraft.world.feature;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureEIH extends WorldFeature {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if (y >= 64 && y < world.getHeightBlocks()) {
			if ((!world.isAirBlock(x, y + 1, z) || !world.isAirBlock(x, y, z)) && !world.isAirBlock(x, y - 1, z) && (world.getBlockId(x, y, z) == Block.dirt.id || world.getBlockId(x, y, z) == Block.grass.id)) {
				y -= 2;
				int workX;
				int workY;
				int workZ;

				// main body
				for (workY = -5; workY < 7; workY++) {
					for (workX = 0; workX < 4; workX++) {
						world.setBlockRaw(x + workX, y + workY, z + 1, Block.basalt.id);
						world.setBlockRaw(x + workX, y + workY, z + 2, Block.basalt.id);
					}

					world.setBlockRaw(x + 1, y + workY, z, Block.basalt.id);
					world.setBlockRaw(x + 3, y + workY, z, Block.basalt.id);

					world.setBlockRaw(x + 1, y + workY, z + 3, Block.basalt.id);
					world.setBlockRaw(x + 3, y + workY, z + 3, Block.basalt.id);

					if (workY > -5) {
						world.setBlockRaw(x + 1, y + workY, z + 1, Block.basalt.id);
						world.setBlockRaw(x + 1, y + workY, z + 2, Block.basalt.id);
					}
				}

				// mouth
				for (workY = 2; workY < 4; workY++) {
					for (workZ = 0; workZ < 4; workZ++) {
						world.setBlock(x, y + workY, z + workZ, Block.basalt.id);
						world.setBlock(x - 1, y + workY, z + workZ, Block.basalt.id);
					}
				}

				// inner ears
				for (workY = 4; workY < 7; workY++) {
					world.setBlock(x + 2, y + workY, z, Block.basalt.id);
					world.setBlock(x + 2, y + workY, z + 3, Block.basalt.id);
				}

				// back
				world.setBlock(x, y + 4, z, Block.basalt.id);
				world.setBlock(x, y + 4, z + 3, Block.basalt.id);

				world.setBlock(x - 1, y + 5, z + 1, Block.basalt.id);
				world.setBlock(x - 1, y + 5, z + 2, Block.basalt.id);

				// big cube
				for (workY = 5; workY < 9; workY++) {
					for (workX = 0; workX < 3; workX++) {
						for (workZ = 0; workZ < 4; workZ++)
							world.setBlock(x + 2 + workX, y + workY, z + workZ, Block.basalt.id);
					}
				}

				// ears
				for (workY = 6; workY < 8; workY++) {
					for (workX = 1; workX < 3; workX++) {
						world.setBlock(x + 1 + workX, y + workY, z - 1, Block.basalt.id);
						world.setBlock(x + 1 + workX, y + workY, z + 4, Block.basalt.id);
					}
				}

				// big cube lava
				for (workY = 6; workY < 8; workY++) {
					for (workZ = 1; workZ < 3; workZ++) {
						for (workX = 1; workX < 4; workX++) {
							world.setBlock(x + workX, y + workY, z + workZ, Block.fluidLavaStill.id);
						}
					}
				}

				// nose top
				for (workZ = 1; workZ < 3; workZ++)
					world.setBlock(x + 1, y + 7, z + workZ, Block.basalt.id);

				// eyes
				int[] eyeMaterial = {Block.blockDiamond.id, Block.blockGold.id, Block.blockIron.id, Block.glowstone.id};
				int eye = eyeMaterial[random.nextInt(4)];

				world.setBlock(x + 2, y + 7, z, eye);
				world.setBlock(x + 2, y + 7, z + 3, eye);

				return true;
			}
		}
		return false;
	}
}
