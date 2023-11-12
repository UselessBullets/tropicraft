package cookie.tropicraft.mixin;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.block.BlockLeavesCitrus;
import cookie.tropicraft.block.BlockLeavesFlowering;
import cookie.tropicraft.block.BlockTorchTiki;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.RenderBlocks;
import net.minecraft.client.render.Tessellator;
import net.minecraft.core.block.Block;
import net.minecraft.core.world.WorldSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = RenderBlocks.class, remap = false)
public class RenderBlocksMixin {

    @Shadow private WorldSource blockAccess;

    @Shadow private int overrideBlockTexture;

    @Unique
    private final Minecraft mc = Minecraft.getMinecraft(this);

    // Has to be put in here else it doesn't work for some reason
    @Unique
    private boolean renderLeavesCitrus(BlockLeavesCitrus block, int x, int y, int z) {
        int meta = this.blockAccess.getBlockMetadata(x, y, z);
        RenderBlocks renderBlocks = (RenderBlocks)(Object)this;
        renderBlocks.renderStandardBlock(block, x, y, z);
        if (meta == 1) {
            int[] overlay = Tropicraft.citrusOverlay;
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

	@Unique
	private boolean renderLeavesFlowering(BlockLeavesFlowering block, int x, int y, int z) {
		int meta = this.blockAccess.getBlockMetadata(x, y, z);
		RenderBlocks renderBlocks = (RenderBlocks)(Object)this;
		renderBlocks.renderStandardBlock(block, x, y, z);
		if (meta == 1) {
			int[] overlay = Tropicraft.floweringOverlay;
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

	@Unique
	private boolean renderTikiTorch(BlockTorchTiki block, int x, int y, int z) {
        RenderBlocks renderBlocks = (RenderBlocks)(Object)this;
		Tessellator tessellator = Tessellator.instance;
		float f = renderBlocks.getBlockBrightness(blockAccess, x, y, z);

		if (Block.lightValue[block.id] > 0)
			f = 1.0F;

		int[][] overlay = Tropicraft.torchTextures;
		if (blockAccess.getBlockMetadata(x, y, z) == 1)
			overrideBlockTexture = (Block.texCoordToIndex(overlay[1][0], overlay[1][1]));
		else
			overrideBlockTexture = (Block.texCoordToIndex(overlay[0][0], overlay[0][1]));

		tessellator.setColorOpaque_F(f, f, f);
		renderBlocks.renderTorchAtAngle(block, x, y, z, 0.0, 0.0);
		overrideBlockTexture = -1;

		return true;
	}

    @Inject(method = "renderBlockByRenderType", at = @At("HEAD"), cancellable = true)
    private void tropicraft_renderLeaves(Block block, int renderType, int x, int y, int z, CallbackInfoReturnable<Boolean> cir) {
        if (renderType == 33)
            cir.setReturnValue(renderLeavesCitrus((BlockLeavesCitrus) block, x, y, z));
		if (renderType == 34)
			cir.setReturnValue(renderTikiTorch((BlockTorchTiki) block, x, y, z));
		if (renderType == 35)
			cir.setReturnValue(renderLeavesFlowering((BlockLeavesFlowering) block, x, y, z));
    }
}
