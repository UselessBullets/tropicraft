package cookie.tropicraft.entity;

import com.mojang.nbt.CompoundTag;
import cookie.tropicraft.item.TropicraftItems;
import net.minecraft.core.HitResult;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.entity.projectile.EntityPebble;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.DamageType;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

import java.util.List;

public class EntityCoconut extends Entity {

	private boolean firstBounce = true;
	private int xTileSnowball = -1;
	private int yTileSnowball = -1;
	private int zTileSnowball = -1;
	private int inTileSnowball = 0;
	public int shakeSnowball = 0;
	private boolean inGroundSnowball = false;
	private int ticksInAirSnowball = 0;
	private int ticksInGroundSnowball;
	private final EntityLiving thrower;

	public EntityCoconut(World world, EntityLiving entityliving) {
		super(world);
		this.thrower = entityliving;
		this.setSize(0.25F, 0.25F);
		this.moveTo(entityliving.x, entityliving.y + (double)entityliving.getHeadHeight(), entityliving.z, entityliving.yRot, entityliving.xRot);
		this.x -= MathHelper.cos(this.yRot / 180.0F * 3.141593F) * 0.16F;
		this.y -= 0.1F;
		this.z -= MathHelper.sin(this.yRot / 180.0F * 3.141593F) * 0.16F;
		this.setPos(this.x, this.y, this.z);
		this.heightOffset = 0.0F;
		float f = 0.1F;
		this.xd = -MathHelper.sin(this.yRot / 180.0F * 3.141593F) * MathHelper.cos(this.xRot / 180.0F * 3.141593F) * f;
		this.zd = MathHelper.cos(this.yRot / 180.0F * 3.141593F) * MathHelper.cos(this.xRot / 180.0F * 3.141593F) * f;
		this.yd = -MathHelper.sin(this.xRot / 180.0F * 3.141593F) * f;
		this.setSnowballHeading(this.xd, this.yd, this.zd, 1.0F, 1.0F);
	}

	@Override
	protected void init() {

	}

	public void setSnowballHeading(double d, double d1, double d2, float f, float f1) {
		float f2 = MathHelper.sqrt_double(d * d + d1 * d1 + d2 * d2);
		d /= f2;
		d1 /= f2;
		d2 /= f2;
		d += this.random.nextGaussian() * 0.0075F * (double)f1;
		d1 += this.random.nextGaussian() * 0.0075F * (double)f1;
		d2 += this.random.nextGaussian() * 0.0075F * (double)f1;
		d *= f;
		d1 *= f;
		d2 *= f;
		this.xd = d;
		this.yd = d1;
		this.zd = d2;
		float f3 = MathHelper.sqrt_double(d * d + d2 * d2);
		this.yRotO = this.yRot = (float)(Math.atan2(d, d2) * 180.0 / (float) Math.PI);
		this.xRotO = this.xRot = (float)(Math.atan2(d1, f3) * 180.0 / (float) Math.PI);
		this.ticksInGroundSnowball = 0;
	}

	public void lerpMotion(double xd, double yd, double zd) {
		this.xd = xd;
		this.yd = yd;
		this.zd = zd;
		if (this.xRotO == 0.0F && this.yRotO == 0.0F) {
			float f = MathHelper.sqrt_double(xd * xd + zd * zd);
			this.yRotO = this.yRot = (float) (Math.atan2(xd, zd) * 180.0 / (float) Math.PI);
			this.xRotO = this.xRot = (float) (Math.atan2(yd, f) * 180.0 / (float) Math.PI);
		}
	}

	public void tick() {
		this.xOld = this.x;
		this.yOld = this.y;
		this.zOld = this.z;
		if (this.shakeSnowball > 0) {
			--this.shakeSnowball;
		}

		if (this.inGroundSnowball) {
			int i = this.world.getBlockId(this.xTileSnowball, this.yTileSnowball, this.zTileSnowball);
			if (i == this.inTileSnowball) {
				++this.ticksInGroundSnowball;
				if (this.ticksInGroundSnowball == 1200) {
					this.remove();
				}

				return;
			}

			this.inGroundSnowball = false;
			this.xd *= this.random.nextFloat() * 0.2F;
			this.yd *= this.random.nextFloat() * 0.2F;
			this.zd *= this.random.nextFloat() * 0.2F;
			this.ticksInGroundSnowball = 0;
			this.ticksInAirSnowball = 0;
		} else {
			++this.ticksInAirSnowball;
		}

		Vec3d vec3d = Vec3d.createVector(this.x, this.y, this.z);
		Vec3d vec3d1 = Vec3d.createVector(this.x + this.xd, this.y + this.yd, this.z + this.zd);
		HitResult movingobjectposition = this.world.checkBlockCollisionBetweenPoints(vec3d, vec3d1);
		vec3d = Vec3d.createVector(this.x, this.y, this.z);
		vec3d1 = Vec3d.createVector(this.x + this.xd, this.y + this.yd, this.z + this.zd);
		if (movingobjectposition != null) {
			vec3d1 = Vec3d.createVector(movingobjectposition.location.xCoord, movingobjectposition.location.yCoord, movingobjectposition.location.zCoord);
		}

		if (!this.world.isClientSide) {
			Entity entity = null;
			List list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.bb.addCoord(this.xd, this.yd, this.zd).expand(1.0, 1.0, 1.0));
			double d = 0.0;

			for(int l = 0; l < list.size(); ++l) {
				Entity entity1 = (Entity)list.get(l);
				if (entity1.isPickable() && (entity1 != this.thrower || this.ticksInAirSnowball >= 5)) {
					float f4 = 0.3F;
					AABB axisalignedbb = entity1.bb.expand(f4, f4, f4);
					HitResult movingobjectposition1 = axisalignedbb.func_1169_a(vec3d, vec3d1);
					if (movingobjectposition1 != null) {
						double d1 = vec3d.distanceTo(movingobjectposition1.location);
						if (d1 < d || d == 0.0) {
							entity = entity1;
							d = d1;
						}
					}
				}
			}

			if (entity != null) {
				movingobjectposition = new HitResult(entity);
			}
		}

		if (movingobjectposition != null) {
			if (movingobjectposition.entity != null && !movingobjectposition.entity.hurt(this.thrower, 1, DamageType.COMBAT)) {
			}

			world.playSoundAtEntity(this, "tropicraft.bonk", 1.0f, 1.0f);
			if (!this.world.isClientSide) {
				EntityItem item = new EntityItem(this.world, this.x, this.y, this.z, new ItemStack(TropicraftItems.foodCoconutChunk, random.nextInt(4 - 1) + 1));
				this.world.entityJoinedWorld(item);
			}

			this.remove();
		}

		if (this.isInWater() && Math.abs(this.xd) + Math.abs(this.zd) > 0.5) {
			float modifier = 1.0F;
			if (this.firstBounce) {
				this.firstBounce = false;
				modifier = 1.0F + this.random.nextFloat() * 0.75F;
			}

			this.yd = (Math.abs(this.xd) + Math.abs(this.zd)) / 8.0 * (double)modifier;
		}

		this.x += this.xd;
		this.y += this.yd;
		this.z += this.zd;
		float f = MathHelper.sqrt_double(this.xd * this.xd + this.zd * this.zd);
		this.yRot = (float)(Math.atan2(this.xd, this.zd) * 180.0 / (float) Math.PI);
		this.xRot = (float)(Math.atan2(this.yd, f) * 180.0 / (float) Math.PI);

		while(this.xRot - this.xRotO < -180.0F) {
			this.xRotO -= 360.0F;
		}

		while(this.xRot - this.xRotO >= 180.0F) {
			this.xRotO += 360.0F;
		}

		while(this.yRot - this.yRotO < -180.0F) {
			this.yRotO -= 360.0F;
		}

		while(this.yRot - this.yRotO >= 180.0F) {
			this.yRotO += 360.0F;
		}

		this.xRot = this.xRotO + (this.xRot - this.xRotO) * 0.2F;
		this.yRot = this.yRotO + (this.yRot - this.yRotO) * 0.2F;
		float f1 = 0.99F;
		float f2 = 0.03F;
		if (this.isInWater()) {
			for(int k = 0; k < 4; ++k) {
				float f3 = 0.25F;
				this.world
					.spawnParticle(
						"bubble", this.x - this.xd * (double)f3, this.y - this.yd * (double)f3, this.z - this.zd * (double)f3, this.xd, this.yd, this.zd
					);
			}

			f1 = 0.8F;
		}

		this.xd *= f1;
		this.yd *= f1;
		this.zd *= f1;
		this.yd -= f2;
		this.setPos(this.x, this.y, this.z);
	}

	public void addAdditionalSaveData(CompoundTag tag) {
		tag.putShort("xTile", (short)this.xTileSnowball);
		tag.putShort("yTile", (short)this.yTileSnowball);
		tag.putShort("zTile", (short)this.zTileSnowball);
		tag.putShort("inTile", (short)this.inTileSnowball);
		tag.putByte("shake", (byte)this.shakeSnowball);
		tag.putByte("inGround", (byte)(this.inGroundSnowball ? 1 : 0));
	}

	public void readAdditionalSaveData(CompoundTag tag) {
		this.xTileSnowball = tag.getShort("xTile");
		this.yTileSnowball = tag.getShort("yTile");
		this.zTileSnowball = tag.getShort("zTile");
		this.inTileSnowball = tag.getShort("inTile") & 16383;
		this.shakeSnowball = tag.getByte("shake") & 255;
		this.inGroundSnowball = tag.getByte("inGround") == 1;
	}

	public float getShadowHeightOffs() {
		return 0.0F;
	}
}
