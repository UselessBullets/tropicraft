package cookie.tropicraft.mixin;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.block.BlockLeavesCitrus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.RenderBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.WorldSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import turniplabs.halplibe.helper.TextureHelper;

@Mixin(value = RenderBlocks.class, remap = false)
public class RenderBlocksMixin {

    @Shadow private WorldSource blockAccess;

    @Shadow private int overrideBlockTexture;

    @Unique
    private final Minecraft mc = Minecraft.getMinecraft(this);

    // Has to be put in here else it doesn't work for some reason
    @Unique
    private boolean renderCitrus(BlockLeavesCitrus block, int x, int y, int z) {
        int meta = this.blockAccess.getBlockMetadata(x, y, z);
        RenderBlocks renderBlocks = (RenderBlocks)(Object)this;
        renderBlocks.renderStandardBlock(block, x, y, z);
        if (meta == 1) {
            int[] overlay = Tropicraft.overlay;
            this.overrideBlockTexture = (Block.texCoordToIndex(overlay[0], overlay[1]));
            if (mc.isAmbientOcclusionEnabled()) {
                renderBlocks.renderStandardBlockWithAmbientOcclusion(block, x, y, z, 1.0F, 1.0F, 1.0F);
            } else {
                renderBlocks.renderStandardBlockWithColorMultiplier(block, x, y, z, 1.0F, 1.0F, 1.0F);
            }
            this.overrideBlockTexture = -1;
        }
        return true;
    }

    @Inject(method = "renderBlockByRenderType", at = @At("HEAD"), cancellable = true)
    private void tropicraft_renderLeaves(Block block, int renderType, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
        if (renderType == 33)
            cir.setReturnValue(renderCitrus((BlockLeavesCitrus) block, x, y, z));
    }
}
