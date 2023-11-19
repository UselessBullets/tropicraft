package cookie.tropicraft.world;

import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.world.World;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import net.minecraft.core.world.chunk.Chunk;
import net.minecraft.core.world.generate.chunk.perlin.SurfaceGenerator;
import net.minecraft.core.world.noise.BasePerlinNoise;
import net.minecraft.core.world.noise.PerlinNoise;

import java.util.Random;

public class SurfaceGeneratorTropics implements SurfaceGenerator {
	private final World world;
	private final BasePerlinNoise<?> beachNoise;
	private final BasePerlinNoise<?> soilNoise;
	private final BasePerlinNoise<?> mainNoise;
	private final boolean generateStoneVariants;

	protected SurfaceGeneratorTropics(
		World world, BasePerlinNoise<?> beachNoise, BasePerlinNoise<?> soilNoise, BasePerlinNoise<?> mainNoise, boolean generateStoneVariants
	) {
		this.world = world;
		this.beachNoise = beachNoise;
		this.soilNoise = soilNoise;
		this.mainNoise = mainNoise;
		this.generateStoneVariants = generateStoneVariants;
	}

	public SurfaceGeneratorTropics(World world) {
		this(
			world,
			new PerlinNoise(world.getRandomSeed(), 4, 40),
			new PerlinNoise(world.getRandomSeed(), 4, 44),
			new PerlinNoise(world.getRandomSeed(), 8, 32),
			true
		);
	}

	@Override
	public void generateSurface(Chunk chunk, short[] blocks) {
		int oceanY = this.world.getWorldType().getOceanY();
		int minY = this.world.getWorldType().getMinY();
		int maxY = this.world.getWorldType().getMaxY();
		int terrainHeight = maxY + 1 - minY;
		int chunkX = chunk.xPosition;
		int chunkZ = chunk.zPosition;
		int oceanBlock = this.world.getWorldType().getOceanBlock();
		int worldFillBlock = this.world.getWorldType().getFillerBlock();
		Random rand = new Random((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
		double beachScale = 0.03125;
		double[] sandBeachNoise = this.beachNoise.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale, beachScale, 1.0);
		double[] gravelBeachNoise = this.beachNoise.get(null, chunkX * 16, 109.0134, chunkZ * 16, 16, 1, 16, beachScale, 1.0, beachScale);
		double[] soilThicknessNoise = this.soilNoise.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale * 2.0, beachScale * 2.0, beachScale * 2.0);
		double[] stoneLayerNoise = null;
		double[] stoneLayerNoiseGranite = null;
		double[] stoneLayerNoiseLimestone = null;

		if (this.generateStoneVariants) {
			stoneLayerNoise = this.soilNoise
				.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale * 4.0, beachScale * 4.0, beachScale * 4.0);
			stoneLayerNoiseGranite = this.mainNoise
				.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale * 4.0, beachScale * 4.0, beachScale * 4.0);
			stoneLayerNoiseLimestone = this.beachNoise
				.get(null, chunkX * 16, chunkZ * 16, 0.0, 16, 16, 1, beachScale * 4.0, beachScale * 4.0, beachScale * 4.0);
		}

		for(int z = 0; z < 16; ++z) {
			for(int x = 0; x < 16; ++x) {
				boolean generateSandBeach = sandBeachNoise[z + x * 16] + rand.nextDouble() * 0.2 > 0.0;
				boolean generateGravelBeach = gravelBeachNoise[z + x * 16] + rand.nextDouble() * 0.2 > 3.0;
				int soilThickness = (int)(soilThicknessNoise[z + x * 16] / 3.0 + 3.0 + rand.nextDouble() * 0.25);
				boolean generateBasaltLayer = false;
				boolean generateGraniteLayer = false;
				boolean generateLimestoneLayer = false;
				int basaltThicknessLevel = 0;
				int graniteThicknessLevel = 0;
				int limestoneThicknessLevel = 0;

				if (this.generateStoneVariants) {
					generateBasaltLayer = stoneLayerNoise[z + x * 16] + rand.nextDouble() * 0.2 > 0.0;
					generateGraniteLayer = stoneLayerNoiseGranite[z + x * 16] + rand.nextDouble() * 0.2 > 2.0;
					generateLimestoneLayer = stoneLayerNoiseLimestone[z + x * 16] + rand.nextDouble() * 0.2 > 3.0;
					basaltThicknessLevel = (int)(stoneLayerNoise[z + x] + rand.nextDouble() * 0.5);
					graniteThicknessLevel = (int)(stoneLayerNoiseGranite[z + x] + rand.nextDouble() * 0.5);
					limestoneThicknessLevel = (int)(stoneLayerNoiseLimestone[z + x] + rand.nextDouble() * 0.5);
				}

				int currentLayerDepth = -1;
				short topBlock = -1;
				short fillerBlock = -1;
				Biome lastBiome = null;

				for(int y = maxY; y >= minY; --y) {
					byte biomeId = chunk.biome[(y >> 3) * 16 * 16 + x * 16 + z];
					Biome biome = Registries.BIOMES.getItemByNumericId(biomeId);
					if (biome == null) {
						biome = this.world.getBiomeProvider().getBiome(chunkX * 16 + x, y >> 3, chunkZ * 16 + z);
					}

					int blockIndex = (x * 16 + z) * this.world.getHeightBlocks() + y;
					short block = blocks[blockIndex];
					if ((biome != lastBiome || topBlock == -1 || fillerBlock == -1) && block == 0) {
						topBlock = biome.topBlock;
						fillerBlock = biome.fillerBlock;
					}

					lastBiome = biome;
					if (block == 0) {
						currentLayerDepth = -1;
					} else if (block == worldFillBlock) {
						if (currentLayerDepth == -1) {
							if (soilThickness <= 0) {
								topBlock = 0;
								fillerBlock = (short)worldFillBlock;
							} else if (y >= minY + oceanY - 4 && y <= minY + oceanY + 1) {
								topBlock = biome.topBlock;
								fillerBlock = biome.fillerBlock;
								if (biome == Biomes.OVERWORLD_SWAMPLAND || biome == Biomes.OVERWORLD_SWAMPLAND_MUDDY) {
									topBlock = (short) Block.mud.id;
									fillerBlock = (short)Block.mud.id;
								} else if (generateGravelBeach) {
									topBlock = 0;
									fillerBlock = (short)Block.gravel.id;
								} else if (generateSandBeach) {
									topBlock = (short) TropicraftBlocks.sandPurified.id;
									fillerBlock = (short)TropicraftBlocks.sandPurified.id;
								}
							}

							if (y < minY + oceanY && topBlock == 0) {
								topBlock = (short)oceanBlock;
							}

							currentLayerDepth = soilThickness;
							if (y >= minY + oceanY - 1) {
								blocks[blockIndex] = topBlock;
							} else {
								blocks[blockIndex] = fillerBlock;
							}
						} else if (this.generateStoneVariants && currentLayerDepth <= 0) {
							if (y >= minY + basaltThicknessLevel - rand.nextInt(3)
								&& y <= minY + 30 + basaltThicknessLevel - rand.nextInt(3)
								&& generateBasaltLayer) {
								blocks[blockIndex] = (short)Block.basalt.id;
							} else if (y >= minY + terrainHeight / 2 + graniteThicknessLevel - rand.nextInt(3)
								&& y <= minY + terrainHeight + graniteThicknessLevel - rand.nextInt(3)
								&& generateGraniteLayer) {
								blocks[blockIndex] = (short)Block.granite.id;
							} else if (y >= minY + terrainHeight / 2 + limestoneThicknessLevel - rand.nextInt(3)
								&& y <= minY + terrainHeight + limestoneThicknessLevel - rand.nextInt(3)
								&& generateLimestoneLayer) {
								blocks[blockIndex] = (short)Block.limestone.id;
							}
						} else {
							if (currentLayerDepth > 0) {
								--currentLayerDepth;
								blocks[blockIndex] = fillerBlock;
							}

							if (currentLayerDepth == 0) {
								if (biome == Biomes.OVERWORLD_DESERT && fillerBlock == Block.sand.id) {
									currentLayerDepth = rand.nextInt(8) + 2;
									fillerBlock = (short)Block.sandstone.id;
								} else if (biome == Biomes.OVERWORLD_GLACIER && fillerBlock == Block.blockSnow.id) {
									currentLayerDepth = rand.nextInt(8) + 14;
									fillerBlock = (short)Block.permafrost.id;
								}
							}
						}
					}
				}
			}
		}
	}
}
