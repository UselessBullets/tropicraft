package cookie.tropicraft.entity;

import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.entity.monster.EntityMonster;
import net.minecraft.core.world.World;

public class EntityFrogPoison extends EntityMonster {

	public EntityFrogPoison(World world) {
		super(world);
		skinName = "frogpoison";
		highestSkinVariant = 2;
		this.health = 5;
	}

	@Override
	protected int getDropItemId() {
		return TropicraftItems.leatherFrog.id;
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
