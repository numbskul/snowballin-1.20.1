package numbskul.modid.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class BlazeBallEntity extends SnowballEntity {

    public BlazeBallEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    public BlazeBallEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public BlazeBallEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 0);
        if (entity instanceof LivingEntity) {
            if (entity.getFireTicks() < 75) {
                entity.setFireTicks(75);
            } else {
                entity.setFireTicks(entity.getFireTicks() + 20);
            }
        }
    }
}
