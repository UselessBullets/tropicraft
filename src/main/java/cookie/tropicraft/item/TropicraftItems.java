package cookie.tropicraft.item;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.TropicraftConfig;
import cookie.tropicraft.block.TropicraftBlocks;
import net.minecraft.core.item.*;
import net.minecraft.core.item.material.ArmorMaterial;
import turniplabs.halplibe.helper.ArmorHelper;
import turniplabs.halplibe.helper.ItemHelper;

public class TropicraftItems {

	private int nextItemID(String itemName) {
		return TropicraftConfig.cfg.getInt("Item IDs." + itemName);
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
	public static Item foodCranberries;
	public static Item foodFrogRaw;
	public static Item foodFrogCooked;
	public static Item seedsPineapple;
	public static Item seedsAgave;
	public static Item leatherFrog;
	public static Item scale;
	public static Item armorHelmetScale;
	public static Item armorChestplateScale;
	public static Item armorLeggingsScale;
	public static Item armorBootsScale;
	public static Item shell;
	public static Item torchTiki;
	public static Item itemFlowerIris;
	public static Item flowerAgave;

	public static ArmorMaterial scaleMaterial;

	private void initializeArmor() {
		scaleMaterial = ArmorHelper.createArmorMaterial("scale", 240, 20.0f, 20.0f, 145.0f, 20.0f);
	}

	public void initializeItems() {
		String MOD_ID = Tropicraft.MOD_ID;

		initializeArmor();

		itemBamboo = ItemHelper.createItem(MOD_ID,
			new ItemPlaceable("bamboo", nextItemID("itemBamboo"), TropicraftBlocks.blockBamboo),
			"bamboo",
			"bamboo.png");

		mugEmpty = ItemHelper.createItem(MOD_ID,
				new Item(nextItemID("mugEmpty")),
				"mug.empty",
				"mug_empty.png");
		mugFullColada = ItemHelper.createItem(MOD_ID,
				new ItemDrinkColada(nextItemID("mugFullColada")),
				"mug.full.colada",
				"mug_full.png");
		mugFullDrink = ItemHelper.createItem(MOD_ID,
				new ItemDrink(nextItemID("mugFullDrink")),
				"mug.full",
				"mug_full.png");

		itemCoconut = ItemHelper.createItem(MOD_ID,
			new ItemCoconut("coconut", nextItemID("itemCoconut")),
			"coconut",
			"coconut.png");

		foodPineapple = ItemHelper.createItem(MOD_ID,
			new ItemFoodPineapple("food.fruit.pineapple", nextItemID("foodPineapple")),
			"food.fruit.pineapple",
			"fruit_pineapple.png"
			);
		foodOrange = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.fruit.orange", nextItemID("foodOrange"), 2, false, 4),
				"food.fruit.orange",
				"fruit_orange.png");
		foodLemon = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.fruit.lemon", nextItemID("foodLemon"), 2, false, 4),
				"food.fruit.lemon",
				"fruit_lemon.png");
		foodLime = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.fruit.lime", nextItemID("foodLime"), 2, false, 4),
				"food.fruit.lime",
				"fruit_lime.png");
		foodGrapefruit = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.fruit.grapefruit", nextItemID("foodGrapefruit"), 2, false, 4),
				"food.fruit.grapefruit",
				"fruit_grapefruit.png");
		foodCoconutChunk = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.coconut", nextItemID("foodCoconutChunk"), 1, false, 8),
				"food.coconut",
				"coconut_chunk.png");
		foodCranberries = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.cranberries", nextItemID("foodCranberries"), 1, false, 2),
				"food.cranberries",
				"cranberries.png");
		foodFrogRaw = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.frog.raw", nextItemID("foodFrogRaw"), 1, true, 2),
				"food.frog.raw",
				"frog_leg.png");
		foodFrogCooked = ItemHelper.createItem(MOD_ID,
				new ItemFoodStackable("food.frog.cooked", nextItemID("foodFrogCooked"), 4, true, 2),
				"food.frog.cooked",
				"frog_leg_cooked.png");

		seedsPineapple = ItemHelper.createItem(MOD_ID,
				new ItemPlaceable("seeds.pineapple", nextItemID("seedsPineapple"), TropicraftBlocks.cropsPineapple),
				"seeds.pineapple",
				"seeds_pineapple.png");
		seedsAgave = ItemHelper.createItem(MOD_ID,
				new ItemPlaceable("seeds.agave", nextItemID("seedsAgave"), TropicraftBlocks.agave),
				"seeds.agave",
				"seeds_agave.png");

		leatherFrog = ItemHelper.createItem(MOD_ID,
				new Item(nextItemID("leatherFrog")),
				"leather.frog",
				"leather_frog.png");
		scale = ItemHelper.createItem(MOD_ID,
				new Item(nextItemID("scale")),
				"scale",
				"scale.png");

		armorHelmetScale = ItemHelper.createItem(MOD_ID,
				new ItemArmor("armor.helmet.scale", nextItemID("armorHelmetScale"), scaleMaterial, 0),
				"armor.helmet.scale",
				"armor_scale_helmet.png");
		armorChestplateScale = ItemHelper.createItem(MOD_ID,
				new ItemArmor("armor.chestplate.scale", nextItemID("armorChestplateScale"), scaleMaterial, 1),
				"armor.chestplate.scale",
				"armor_scale_chestplate.png");
		armorLeggingsScale = ItemHelper.createItem(MOD_ID,
				new ItemArmor("armor.leggings.scale", nextItemID("armorLeggingsScale"), scaleMaterial, 2),
				"armor.leggings.scale",
				"armor_scale_leggings.png");
		armorBootsScale = ItemHelper.createItem(MOD_ID,
				new ItemArmor("armor.boots.scale", nextItemID("armorBootsScale"), scaleMaterial, 3),
				"armor.boots.scale",
				"armor_scale_boots.png");

		shell = ItemHelper.createItem(MOD_ID,
				new ItemShell(nextItemID("shell")),
				"shell.common");

		torchTiki = ItemHelper.createItem(MOD_ID,
			new ItemPlaceable("torch.tiki", nextItemID("torchTiki"), TropicraftBlocks.torchTiki),
			"torch.tiki",
			"torch_tiki.png");

		itemFlowerIris = ItemHelper.createItem(MOD_ID,
			new ItemPlaceable("iris", nextItemID("itemFlowerIris"), TropicraftBlocks.flowerIris),
			"iris",
			"flower_iris.png");

		flowerAgave = ItemHelper.createItem(MOD_ID,
			new Item("flower.agave", nextItemID("flowerAgave")),
			"flower.agave",
			"flower_agave.png");
	}
}
