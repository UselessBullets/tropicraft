package cookie.tropicraft.entity.render;

import cookie.tropicraft.entity.EntityFrog;
import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;

public class RenderFrog extends LivingRenderer<EntityFrog> {

	public RenderFrog(ModelBase modelbase) {
		super(modelbase, 0.3F);
	}
}
