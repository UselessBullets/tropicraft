package cookie.tropicraft.entity;

import cookie.tropicraft.Tropicraft;
import cookie.tropicraft.entity.render.*;
import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.client.render.entity.SnowballRenderer;
import turniplabs.halplibe.helper.EntityHelper;
import useless.dragonfly.helper.ModelHelper;

public class TropicraftEntities {

	public void initializeEntities() {
		String MOD_ID = Tropicraft.MOD_ID;
		EntityHelper.createEntity(EntityCoconut.class, new SnowballRenderer(TropicraftItems.itemCoconut.getIconFromDamage(0)), 125, "coconut");

		EntityHelper.createEntity(EntityFrog.class, new RenderFrog(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/frog.json", ModelFrog.class)), 72, "Frog");
		EntityHelper.createEntity(EntityFrogPoison.class, new RenderFrogPoison(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/frog.json", ModelFrog.class)), 73, "PoisonFrog");
		EntityHelper.createEntity(EntityVervet.class, new RenderVervet(ModelHelper.getOrCreateEntityModel(MOD_ID, "entity/vervet.json", ModelVervet.class)), 74, "Vervet");
	}
}
