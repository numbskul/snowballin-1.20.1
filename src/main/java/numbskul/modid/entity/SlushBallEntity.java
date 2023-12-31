package numbskul.modid.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class SlushBallEntity extends SnowballEntity {
    public SlushBallEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    public SlushBallEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public SlushBallEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof BlazeEntity ? 3 : 0;
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), i);
        if (entity instanceof LivingEntity) {
            if (entity.getFrozenTicks() < 200) {
                entity.setFrozenTicks(200);
            } else {
                entity.setFrozenTicks(entity.getFrozenTicks() + 75);
            }
        }
    }
}
