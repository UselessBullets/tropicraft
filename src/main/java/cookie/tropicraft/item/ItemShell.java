package cookie.tropicraft.item;

import cookie.tropicraft.Tropicraft;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.TextureHelper;

public class ItemShell extends Item {

    private final int[][] texture = new int[][]{
            TextureHelper.getOrCreateItemTexture(Tropicraft.MOD_ID, "shell_common.png"),
            TextureHelper.getOrCreateItemTexture(Tropicraft.MOD_ID, "shell_common_2.png"),
            TextureHelper.getOrCreateItemTexture(Tropicraft.MOD_ID, "shell_common_3.png"),
            TextureHelper.getOrCreateItemTexture(Tropicraft.MOD_ID, "shell_rare.png"),
            TextureHelper.getOrCreateItemTexture(Tropicraft.MOD_ID, "shell_seastar.png")
    };

    public ItemShell(int id) {
        super(id);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    @Override
    public int getIconFromDamage(int id) {
        switch (id) {
            case 1:
                return iconCoordToIndex(texture[1][0], texture[1][1]);
            case 2:
                return iconCoordToIndex(texture[2][0], texture[2][1]);
            case 3:
                return iconCoordToIndex(texture[3][0], texture[3][1]);
            case 4:
                return iconCoordToIndex(texture[4][0], texture[4][1]);
            default:
                return iconCoordToIndex(texture[0][0], texture[0][1]);
        }
    }

    @Override
    public String getLanguageKey(ItemStack itemstack) {
        switch (itemstack.getMetadata()) {
            default:
                return super.getLanguageKey(itemstack);
            case 3:
                return "item.tropicraft.shell.rare";
            case 4:
                return "item.tropicraft.shell.seastar";
        }
    }
}
