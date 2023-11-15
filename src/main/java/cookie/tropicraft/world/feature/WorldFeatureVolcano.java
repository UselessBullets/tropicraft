package cookie.tropicraft.world.feature;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class WorldFeatureVolcano extends WorldFeature {

	// Thanks, Useless!
	private boolean blockInCircle(int blockX, int blockZ, double circleX, double circleZ, double radius){
		return Math.hypot(blockX + 0.5 - circleX, blockZ + 0.5 - circleZ) <= radius;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		for (int radius = 24; radius > y; radius -= 5) {
			int height = world.getHeightValue(x + radius, z + radius);
			for (int xp = x - radius; xp < x + radius; xp++) {
				for (int zp = z - radius; zp < z + radius; zp++) {
					if (!(blockInCircle(xp, zp, x, z, radius))) {
						continue;
					}

					boolean onCircle = !blockInCircle(xp, zp, x, z, radius - 1);
					for (int yp = height + 5; yp > 24; yp--) {
						if (onCircle) {
							if (world.getBlockId(xp, yp, zp) == 0 || yp < height) {
								world.setBlock(xp, yp, zp, Block.brickBasalt.id);
								continue;
							}
						}
						world.setBlock(xp, yp, zp, 0);
					}
				}
			}
		}
		return true;
	}
}
