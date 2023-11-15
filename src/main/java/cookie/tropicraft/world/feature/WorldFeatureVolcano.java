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
	private int getRadius(double initialRadius, double endingRadius, double height, double currentHeight){
		double d = (initialRadius - endingRadius)/(height*height);
		return (int) (d * Math.pow(currentHeight - height, 2) + endingRadius);
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		int initialRadius = random.nextInt(10) + 15;
		int endingRadius = Math.max(initialRadius - 5 - random.nextInt(5), initialRadius/2);
		int height = random.nextInt(30) + 50;
		int yOffset = -20;

		for (int yb = y; yb < y + height; yb++) {
			int radius = getRadius(initialRadius, endingRadius, height, yb - y);
			for (int xb = x - radius; xb < x + radius; xb++) {
				for (int zb = z - radius; zb < z + radius; zb++) {
					if (!blockInCircle(xb, zb, x, z, radius)) continue;
					boolean inPit = blockInCircle(xb, zb, x, z, endingRadius);
					world.setBlock(xb, yb + yOffset, zb, inPit ? 0 : Block.basalt.id);
				}
			}
		}
		return true;
	}
}
