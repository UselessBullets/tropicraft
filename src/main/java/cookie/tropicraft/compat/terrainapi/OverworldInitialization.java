package cookie.tropicraft.compat.terrainapi;

import cookie.tropicraft.TropicraftConfig;
import cookie.tropicraft.world.feature.WorldFeatureBamboo;
import cookie.tropicraft.world.feature.WorldFeaturePineapple;
import cookie.tropicraft.world.feature.WorldFeatureTreePalm;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;
import useless.terrainapi.initialization.BaseInitialization;

public class OverworldInitialization extends BaseInitialization {

	@Override
	protected void initValues() {
		if (TropicraftConfig.cfg.getBoolean("Overworld Gen.bambooGen"))
			ChunkDecoratorOverworldAPI.biomeFeatures.addFeatureSurface(new WorldFeatureBamboo(),
				2,
				new Biome[]{Biomes.OVERWORLD_RAINFOREST});

		if (TropicraftConfig.cfg.getBoolean("Overworld Gen.pineappleGen"))
			ChunkDecoratorOverworldAPI.biomeFeatures.addFeatureSurface(new WorldFeaturePineapple(),
				1,
				new Biome[]{Biomes.OVERWORLD_RAINFOREST});

		if (TropicraftConfig.cfg.getBoolean("Overworld Gen.palmTreeGen"))
			ChunkDecoratorOverworldAPI.randomFeatures.addFeatureSurface(
				new WorldFeatureTreePalm(),
				10);
	}

	@Override
	protected void initStructure() {

	}

	@Override
	protected void initOre() {

	}

	@Override
	protected void initRandom() {

	}

	@Override
	protected void initBiome() {

	}
}
