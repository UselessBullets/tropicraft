package cookie.tropicraft.world;

import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import useless.terrainapi.generation.overworld.ChunkDecoratorOverworldAPI;

public class TropicraftWorldgen {

	public void initializeWorldGen() {
		ChunkDecoratorOverworldAPI.biomeFeatures.addFeatureSurface(
			new WorldFeatureBamboo(),
			2,
			new Biome[]{Biomes.OVERWORLD_RAINFOREST}
		);

		ChunkDecoratorOverworldAPI.biomeFeatures.addFeatureSurface(
			new WorldFeaturePineapple(),
			1,
			new Biome[]{Biomes.OVERWORLD_RAINFOREST}
		);

		ChunkDecoratorOverworldAPI.randomFeatures.addFeatureSurface(
			new WorldFeatureTreePalm(),
                10
		);
	}
}
