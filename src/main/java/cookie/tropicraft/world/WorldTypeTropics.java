package cookie.tropicraft.world;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.world.biome.TropicraftBiomes;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.provider.BiomeProvider;
import net.minecraft.core.world.biome.provider.BiomeProviderSingleBiome;
import net.minecraft.core.world.config.season.SeasonConfig;
import net.minecraft.core.world.generate.chunk.ChunkGenerator;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.type.WorldTypeOverworld;
import net.minecraft.core.world.weather.Weather;
import net.minecraft.core.world.wind.WindManagerGeneric;

public class WorldTypeTropics extends WorldTypeOverworld {

	public WorldTypeTropics(String languageKey) {
		super(languageKey,
			Weather.overworldClear,
			new WindManagerGeneric(),
			SeasonConfig.builder()
				.withSeasonInCycle(Seasons.OVERWORLD_SUMMER, 14)
				.withSeasonInCycle(Seasons.OVERWORLD_WINTER, 14)
				.build());
	}

	@Override
	public int getMinY() {
		return 0;
	}

	@Override
	public int getMaxY() {
		return 127;
	}

	@Override
	public int getOceanY() {
		return 64;
	}

	@Override
	public BiomeProvider createBiomeProvider(World world) {
		return new BiomeProviderSingleBiome(TropicraftBiomes.TROPICS_DRYFOREST, 0.5f, 0.0f, 0.0f);
	}

	@Override
	public ChunkGenerator createChunkGenerator(World world) {
		return new ChunkGeneratorTropics(world);
	}

	@Override
	public float getCloudHeight() {
		return 108.0f;
	}

	@Override
	public boolean hasAurora() {
		return false;
	}
}