package cookie.tropicraft;

import cookie.tropicraft.block.TropicraftBlocks;
import cookie.tropicraft.entity.EntityCoconut;
import cookie.tropicraft.entity.TropicraftEntities;
import cookie.tropicraft.item.TropicraftItems;
import cookie.tropicraft.util.ContainerPlayerExtender;
import cookie.tropicraft.world.BiomeProviderTropics;
import cookie.tropicraft.world.WorldTypeTropics;
import cookie.tropicraft.world.biome.TropicraftBiomes;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import net.minecraft.client.render.entity.SnowballRenderer;
import net.minecraft.core.world.Dimension;
import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.helper.TextureHelper;

public class Tropicraft implements ModInitializer, PreLaunchEntrypoint {
	static {
		// DO NOT TOUCH THIS! It's an error prevention method. Thanks Useless!
		try {
			Class.forName("turniplabs.halplibe.HalpLibe");
			Class.forName("net.minecraft.core.block.Block");
			Class.forName("net.minecraft.core.item.Item");
			Class.forName("net.minecraft.core.world.Dimension");
		} catch (ClassNotFoundException ignored) {}
	}
    public static final String MOD_ID = "tropicraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // These are used by RenderBlocksMixin
    public static final int[] citrusOverlay = TextureHelper.getOrCreateBlockTexture(MOD_ID, "leaves_citrus_overlay.png");
	public static final int[] floweringOverlay = TextureHelper.getOrCreateBlockTexture(MOD_ID, "leaves_flowering_overlay.png");
	public static final int[][] torchTextures = new int[][]{
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "tikitorch_bottom.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "tikitorch_top.png")
	};

    public static Dimension tropicsDimension;
	public static WorldType tropicsWorld;

    @Override
    public void onInitialize() {
		SoundHelper.addSound(MOD_ID, "bonk.wav");
        SoundHelper.addSound(MOD_ID, "gulp.wav");
		SoundHelper.addSound(MOD_ID, "frog.wav");
		SoundHelper.addSound(MOD_ID, "boom.wav");

		EntityHelper.createEntity(EntityCoconut.class, new SnowballRenderer(TropicraftItems.itemCoconut.getIconFromDamage(0)), 125, "coconut");

        new ContainerPlayerExtender().initializeExtender();

        LOGGER.info("Tropicraft initialized. Have a happy vacation!");
    }

	@Override
	public void onPreLaunch() {
		new TropicraftConfig();
		BiomeProviderTropics.init();

		new TropicraftBlocks().initializeBlocks();
		new TropicraftItems().initializeItems();
		new TropicraftBiomes().initializeBiomes();

		tropicsWorld = WorldTypes.register("tropicraft.worldtype.tropics", new WorldTypeTropics("tropicraft.worldtype.tropics"));
		tropicsDimension = new Dimension("tropicraft.dimension.tropics", Dimension.overworld, 1.0f, TropicraftBlocks.tropicsPortal.id);
		tropicsDimension.setDefaultWorldType(tropicsWorld);
		Dimension.registerDimension(TropicraftConfig.cfg.getInt("Tropicraft.tropicsDimID"), tropicsDimension);
	}
}
