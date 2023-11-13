package cookie.tropicraft.world.feature;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureTreeAcacia extends WorldFeature {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if (y < world.getHeightBlocks()) {
			if (world.getBlock(x, y - 1, z).hasTag(BlockTags.GROWS_TREES)) {
				// Trunk
				for (int trunkY = 0; trunkY < 3; trunkY++)
					world.setBlock(x, y + trunkY, z, Block.logOak.id);

				// Base leaves
				for (int leafX = -2; leafX < 3; leafX++)
					for (int leafZ = -2; leafZ < 3; leafZ++) {
						if (leafX == x && leafZ == z)
							world.setBlock(leafX, y + 6, leafZ, 0);

						world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);
					}

				world.setBlock(x, y + 7, z, Block.leavesOak.id);
				world.setBlock(x, y + 8, z, Block.leavesOak.id);

				// Branches
				int branchRandom = random.nextInt(5 - 1) + 1;
				switch (branchRandom) {
					// PosX Branch
					case 1: {
						// PosX
						world.setBlock(x + 1, y + 3, z, Block.logOak.id);
						world.setBlock(x + 2, y + 4, z, Block.logOak.id);
						world.setBlock(x + 2, y + 5, z, Block.logOak.id);
						world.setBlock(x + 3, y + 5, z, Block.leavesOak.id);

						for (int leafX = 3; leafX < 5; leafX++)
							for (int leafZ = -1; leafZ < 2; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x + 3, y + 6, z, Block.logOak.id);

						world.setBlock(x + 3, y + 7, z, Block.leavesOak.id);
						world.setBlock(x + 2, y + 7, z, Block.leavesOak.id);
						world.setBlock(x + 1, y + 7, z, Block.leavesOak.id);

						// NegX
						world.setBlock(x - 1, y + 3, z, Block.logOak.id);
						world.setBlock(x - 2, y + 4, z, Block.logOak.id);
						world.setBlock(x - 2, y + 5, z, Block.logOak.id);
						world.setBlock(x - 3, y + 5, z, Block.leavesOak.id);

						for (int leafX = -4; leafX < -2; leafX++)
							for (int leafZ = -1; leafZ < 2; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x - 3, y + 6, z, Block.logOak.id);

						world.setBlock(x - 3, y + 7, z, Block.leavesOak.id);
						world.setBlock(x - 2, y + 7, z, Block.leavesOak.id);
						world.setBlock(x - 1, y + 7, z, Block.leavesOak.id);

						// PosZ
						world.setBlock(x, y + 3, z + 1, Block.logOak.id);
						world.setBlock(x, y + 4, z + 2, Block.logOak.id);
						world.setBlock(x, y + 5, z + 2, Block.logOak.id);
						world.setBlock(x, y + 5, z + 3, Block.leavesOak.id);

						for (int leafX = -1; leafX < 2; leafX++)
							for (int leafZ = 3; leafZ < 5; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x, y + 6, z + 3, Block.logOak.id);

						world.setBlock(x, y + 7, z + 3, Block.leavesOak.id);
						world.setBlock(x, y + 7, z + 2, Block.leavesOak.id);
						world.setBlock(x, y + 7, z + 1, Block.leavesOak.id);

						// NegZ
						world.setBlock(x, y + 3, z - 1, Block.logOak.id);
						world.setBlock(x, y + 4, z - 2, Block.logOak.id);
						world.setBlock(x, y + 5, z - 2, Block.logOak.id);
						world.setBlock(x, y + 5, z - 3, Block.leavesOak.id);

						for (int leafX = -1; leafX < 2; leafX++)
							for (int leafZ = -4; leafZ < -2; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x, y + 6, z - 3, Block.logOak.id);

						world.setBlock(x, y + 7, z - 3, Block.leavesOak.id);
						world.setBlock(x, y + 7, z - 2, Block.leavesOak.id);
						world.setBlock(x, y + 7, z - 1, Block.leavesOak.id);
						break;
					}

					case 2: {
						// PosX
						world.setBlock(x + 1, y + 3, z, Block.logOak.id);
						world.setBlock(x + 2, y + 4, z, Block.logOak.id);
						world.setBlock(x + 2, y + 5, z, Block.logOak.id);
						world.setBlock(x + 3, y + 5, z, Block.leavesOak.id);

						for (int leafX = 3; leafX < 5; leafX++)
							for (int leafZ = -1; leafZ < 2; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x + 3, y + 6, z, Block.logOak.id);

						world.setBlock(x + 3, y + 7, z, Block.leavesOak.id);
						world.setBlock(x + 2, y + 7, z, Block.leavesOak.id);
						world.setBlock(x + 1, y + 7, z, Block.leavesOak.id);

						// NegX
						world.setBlock(x - 1, y + 3, z, Block.logOak.id);
						world.setBlock(x - 2, y + 4, z, Block.logOak.id);
						world.setBlock(x - 2, y + 5, z, Block.logOak.id);
						world.setBlock(x - 3, y + 5, z, Block.leavesOak.id);

						for (int leafX = -4; leafX < -2; leafX++)
							for (int leafZ = -1; leafZ < 2; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x - 3, y + 6, z, Block.logOak.id);

						world.setBlock(x - 3, y + 7, z, Block.leavesOak.id);
						world.setBlock(x - 2, y + 7, z, Block.leavesOak.id);
						world.setBlock(x - 1, y + 7, z, Block.leavesOak.id);

						// PosZ
						world.setBlock(x, y + 3, z + 1, Block.logOak.id);
						world.setBlock(x, y + 4, z + 2, Block.logOak.id);
						world.setBlock(x, y + 5, z + 2, Block.logOak.id);
						world.setBlock(x, y + 5, z + 3, Block.leavesOak.id);

						for (int leafX = -1; leafX < 2; leafX++)
							for (int leafZ = 3; leafZ < 5; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x, y + 6, z + 3, Block.logOak.id);

						world.setBlock(x, y + 7, z + 3, Block.leavesOak.id);
						world.setBlock(x, y + 7, z + 2, Block.leavesOak.id);
						world.setBlock(x, y + 7, z + 1, Block.leavesOak.id);
						break;
					}

					case 3: {
						// PosX
						world.setBlock(x + 1, y + 3, z, Block.logOak.id);
						world.setBlock(x + 2, y + 4, z, Block.logOak.id);
						world.setBlock(x + 2, y + 5, z, Block.logOak.id);
						world.setBlock(x + 3, y + 5, z, Block.leavesOak.id);

						for (int leafX = 3; leafX < 5; leafX++)
							for (int leafZ = -1; leafZ < 2; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x + 3, y + 6, z, Block.logOak.id);

						world.setBlock(x + 3, y + 7, z, Block.leavesOak.id);
						world.setBlock(x + 2, y + 7, z, Block.leavesOak.id);
						world.setBlock(x + 1, y + 7, z, Block.leavesOak.id);

						// NegX
						world.setBlock(x - 1, y + 3, z, Block.logOak.id);
						world.setBlock(x - 2, y + 4, z, Block.logOak.id);
						world.setBlock(x - 2, y + 5, z, Block.logOak.id);
						world.setBlock(x - 3, y + 5, z, Block.leavesOak.id);

						for (int leafX = -4; leafX < -2; leafX++)
							for (int leafZ = -1; leafZ < 2; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x - 3, y + 6, z, Block.logOak.id);

						world.setBlock(x - 3, y + 7, z, Block.leavesOak.id);
						world.setBlock(x - 2, y + 7, z, Block.leavesOak.id);
						world.setBlock(x - 1, y + 7, z, Block.leavesOak.id);
						break;
					}

					case 4: {
						// PosX
						world.setBlock(x + 1, y + 3, z, Block.logOak.id);
						world.setBlock(x + 2, y + 4, z, Block.logOak.id);
						world.setBlock(x + 2, y + 5, z, Block.logOak.id);
						world.setBlock(x + 3, y + 5, z, Block.leavesOak.id);

						for (int leafX = 3; leafX < 5; leafX++)
							for (int leafZ = -1; leafZ < 2; leafZ++)
								world.setBlock(x + leafX, y + 6, z + leafZ, Block.leavesOak.id);

						world.setBlock(x + 3, y + 6, z, Block.logOak.id);

						world.setBlock(x + 3, y + 7, z, Block.leavesOak.id);
						world.setBlock(x + 2, y + 7, z, Block.leavesOak.id);
						world.setBlock(x + 1, y + 7, z, Block.leavesOak.id);
						break;
					}
				}

				return true;
			}
		}
		return false;
	}
}
