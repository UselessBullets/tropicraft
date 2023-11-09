package cookie.tropicraft.item;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.block.BlockBamboo;
import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import net.minecraft.core.item.ItemFoodStackable;
import net.minecraft.core.item.ItemPlaceable;
import turniplabs.halplibe.helper.ItemHelper;

public class TropicraftItems {
	private final String MOD_ID = Tropicraft.MOD_ID;

	private int itemID = 17300;
	private int nextItemID() {
		return itemID++;
	}

	public static Item itemBamboo;
	public static Item mugEmpty;
	public static Item mugFullColada;
	public static Item mugFullDrink;
	public static Item pineapple;
	public static Item seedsPineapple;
	public static Item foodOrange;
	public static Item foodLemon;
	public static Item foodLime;
	public static Item foodGrapefruit;
	public static Item foodCoconutChunk;
	public static Item foodPineappleChunk;
	public static Item foodFrogRaw;
	public static Item foodFrogCooked;
	public static Item leatherFrog;
	public static Item scale;
	public static Item armorHelmetScale;
	public static Item armorChestplateScale;
	public static Item armorLeggingsScale;
	public static Item armorBootsScale;
	public static Item shellCommon;
	public static Item shellRare;
	public static Item shellSeaStar;
	public static Item torchTiki;

	public void initializeItems() {
		itemBamboo = ItemHelper.createItem(MOD_ID,
			new ItemPlaceable("bamboo", nextItemID(), TropicraftBlocks.blockBamboo),
			"bamboo",
			"bamboo.png");
		foodOrange = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.fruit.orange", nextItemID(), 2, false, 4),
				"food.fruit.orange",
				"fruit_orange.png");
		foodLemon = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.fruit.lemon", nextItemID(), 2, false, 4),
				"food.fruit.lemon",
				"fruit_lemon.png");
		foodLime = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.fruit.lime", nextItemID(), 2, false, 4),
				"food.fruit.lime",
				"fruit_lime.png");
		foodGrapefruit = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.fruit.grapefruit", nextItemID(), 2, false, 4),
				"food.fruit.grapefruit",
				"fruit_grapefruit.png");
		foodCoconutChunk = ItemHelper.createItem(MOD_ID,
			new ItemFood("food.coconut", nextItemID(), 1, false),
			"food.coconut",
			"coconut_chunk.png");
	}
}
