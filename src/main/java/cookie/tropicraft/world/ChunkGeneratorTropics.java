package cookie.tropicraft.world;

import cookie.tropicraft.compat.terrainapi.ChunkDecoratorTropicsAPI;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.MapGenCaves;
import net.minecraft.core.world.generate.chunk.perlin.ChunkGeneratorPerlin;
import net.minecraft.core.world.generate.chunk.perlin.overworld.SurfaceGeneratorOverworld;
import net.minecraft.core.world.generate.chunk.perlin.overworld.TerrainGeneratorOverworld;

public class ChunkGeneratorTropics extends ChunkGeneratorPerlin {

	protected ChunkGeneratorTropics(World world) {
		super(world, new ChunkDecoratorTropicsAPI(world), new TerrainGeneratorOverworld(world), new SurfaceGeneratorOverworld(world), new MapGenCaves(false));
	}
}
