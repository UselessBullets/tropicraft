package cookie.tropicraft.world;

import cookie.tropicraft.TropicraftTags;
import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeCherry;

import java.util.Random;

public class WorldFeatureTreePalm extends WorldFeature {

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if (y < world.getHeightBlocks()) {
			if (world.getBlock(x, y - 1, z).hasTag(TropicraftTags.GROWS_PALM_TREES)) {

				int randHeight = random.nextInt(4 - 1) + 1;

				for (int logY = y; logY < y + 7 + randHeight; logY++)
					world.setBlock(x, logY, z, TropicraftBlocks.logPalm.id);

				// Coconut spawning
				int randCoco = random.nextInt(5 - 1) + 1;
				switch (randCoco) {
					case 1:
						world.setBlock(x + 1, y + 6 + randHeight, z, TropicraftBlocks.coconut.id);
						world.setBlock(x - 1, y + 6 + randHeight, z, TropicraftBlocks.coconut.id);
						world.setBlock(x, y + 6 + randHeight, z + 1, TropicraftBlocks.coconut.id);
						world.setBlock(x, y + 6 + randHeight, z - 1, TropicraftBlocks.coconut.id);
						break;
					case 2:
						world.setBlock(x + 1, y + 6 + randHeight, z, TropicraftBlocks.coconut.id);
						world.setBlock(x - 1, y + 6 + randHeight, z, TropicraftBlocks.coconut.id);
						world.setBlock(x, y + 6 + randHeight, z + 1, TropicraftBlocks.coconut.id);
						break;
					case 3:
						world.setBlock(x + 1, y + 6 + randHeight, z, TropicraftBlocks.coconut.id);
						world.setBlock(x - 1, y + 6 + randHeight, z, TropicraftBlocks.coconut.id);
						break;
					case 4:
						world.setBlock(x + 1, y + 6 + randHeight, z, TropicraftBlocks.coconut.id);
						break;
					default:
						break;
				}

				world.setBlock(x, y + 8 + randHeight, z, TropicraftBlocks.leavesPalm.id);

				// The 3x1x3 ring of leaves at the top
				for (int leavesX = x - 1; leavesX < x + 2; leavesX++)
					for (int leavesZ = z - 1; leavesZ < z + 2; leavesZ++) {
						if (leavesX == x && leavesZ == z)
							world.setBlock(leavesX, y + 7 + randHeight, leavesZ, TropicraftBlocks.logPalm.id);
						else
							world.setBlock(leavesX, y + 7 + randHeight, leavesZ, TropicraftBlocks.leavesPalm.id);
					}

				// The extra leaves across the X axis
				for (int leavesCrossX = x - 3; leavesCrossX < x + 4; leavesCrossX++) {
					if (leavesCrossX == x)
						world.setBlock(leavesCrossX, y + 7 + randHeight, z, TropicraftBlocks.logPalm.id);
					else
						world.setBlock(leavesCrossX, y + 7 + randHeight, z, TropicraftBlocks.leavesPalm.id);
				}
				world.setBlock(x - 4, y + 6 + randHeight, z, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x + 4, y + 6 + randHeight, z, TropicraftBlocks.leavesPalm.id);

				// The extra leaves across the Z axis
				for (int leavesCrossZ = z - 3; leavesCrossZ < z + 4; leavesCrossZ++) {
					if (leavesCrossZ == z)
						world.setBlock(x, y + 7 + randHeight, leavesCrossZ, TropicraftBlocks.logPalm.id);
					else
						world.setBlock(x, y + 7 + randHeight, leavesCrossZ, TropicraftBlocks.leavesPalm.id);
				}
				world.setBlock(x, y + 6 + randHeight, z - 4, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x, y + 6 + randHeight, z + 4, TropicraftBlocks.leavesPalm.id);

				// The diagonal leaf blocks
				world.setBlock(x + 4, y + 6 + randHeight, z - 4, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x + 3, y + 7 + randHeight, z - 3, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x + 2, y + 7 + randHeight, z - 2, TropicraftBlocks.leavesPalm.id);

				world.setBlock(x - 4, y + 6 + randHeight, z + 4, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x - 3, y + 7 + randHeight, z + 3, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x - 2, y + 7 + randHeight, z + 2, TropicraftBlocks.leavesPalm.id);

				world.setBlock(x - 4, y + 6 + randHeight, z - 4, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x - 3, y + 7 + randHeight, z - 3, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x - 2, y + 7 + randHeight, z - 2, TropicraftBlocks.leavesPalm.id);

				world.setBlock(x + 4, y + 6 + randHeight, z + 4, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x + 3, y + 7 + randHeight, z + 3, TropicraftBlocks.leavesPalm.id);
				world.setBlock(x + 2, y + 7 + randHeight, z + 2, TropicraftBlocks.leavesPalm.id);

				return true;
			}
		}
        return false;
    }
}
