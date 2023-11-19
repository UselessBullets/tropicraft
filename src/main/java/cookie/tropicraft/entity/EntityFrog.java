package cookie.tropicraft.entity;

import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.world.World;

public class EntityFrog extends EntityAnimal {

	public EntityFrog(World world) {
		super(world);
		skinName = "frog";
		highestSkinVariant = 0;
		this.health = 5;
	}

	@Override
	protected int getDropItemId() {
		return TropicraftItems.foodFrogRaw.id;
	}

	@Override
	protected String getLivingSound() {
		return "tropicraft.frog";
	}

	@Override
	protected String getHurtSound() {
		return null;
	}

	@Override
	protected String getDeathSound() {
		return null;
	}
}
