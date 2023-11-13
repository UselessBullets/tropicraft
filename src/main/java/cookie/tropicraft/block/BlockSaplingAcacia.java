package cookie.tropicraft.block;

import cookie.tropicraft.world.feature.WorldFeatureTreeAcacia;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class BlockSaplingAcacia extends BlockSaplingBase {

	public BlockSaplingAcacia(String key, int id) {
		super(key, id);
	}

	@Override
	public void growTree(World world, int x, int y, int z, Random random) {
		world.setBlock(x, y, z, 0);
		WorldFeature tree = new WorldFeatureTreeAcacia();
		if (!tree.generate(world, random, x, y, z))
			world.setBlock(x, y, z, this.id);
	}
}
