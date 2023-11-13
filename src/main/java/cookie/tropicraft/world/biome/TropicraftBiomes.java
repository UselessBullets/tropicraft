package cookie.tropicraft.world.biome;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.BiomeRainforest;
import net.minecraft.core.world.biome.Biomes;

public class TropicraftBiomes extends Biomes {
	public static Biome TROPICS_DRYFOREST = new BiomeDryForest();
	public static Biome TROPICS_SAVANNA = new BiomeSavanna();
	public static Biome TROPICS_MARSH = new BiomeMarsh();
	public static Biome TROPICS_RAINFOREST = new BiomeRainforest();

	public void initializeBiomes() {
		Biomes.register("tropicraft.biome.dryforest", TROPICS_DRYFOREST);
		Biomes.register("tropicraft.biome.savanna", TROPICS_SAVANNA);
		Biomes.register("tropicraft.biome.marsh", TROPICS_MARSH);
		Biomes.register("tropicraft.biome.rainforest", TROPICS_RAINFOREST);
	}
}
