package cookie.tropicraft.world.biome;

import net.minecraft.core.block.Block;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.entity.animal.EntityChicken;
import net.minecraft.core.entity.animal.EntityPig;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.weather.Weather;

public class BiomeSavanna extends Biome {

	public BiomeSavanna() {
		setBlockedWeathers(Weather.overworldSnow);
		setColor(16776960);
		setTopBlock(Block.grass.id);
		setFillerBlock(Block.dirt.id);

		spawnableCreatureList.clear();
		spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 21));
		spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 16));
	}
}
