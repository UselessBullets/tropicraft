package cookie.tropicraft.block;

import cookie.tropicraft.Tropicraft;
import net.minecraft.client.render.block.color.BlockColor;
import net.minecraft.client.render.block.color.BlockColorLeaves;
import net.minecraft.client.render.block.model.BlockModelRenderBlocks;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockLog;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import turniplabs.halplibe.helper.BlockBuilder;

public class TropicraftBlocks {
	private final String MOD_ID = Tropicraft.MOD_ID;
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
	public static Block headChunk;
	public static Block harris;
	public static Block torchTiki;
	public static Block bambooPlanks;
	public static Block thatch;
	public static Block bambooPlankSlab;
	public static Block thatchSlab;
	public static Block bambooPlankStairs;
	public static Block thatchStairs;

	public void initializeBlocks() {
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

		leavesPalmFast = new BlockBuilder(MOD_ID)
				.setTextures("leaves_palm.png")
				.build(new BlockLeavesPalm("leaves.palm", nextBlockID(), Material.leaves, false))
				.withTags(BlockTags.NOT_IN_CREATIVE_MENU);

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

		coconut = new BlockBuilder(MOD_ID)
				.setTextures("coconut.png")
				.setHardness(2.0f)
				.setResistance(1.0f)
				.setBlockSound(BlockSounds.WOOD)
				.setBlockModel(new BlockModelRenderBlocks(1))
				.build(new BlockCoconut("coconut", nextBlockID()))
				.withTags(BlockTags.MINEABLE_BY_AXE);
	}
}
