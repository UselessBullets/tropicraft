package cookie.tropicraft.entity.render;

import cookie.tropicraft.entity.EntityFrog;
import cookie.tropicraft.entity.EntityFrogPoison;
import net.minecraft.client.render.entity.LivingRenderer;
import net.minecraft.client.render.model.ModelBase;

public class RenderFrogPoison extends LivingRenderer<EntityFrogPoison> {

	public RenderFrogPoison(ModelBase modelbase) {
		super(modelbase, 0.3F);
	}
}
