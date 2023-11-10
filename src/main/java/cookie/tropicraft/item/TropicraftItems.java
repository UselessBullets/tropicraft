package cookie.tropicraft.item;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ArmorMaterial;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemHelper;

public class TropicraftItems {

	private int itemID = 17300;
	private int nextItemID() {
		return itemID++;
	}

	public static Item itemBamboo;
	public static Item mugEmpty;
	public static Item mugFullColada;
	public static Item mugFullDrink;
	public static Item itemCoconut;
	public static Item foodPineapple;
	public static Item foodOrange;
	public static Item foodLemon;
	public static Item foodLime;
	public static Item foodGrapefruit;
	public static Item foodCoconutChunk;
	public static Item foodFrogRaw;
	public static Item foodFrogCooked;
	public static Item seedsPineapple;
	public static Item leatherFrog;
	public static Item scale;
	public static Item armorHelmetScale;
	public static Item armorChestplateScale;
	public static Item armorLeggingsScale;
	public static Item armorBootsScale;
	public static Item shell;
	public static Item torchTiki;
	public static Item itemFlowerIris;

	public static ArmorMaterial scaleMaterial;

	private void initializeArmor() {
		scaleMaterial = ArmorHelper.createArmorMaterial("scale", 240, 20.0f, 20.0f, 145.0f, 20.0f);
	}

	public void initializeItems() {
		String MOD_ID = Tropicraft.MOD_ID;

		initializeArmor();

		itemBamboo = ItemHelper.createItem(MOD_ID,
			new ItemPlaceable("bamboo", nextItemID(), TropicraftBlocks.blockBamboo),
			"bamboo",
			"bamboo.png");

		mugEmpty = ItemHelper.createItem(MOD_ID,
				new Item(nextItemID()),
				"mug.empty",
				"mug_empty.png");
		mugFullColada = ItemHelper.createItem(MOD_ID,
				new ItemDrinkColada(nextItemID()),
				"mug.full.colada",
				"mug_full.png");
		mugFullDrink = ItemHelper.createItem(MOD_ID,
				new ItemDrink(nextItemID()),
				"mug.full",
				"mug_full.png");

		itemCoconut = ItemHelper.createItem(MOD_ID,
			new ItemCoconut("coconut", nextItemID()),
			"coconut",
			"coconut.png");

		foodPineapple = ItemHelper.createItem(MOD_ID,
			new ItemFoodPineapple("food.fruit.pineapple", nextItemID()),
			"food.fruit.pineapple",
			"fruit_pineapple.png"
			);
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
			new ItemFoodStackable("food.coconut", nextItemID(), 1, false, 8),
			"food.coconut",
			"coconut_chunk.png");
		foodFrogRaw = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.frog.raw", nextItemID(), 1, true, 2),
				"food.frog.raw",
				"frog_leg.png");
		foodFrogCooked = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.frog.cooked", nextItemID(), 4, true, 2),
				"food.frog.cooked",
				"frog_leg_cooked.png");

		seedsPineapple = ItemHelper.createItem(MOD_ID,
				new ItemPlaceable("seeds.pineapple", nextItemID(), TropicraftBlocks.cropsPineapple),
				"seeds.pineapple",
				"seeds_pineapple.png");

		leatherFrog = ItemHelper.createItem(MOD_ID,
				new Item(nextItemID()),
				"leather.frog",
				"leather_frog.png");
		scale = ItemHelper.createItem(MOD_ID,
				new Item(nextItemID()),
				"scale",
				"scale.png");

		armorHelmetScale = ItemHelper.createItem(MOD_ID,
				new ItemArmor("armor.helmet.scale", nextItemID(), scaleMaterial, 0),
				"armor.helmet.scale",
				"armor_scale_helmet.png");
		armorChestplateScale = ItemHelper.createItem(MOD_ID,
				new ItemArmor("armor.chestplate.scale", nextItemID(), scaleMaterial, 1),
				"armor.chestplate.scale",
				"armor_scale_chestplate.png");
		armorLeggingsScale = ItemHelper.createItem(MOD_ID,
				new ItemArmor("armor.leggings.scale", nextItemID(), scaleMaterial, 2),
				"armor.leggings.scale",
				"armor_scale_leggings.png");
		armorBootsScale = ItemHelper.createItem(MOD_ID,
				new ItemArmor("armor.boots.scale", nextItemID(), scaleMaterial, 3),
				"armor.boots.scale",
				"armor_scale_boots.png");

		shell = ItemHelper.createItem(MOD_ID,
				new ItemShell(nextItemID()),
				"shell.common");

		torchTiki = ItemHelper.createItem(MOD_ID,
			new ItemPlaceable("torch.tiki", nextItemID(), TropicraftBlocks.torchTiki),
			"torch.tiki",
			"torch_tiki.png");

		itemFlowerIris = ItemHelper.createItem(MOD_ID,
			new ItemPlaceable("iris", nextItemID(), TropicraftBlocks.flowerIris),
			"iris",
			"flower_iris.png");
	}
}
