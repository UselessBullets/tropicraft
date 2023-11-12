package cookie.tropicraft.world.feature;

import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTree;

import java.util.Random;

public class WorldFeatureTreeCitrus extends WorldFeatureTree {
    private final int leavesMetadata;

    public WorldFeatureTreeCitrus(int leavesID, int leavesMetadata, int logID, int heightMod) {
        super(leavesID, logID, heightMod);
        this.leavesMetadata = leavesMetadata;
    }

    @Override
    public void placeLeaves(World world, int x, int y, int z, Random rand) {
        world.setBlockAndMetadataWithNotify(x, y, z, leavesID, leavesMetadata);
    }
}
