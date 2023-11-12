package cookie.tropicraft.world.biome;

import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;

public class TropicraftBiomes extends Biomes {
	public static Biome TROPICS_DRYFOREST = new BiomeDryForest();

	public void initializeBiomes() {
		Biomes.register("tropicraft.biome.dryforest", TROPICS_DRYFOREST);
	}
}
