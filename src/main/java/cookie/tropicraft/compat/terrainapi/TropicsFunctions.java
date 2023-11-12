package cookie.tropicraft.compat.terrainapi;

import cookie.tropicraft.TropicraftConfig;
import cookie.tropicraft.world.feature.WorldFeatureEIH;
import useless.terrainapi.generation.Parameters;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;

import static useless.terrainapi.generation.overworld.OverworldFunctions.getTreeFeature;

public class TropicsFunctions {

	public static int getTreeDensity(Parameters parameters) {
		TerrainTropicsConfig tropicraftConfig = ChunkDecoratorTropicsAPI.tropicsConfig;
		ChunkDecoratorTropicsAPI decorator = (ChunkDecoratorTropicsAPI)parameters.decorator;

		Integer treeDensity = tropicraftConfig.getTreeDensity(parameters.biome);
		if (decorator.treeDensityOverride != -1) {
			return decorator.treeDensityOverride;
		} else if (treeDensity != null && treeDensity == -1000) {
			return 0;
		} else {
			int x = parameters.chunk.xPosition * 16;
			int z = parameters.chunk.zPosition * 16;
			double d = 0.5;
			int noiseValue = (int)((decorator.treeDensityNoise.get((double)x * d, (double)z * d) / 8.0 + parameters.random.nextDouble() * 4.0 + 4.0) / 3.0);
			int treeDensityOffset = 0;
			if (parameters.random.nextInt(10) == 0) {
				++treeDensityOffset;
			}

			return treeDensity == null ? treeDensityOffset : treeDensity + noiseValue + treeDensityOffset;
		}
	}

	public static Void generateEIH(Parameters parameters) {
		int x = parameters.chunk.xPosition * 16;
		int z = parameters.chunk.zPosition * 16;
		int xPos = x + parameters.random.nextInt(16) + 8;
		int yPos = parameters.decorator.minY + parameters.random.nextInt(parameters.decorator.rangeY);
		int zPos = z + parameters.random.nextInt(16) + 8;

		new WorldFeatureEIH().generate(parameters.decorator.world, parameters.random, xPos, yPos, zPos);
		return null;
	}

	public static Void generateTrees(Parameters parameters) {
		int x = parameters.chunk.xPosition * 16;
		int z = parameters.chunk.zPosition * 16;

		for(int i = 0; i < getTreeDensity(parameters); ++i) {
			int xf = x + parameters.random.nextInt(16) + 8;
			int zf = z + parameters.random.nextInt(16) + 8;
			int yf = parameters.decorator.world.getHeightValue(xf, zf);
			getTreeFeature(parameters).generate(parameters.decorator.world, parameters.random, xf, yf, zf);
		}

		return null;
	}
}
