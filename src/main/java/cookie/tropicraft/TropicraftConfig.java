package cookie.tropicraft;

import cookie.tropicraft.block.TropicraftBlocks;
import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TropicraftConfig {
	public static TomlConfigHandler cfg;

	public TropicraftConfig() {
		Toml properties = new Toml("Tropicraft's TOML Config");
		ConfigUpdater updater = ConfigUpdater.fromProperties();

		properties.addCategory("Tropicraft")
				.addEntry("tropicsDimID", "Default value is 3", 3);

		properties.addCategory("Overworld Gen")
			.addEntry("bambooGen", true)
			.addEntry("pineappleGen", true)
			.addEntry("palmTreeGen", true);

		int blockIDs = 1300;
		int itemIDs = 17300;

		properties.addCategory("Block IDs");
		properties.addCategory("Item IDs");

		List<Field> blockFields = Arrays.stream(TropicraftBlocks.class.getDeclaredFields()).filter((F)-> Block.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field blockField : blockFields) {
			properties.addEntry("Block IDs." + blockField.getName(), blockIDs++);
		}

		List<Field> itemFields = Arrays.stream(TropicraftItems.class.getDeclaredFields()).filter((F)-> Item.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field itemField : itemFields) {
			properties.addEntry("Item IDs." + itemField.getName(), itemIDs++);
		}

		cfg = new TomlConfigHandler(updater, Tropicraft.MOD_ID, properties);
	}
}
