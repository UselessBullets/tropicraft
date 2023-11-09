package cookie.tropicraft.block;

import cookie.tropicraft.world.WorldFeatureTreePalm;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;

import java.util.Random;

public class BlockSaplingPalm extends BlockSaplingBase {

	public BlockSaplingPalm(String key, int id) {
		super(key, id);
	}

	@Override
	public void growTree(World world, int x, int y, int z, Random random) {
		new WorldFeatureTreePalm().generate(world, random, x, y, z);
	}
}
