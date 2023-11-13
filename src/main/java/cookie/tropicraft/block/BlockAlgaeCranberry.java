package cookie.tropicraft.block;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.block.BlockAlgae;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.season.Seasons;
import turniplabs.halplibe.helper.TextureHelper;

import java.util.Random;

public class BlockAlgaeCranberry extends BlockAlgae {

	private final int[][] cropTextures = new int[][] {
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "algae_cranberry_fruit.png"),
		TextureHelper.getOrCreateBlockTexture(Tropicraft.MOD_ID, "algae_cranberry.png")
	};

	public BlockAlgaeCranberry(String key, int id) {
		super(key, id, Material.plant);
		this.setBlockBounds(0.0F, -0.125F, 0.0F, 1.0F, 0.00625F, 1.0F);
	}

	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		if (world.getBlockMetadata(x, y, z) == 1) {
			world.dropItem(x, y, z, new ItemStack(TropicraftItems.foodCranberries));
			world.setBlockMetadataWithNotify(x, y, z, 0);
			return true;
		}
		return false;
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		if (!world.isClientSide) {
			int meta = world.getBlockMetadata(x, y, z);
            if (world.seasonManager.getCurrentSeason() == Seasons.OVERWORLD_SUMMER && meta == 0 && rand.nextInt(90) == 0)
                world.setBlockMetadataWithNotify(x, y, z, 1);
		}
	}

	@Override
	public int getBlockTextureFromSideAndMetadata(Side side, int meta) {
		int sideID = side.getId();
		if (meta == 1)
			atlasIndices[sideID] = texCoordToIndex(cropTextures[0][0], cropTextures[0][1]);
		else
			atlasIndices[sideID] = texCoordToIndex(cropTextures[1][0], cropTextures[1][1]);

		return atlasIndices[sideID];
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		if (dropCause == EnumDropCause.SILK_TOUCH || dropCause == EnumDropCause.PICK_BLOCK)
			return new ItemStack[]{new ItemStack(this.id, 1, 0)};
		else
			return null;
	}
}
