package cookie.tropicraft.block;

import cookie.tropicraft.world.WorldFeatureTreeCitrus;
import cookie.tropicraft.world.WorldFeatureTreePalm;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockSaplingBase;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;

import java.util.Random;

public class BlockSaplingCitrus extends BlockSaplingBase {

    public BlockSaplingCitrus(String key, int id) {
        super(key, id);
    }

    public int randomLeafBlock() {
        Random random = new Random();
        if (random.nextInt(6) == 0)
            return 1;
        else
            return 0;
    }

    @Override
    public void growTree(World world, int x, int y, int z, Random random) {
        world.setBlock(x, y, z, 0);
        WorldFeature tree = new WorldFeatureTreeCitrus(TropicraftBlocks.leavesCitrus.id, randomLeafBlock(), Block.logOak.id, 4);
        if (!tree.generate(world, random, x, y, z))
            world.setBlock(x, y, z, this.id);
    }
}
