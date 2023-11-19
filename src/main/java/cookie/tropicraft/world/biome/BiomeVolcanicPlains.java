package cookie.tropicraft.world.biome;

import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weather;

public class BiomeVolcanicPlains extends Biome {

	public BiomeVolcanicPlains() {
		setBlockedWeathers(Weather.overworldRain, Weather.overworldStorm, Weather.overworldSnow);
		setColor(0);
		setTopBlock(Block.basalt.id);
		setFillerBlock(Block.basalt.id);

		spawnableAmbientCreatureList.clear();
		spawnableCreatureList.clear();
		spawnableMonsterList.clear();
	}
}
