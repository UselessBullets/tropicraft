package cookie.tropicraft.world.feature;

import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureAlgae;

import java.util.Random;

public class WorldFeatureAlgaeCranberries extends WorldFeature {
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		for(int worldHeight = 0; worldHeight < world.getHeightBlocks(); ++worldHeight) {
			int randX = x + random.nextInt(8) - random.nextInt(8);
			int randZ = z + random.nextInt(8) - random.nextInt(8);
			if (world.getBlockId(randX, y, randZ) == Block.fluidWaterStill.id && world.getBlockMaterial(randX, y + 1, randZ) == Material.air)
                world.setBlock(randX, y + 1, randZ, TropicraftBlocks.algaeCranberries.id);
		}

		return true;
	}
}
