package cookie.tropicraft.util;

import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.ContainerPlayerCreative;

public class ContainerPlayerExtender {

    public void initializeExtender() {
        for(int itemCount = Block.blocksList.length; itemCount < Item.itemsList.length; ++itemCount) {
            if (itemCount == TropicraftItems.shell.id) {
                for (int meta = 1; meta < 5; meta++) {
                    ContainerPlayerCreative.creativeItems.add(new ItemStack(Item.itemsList[itemCount], 1, meta));
                    ++ContainerPlayerCreative.creativeItemsCount;
                }
            }
        }
    }
}
