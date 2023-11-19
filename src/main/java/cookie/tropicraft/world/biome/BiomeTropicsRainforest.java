package cookie.tropicraft.world.biome;

import cookie.tropicraft.entity.EntityFrog;
import cookie.tropicraft.entity.EntityFrogPoison;
import net.minecraft.core.entity.SpawnListEntry;
import net.minecraft.core.entity.animal.EntityChicken;
import net.minecraft.core.world.biome.Biome;

public class BiomeTropicsRainforest extends Biome {

	public BiomeTropicsRainforest() {
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();

		spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 21));
		spawnableCreatureList.add(new SpawnListEntry(EntityFrog.class, 12));
		spawnableMonsterList.add(new SpawnListEntry(EntityFrogPoison.class, 3));
	}
}
