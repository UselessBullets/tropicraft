package cookie.tropicraft.block;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.TropicraftTags;
import net.minecraft.client.render.block.color.BlockColorLeaves;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.*;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import net.minecraft.core.world.Dimension;
import turniplabs.halplibe.helper.BlockBuilder;

public class TropicraftBlocks {
	private int blockID = 1300;
	private int nextBlockID() {
		return blockID++;
	}

	public static Block blockBamboo;
	public static Block logPalm;
	public static Block leavesCitrus;
	public static Block leavesPalm;
	public static Block leavesPalmFast;
	public static Block saplingCitrus;
	public static Block saplingPalm;
	public static Block flowerDayflower;
	public static Block flowerMontbretia;
	public static Block flowerOrchid;
	public static Block flowerIris;
	public static Block cropsPineapple;
	public static Block coconut;
	public static Block sandPurified;
	public static Block harris;
	public static Block torchTiki;
	public static Block bambooPlanks;
	public static Block thatch;
	public static Block bambooPlankSlab;
	public static Block thatchSlab;
	public static Block bambooPlankStairs;
	public static Block thatchStairs;
	public static Block tropicsPortal;

	private void addToTags() {
		Block.sand.withTags(TropicraftTags.GROWS_PALM_TREES);
	}

	private void pickaxeLevels() {
		ItemToolPickaxe.miningLevels.put(harris, 3);
	}

	public void initializeBlocks() {
		String MOD_ID = Tropicraft.MOD_ID;

		BlockBuilder flowerBuilder = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GRASS)
			.setBlockModel(new BlockModelRenderBlocks(1))
			.setTags(BlockTags.BROKEN_BY_FLUIDS);

		blockBamboo = new BlockBuilder(MOD_ID)
			.setTextures("bamboo.png")
			.setBlockModel(new BlockModelRenderBlocks(1))
			.setHardness(0.2f)
			.setBlockSound(BlockSounds.GRASS)
			.build(new BlockBamboo("bamboo", nextBlockID()))
			.setTickOnLoad(true)
			.withTags(BlockTags.MINEABLE_BY_SWORD, BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.BROKEN_BY_FLUIDS)
			.withDisabledStats();

		logPalm = new BlockBuilder(MOD_ID)
			.setTopBottomTexture("log_palm.png")
			.setSideTextures("log_palm_sides.png")
			.setHardness(2.0f)
			.setBlockSound(BlockSounds.WOOD)
			.build(new BlockLog("log.palm", nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_AXE);

		leavesPalm = new BlockBuilder(MOD_ID)
			.setTextures("leaves_palm.png")
			.setHardness(0.2f)
			.setBlockSound(BlockSounds.GRASS)
			.setBlockColor(new BlockColorLeaves("pine"))
			.setLightOpacity(1)
			.build(new BlockLeavesPalm("leaves.palm", nextBlockID(), Material.leaves, false))
			.setTickOnLoad(true)
			.withTags(BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH);

		leavesPalmFast = new BlockBuilder(MOD_ID)
			.setTextures("leaves_palm.png")
			.build(new BlockLeavesPalm("leaves.palm", nextBlockID(), Material.leaves, false))
			.withTags(BlockTags.NOT_IN_CREATIVE_MENU);

		leavesCitrus = new BlockBuilder(MOD_ID)
			.setTextures(2, 20)
			.setHardness(0.2f)
			.setBlockSound(BlockSounds.GRASS)
			.setBlockModel(new BlockModelRenderBlocks(33))
			.setBlockColor(new BlockColorLeaves("birch"))
			.setLightOpacity(1)
			.build(new BlockLeavesCitrus("leaves.citrus", nextBlockID(), false))
			.setTickOnLoad(true)
			.withTags(BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_AXE, BlockTags.MINEABLE_BY_HOE, BlockTags.MINEABLE_BY_SHEARS, BlockTags.SHEARS_DO_SILK_TOUCH);

		saplingPalm = new BlockBuilder(MOD_ID)
			.setTextures("sapling_palm.png")
			.setBlockSound(BlockSounds.GRASS)
			.setBlockModel(new BlockModelRenderBlocks(1))
			.build(new BlockSaplingPalm("sapling.palm", nextBlockID()))
			.setTickOnLoad(true);

		saplingCitrus = new BlockBuilder(MOD_ID)
			.setTextures("sapling_citrus.png")
			.setBlockSound(BlockSounds.GRASS)
			.setBlockModel(new BlockModelRenderBlocks(1))
			.build(new BlockSaplingCitrus("sapling.citrus", nextBlockID()))
			.setTickOnLoad(true);

		flowerDayflower = flowerBuilder
			.setTextures("flower_dayflower.png")
			.build(new BlockFlower("flower.dayflower", nextBlockID()));

		flowerMontbretia = flowerBuilder
			.setTextures("flower_montbretia.png")
			.build(new BlockFlower("flower.montbretia", nextBlockID()));

		flowerOrchid = flowerBuilder
			.setTextures("flower_orchid.png")
			.build(new BlockFlower("flower.orchid", nextBlockID()));

		flowerIris = flowerBuilder
			.setTextures("flower_iris_bottom.png")
			.build(new BlockFlowerIris("flower.iris", nextBlockID())
				.withTags(BlockTags.NOT_IN_CREATIVE_MENU));

		cropsPineapple = new BlockBuilder(MOD_ID)
			.setTextures("pineapple_bottom.png")
			.setBlockSound(BlockSounds.GRASS)
			.setBlockModel(new BlockModelRenderBlocks(1))
			.setHardness(0.2f)
			.build(new BlockCropsPineapple("crops.pineapple", nextBlockID()))
			.withTags(BlockTags.NOT_IN_CREATIVE_MENU, BlockTags.MINEABLE_BY_SWORD, BlockTags.BROKEN_BY_FLUIDS)
			.setTickOnLoad(true);

		coconut = new BlockBuilder(MOD_ID)
			.setTextures("coconut.png")
			.setHardness(2.0f)
			.setResistance(1.0f)
			.setBlockSound(BlockSounds.WOOD)
			.setBlockModel(new BlockModelRenderBlocks(1))
			.build(new BlockCoconut("coconut", nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.NOT_IN_CREATIVE_MENU);

		sandPurified = new BlockBuilder(MOD_ID)
			.setTextures("sand_purified.png")
			.setBlockSound(BlockSounds.SAND)
			.setHardness(0.5f)
			.build(new BlockSand("sand.purified", nextBlockID()))
			.withTags(BlockTags.GROWS_CACTI, TropicraftTags.GROWS_PALM_TREES, BlockTags.MINEABLE_BY_SHOVEL);

		harris = new BlockBuilder(MOD_ID)
			.setTopBottomTexture("harris_sides.png")
			.setNorthTexture("harris.png")
			.setEastTexture("harris_sides.png")
			.setWestTexture("harris_sides.png")
			.setSouthTexture("harris_sides.png")
			.setBlockSound(BlockSounds.METAL)
			.setHardness(10.0f)
			.setResistance(2000.0f)
			.build(new BlockHarris("harris", nextBlockID(), Material.metal))
			.withTags(BlockTags.MINEABLE_BY_PICKAXE);

		torchTiki = new BlockBuilder(MOD_ID)
			.setTextures("tikitorch_top.png")
			.setBlockSound(BlockSounds.WOOD)
			.setBlockModel(new BlockModelRenderBlocks(34))
			.setHardness(0.2f)
			.build(new BlockTorchTiki("torch.tiki", nextBlockID()))
			.setTickOnLoad(true)
			.withLightValue(0.9375F)
			.withTags(BlockTags.NOT_IN_CREATIVE_MENU);

		bambooPlanks = new BlockBuilder(MOD_ID)
			.setTextures("planks_bamboo.png")
			.setBlockSound(BlockSounds.WOOD)
			.setHardness(2.0f)
			.setResistance(5.0f)
			.build(new Block("planks.bamboo", nextBlockID(), Material.wood))
			.withTags(BlockTags.MINEABLE_BY_AXE, BlockTags.FENCES_CONNECT)
			.withDisabledNeighborNotifyOnMetadataChange();

		thatch = new BlockBuilder(MOD_ID)
			.setTextures("thatch.png")
			.setBlockSound(BlockSounds.GRASS)
			.setHardness(1.0f)
			.build(new Block("thatch", nextBlockID(), Material.grass))
			.withTags(BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_HOE)
			.withDisabledNeighborNotifyOnMetadataChange();

		bambooPlankSlab = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.WOOD)
			.setHardness(2.0f)
			.setResistance(5.0f)
			.build(new BlockSlab(bambooPlanks, nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_AXE)
			.withLitInteriorSurface(true);

		thatchSlab = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GRASS)
			.setHardness(1.0f)
			.build(new BlockSlab(thatch, nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_HOE)
			.withLitInteriorSurface(true);

		bambooPlankStairs = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.WOOD)
			.setHardness(2.0f)
			.setResistance(5.0f)
			.setBlockModel(new BlockModelRenderBlocks(10))
			.build(new BlockStairs(bambooPlanks, nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_AXE)
			.withLitInteriorSurface(true);

		thatchStairs = new BlockBuilder(MOD_ID)
			.setBlockSound(BlockSounds.GRASS)
			.setHardness(1.0f)
			.setBlockModel(new BlockModelRenderBlocks(10))
			.build(new BlockStairs(thatch, nextBlockID()))
			.withTags(BlockTags.MINEABLE_BY_SWORD, BlockTags.MINEABLE_BY_HOE)
			.withLitInteriorSurface(true);

		tropicsPortal = new BlockBuilder(MOD_ID)
				.setTextures(14, 0)
				.setBlockSound(BlockSounds.GLASS)
				.setHardness(-1)
				.build(new BlockPortal("portal.tropics", nextBlockID(), Tropicraft.tropicsDimension.id, Block.brickSandstone.id, Block.fluidWaterStill.id));

		addToTags();
		pickaxeLevels();
	}
}
