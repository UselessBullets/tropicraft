package cookie.tropicraft.mixin;

import cookie.tropicraft.block.TropicraftBlocks;
import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.WeightedRandomBag;
import net.minecraft.core.WeightedRandomLootObject;
import net.minecraft.core.block.entity.TileEntityTrommel;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = TileEntityTrommel.class, remap = false)
public class TileEntityTrommelMixin {

	@Unique
	private static final WeightedRandomBag<WeightedRandomLootObject> tropicraft_trommelDropsPurifiedSand = new WeightedRandomBag<>();

	@Inject(method = "canItemBeTrommeled", at = @At("TAIL"), cancellable = true)
	private void tropicraft_trommelPurifiedSand(ItemStack itemstack, CallbackInfoReturnable<Boolean> cir) {
		int i = itemstack.getItem().id;
		if (i == TropicraftBlocks.sandPurified.id)
			cir.setReturnValue(true);
	}

	@Inject(method = "getItemResult", at = @At("TAIL"), cancellable = true)
	private void tropicraft_itemResult(ItemStack slotItem, CallbackInfoReturnable<ItemStack> cir) {
		int i = slotItem.getItem().id;
		if (i == TropicraftBlocks.sandPurified.id)
			cir.setReturnValue(tropicraft_trommelDropsPurifiedSand.getRandom().getItemStack());
	}

	static {
        for (int i = 1; i < 4; i++) {
            tropicraft_trommelDropsPurifiedSand.addEntry(new WeightedRandomLootObject(new ItemStack(TropicraftItems.shell, 1, i), 1, 3), 25.0);
			tropicraft_trommelDropsPurifiedSand.addEntry(new WeightedRandomLootObject(new ItemStack(TropicraftItems.shell, 1, 4), 1, 2), 5);
        }
    }
}
