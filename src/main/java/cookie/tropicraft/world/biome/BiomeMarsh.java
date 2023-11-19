package cookie.tropicraft.world.biome;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weather;

public class BiomeMarsh extends Biome {

	public BiomeMarsh() {
		setBlockedWeathers(Weather.overworldSnow);
		setColor(65355);
		setTopBlock(Block.grass.id);
		setFillerBlock(Block.dirt.id);

		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
	}
}
