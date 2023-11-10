package cookie.tropicraft;

import cookie.tropicraft.block.TropicraftBlocks;
import cookie.tropicraft.entity.EntityCoconut;
import cookie.tropicraft.item.TropicraftItems;
import cookie.tropicraft.util.ContainerPlayerExtender;
import cookie.tropicraft.world.TropicraftWorldgen;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.render.entity.SnowballRenderer;
import net.minecraft.core.world.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.EntityHelper;
import turniplabs.halplibe.helper.SoundHelper;
import turniplabs.halplibe.helper.TextureHelper;

public class Tropicraft implements ModInitializer {
    public static final String MOD_ID = "tropicraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // These are used by RenderBlocksMixin
    public static final int[] overlay = TextureHelper.getOrCreateBlockTexture(MOD_ID, "leaves_citrus_overlay.png");
	public static final int[][] torchTextures = new int[][]{
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "tikitorch_bottom.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "tikitorch_top.png")
	};

    public static Dimension tropicsDimension = new Dimension("tropicraft.dimension.tropics", Dimension.overworld, 1.0f, -1);

    @Override
    public void onInitialize() {

        // DO NOT TOUCH THIS! It's an error prevention method. Thanks Useless!
        try {
            Class.forName("net.minecraft.core.block.Block");
            Class.forName("net.minecraft.core.item.Item");
        } catch (ClassNotFoundException ignored) {}

		SoundHelper.addSound(MOD_ID, "bonk.wav");
        SoundHelper.addSound(MOD_ID, "gulp.wav");

        new TropicraftBlocks().initializeBlocks();
        new TropicraftItems().initializeItems();

		EntityHelper.createEntity(EntityCoconut.class, new SnowballRenderer(TropicraftItems.itemCoconut.getIconFromDamage(0)), 125, "coconut");

        new TropicraftWorldgen().initializeWorldGen();
        new ContainerPlayerExtender().initializeExtender();

        LOGGER.info("Tropicraft initialized. Have a happy vacation!");
    }
}
