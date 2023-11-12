package cookie.tropicraft.world;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.data.BiomeRangeMap;
import net.minecraft.core.world.biome.provider.BiomeProvider;

public class BiomeProviderTropics extends BiomeProvider {
	private static final BiomeRangeMap brm = new BiomeRangeMap();

	@Override
	public Biome[] getBiomes(Biome[] biomes, double[] ds, double[] es, double[] fs, int i, int j, int k, int l, int m, int n) {
		return new Biome[0];
	}

	@Override
	public double[] getTemperatures(double[] ds, int i, int j, int k, int l) {
		return new double[0];
	}

	@Override
	public double[] getHumidities(double[] ds, int i, int j, int k, int l) {
		return new double[0];
	}

	@Override
	public double[] getVarieties(double[] ds, int i, int j, int k, int l) {
		return new double[0];
	}

	@Override
	public double[] getBiomenesses(double[] ds, int i, int j, int k, int l, int m, int n) {
		return new double[0];
	}

	@Override
	public Biome lookupBiome(double d, double e, double f, double g) {
		return null;
	}
}
