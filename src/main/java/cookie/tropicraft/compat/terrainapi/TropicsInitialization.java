package cookie.tropicraft.compat.terrainapi;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.block.TropicraftBlocks;
import cookie.tropicraft.world.biome.TropicraftBiomes;
import cookie.tropicraft.world.feature.WorldFeatureAgave;
import cookie.tropicraft.world.feature.WorldFeatureTropicalCactus;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancy;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeFancyRainforest;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeShrub;
import net.minecraft.core.world.generate.feature.tree.WorldFeatureTreeTall;
import useless.terrainapi.generation.StructureFeatures;
import useless.terrainapi.generation.overworld.OverworldBiomeFeatures;
import useless.terrainapi.generation.overworld.OverworldFunctions;
import useless.terrainapi.generation.overworld.OverworldOreFeatures;
import useless.terrainapi.generation.overworld.OverworldRandomFeatures;
import useless.terrainapi.initialization.BaseInitialization;

public class TropicsInitialization extends BaseInitialization {
	private static final TerrainTropicsConfig tropicsConfig = ChunkDecoratorTropicsAPI.tropicsConfig;

	@Override
	protected void initValues() {
		tropicsConfig.addGrassDensity(TropicraftBiomes.TROPICS_DRYFOREST, 10);
		tropicsConfig.addTreeDensity(TropicraftBiomes.TROPICS_DRYFOREST, 16);
	}

	@Override
	protected void initStructure() {
		StructureFeatures structureFeatures = ChunkDecoratorTropicsAPI.structureFeatures;
		structureFeatures.addFeature(OverworldFunctions::generateLakeFeature, null);
		structureFeatures.addFeature(OverworldFunctions::generateLavaLakeFeature, null);
		structureFeatures.addFeature(OverworldFunctions::generateRandomFluid, new Object[]{50, Block.fluidWaterFlowing.id});
		structureFeatures.addFeature(OverworldFunctions::generateRandomFluid, new Object[]{20, Block.fluidLavaFlowing.id});
		structureFeatures.addFeature(TropicsFunctions::generateEIH, null);
	}

	@Override
	protected void initOre() {
		String MOD_ID = Tropicraft.MOD_ID;
		OverworldOreFeatures oreFeatures = ChunkDecoratorTropicsAPI.oreFeatures;
		ChunkDecoratorTropicsAPI.oreFeatures.addManagedOreFeature(MOD_ID,Block.dirt, 32, 20, 1f, false);
		oreFeatures.addManagedOreFeature(MOD_ID,Block.gravel, 32, 10, 1f, false);
		oreFeatures.addManagedOreFeature(MOD_ID,Block.oreCoalStone, 20, 24, 1f, true);
		oreFeatures.addManagedOreFeature(MOD_ID,Block.oreIronStone, 6, 16, 1/2f, true);
		oreFeatures.addManagedOreFeature(MOD_ID,Block.oreGoldStone, 8, 4, 1/4f, true);
		oreFeatures.addManagedOreFeature(MOD_ID,Block.oreRedstoneStone, 7, 10, 1/8f, true);
		oreFeatures.addManagedOreFeature(MOD_ID,Block.oreDiamondStone, 7, 2, 1/8f, true);
		oreFeatures.addManagedOreFeature(MOD_ID,Block.mossStone, 32, 1, 1/2f, true);
		oreFeatures.addManagedOreFeature(MOD_ID,Block.oreLapisStone, 6, 1, 1/8f, true);
	}

	@Override
	protected void initRandom() {
		OverworldRandomFeatures randomFeatures = ChunkDecoratorTropicsAPI.randomFeatures;
		randomFeatures.addFeatureSurface(
			new WorldFeatureAgave(),
			1);
	}

	@Override
	protected void initBiome() {
		OverworldBiomeFeatures biomeFeatures = ChunkDecoratorTropicsAPI.biomeFeatures;
		biomeFeatures.addFeature(OverworldFunctions::grassTypeCondition, null, x -> TerrainTropicsConfig.getGrassDensity(x.biome, 0), null, 1.0F);

		biomeFeatures.addFeatureSurface(
			new WorldFeatureTreeTall(
				TropicraftBlocks.leavesFlowering.id, Block.logOak.id),
			7,
			new	Biome[]{TropicraftBiomes.TROPICS_DRYFOREST});

		biomeFeatures.addFeatureSurface(
			new WorldFeatureTreeFancyRainforest(
				TropicraftBlocks.leavesFlowering.id, Block.logOak.id, 16),
			8,
			new	Biome[]{TropicraftBiomes.TROPICS_DRYFOREST});

		biomeFeatures.addFeatureSurface(
			new WorldFeatureTropicalCactus(),
			1,
			new	Biome[]{TropicraftBiomes.TROPICS_DRYFOREST});
	}
}
