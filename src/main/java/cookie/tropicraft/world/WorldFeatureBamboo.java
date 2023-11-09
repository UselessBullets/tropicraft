package cookie.tropicraft.world;

import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureBamboo extends WorldFeature {

	public boolean generate(World world, Random random, int x, int y, int z) {
		for(int height = 0; height < 20; ++height) {
			int randX = x + random.nextInt(4) - random.nextInt(4);
			int randZ = z + random.nextInt(4) - random.nextInt(4);
			if (world.isAirBlock(randX, y, randZ)
				&& (
				world.getBlockMaterial(randX - 1, y - 1, randZ) == Material.water
					|| world.getBlockMaterial(randX + 1, y - 1, randZ) == Material.water
					|| world.getBlockMaterial(randX, y - 1, randZ - 1) == Material.water
					|| world.getBlockMaterial(randX, y - 1, randZ + 1) == Material.water)) {
				int randHeight = 5 + random.nextInt(random.nextInt(10) + 1);

				for(int bambooHeight = 0; bambooHeight < randHeight; ++bambooHeight) {
					if (TropicraftBlocks.blockBamboo.canBlockStay(world, randX, y + bambooHeight, randZ)) {
						world.setBlock(randX, y + bambooHeight, randZ, TropicraftBlocks.blockBamboo.id);
					}
				}
			}
		}

		return true;
	}
}
