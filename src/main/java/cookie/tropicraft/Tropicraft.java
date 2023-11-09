package cookie.tropicraft;

import cookie.tropicraft.block.TropicraftBlocks;
import cookie.tropicraft.item.TropicraftItems;
import cookie.tropicraft.world.TropicraftWorldgen;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.TextureHelper;

public class Tropicraft implements ModInitializer {
    public static final String MOD_ID = "tropicraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Used by RenderBlocksMixin
    public static final int[] overlay = TextureHelper.getOrCreateBlockTexture(MOD_ID, "leaves_citrus_overlay.png");

    @Override
    public void onInitialize() {

        // DO NOT TOUCH THIS! It's an error prevention method. Thanks Useless!
        try {
            Class.forName("net.minecraft.core.block.Block");
            Class.forName("net.minecraft.core.item.Item");
        } catch (ClassNotFoundException ignored) {}



        new TropicraftBlocks().initializeBlocks();
        new TropicraftItems().initializeItems();

        new TropicraftWorldgen().initializeWorldGen();

        LOGGER.info("Tropicraft initialized. Have a happy vacation!");
    }
}
