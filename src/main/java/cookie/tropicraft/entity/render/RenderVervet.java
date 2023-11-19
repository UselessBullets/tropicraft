package cookie.tropicraft.entity.render;

import cookie.tropicraft.entity.EntityVervet;
import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;

public class RenderVervet extends LivingRenderer<EntityVervet> {

	public RenderVervet(ModelBase modelbase) {
		super(modelbase, 0.75F);
	}
}
