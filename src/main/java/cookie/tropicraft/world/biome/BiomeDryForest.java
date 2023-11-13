package cookie.tropicraft.world.biome;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weather;

public class BiomeDryForest extends Biome {

	public BiomeDryForest() {
		setBlockedWeathers(Weather.overworldRain, Weather.overworldStorm);
		setColor(11844186);
		setTopBlock(Block.grass.id);
		setFillerBlock(Block.dirt.id);
	}
}
