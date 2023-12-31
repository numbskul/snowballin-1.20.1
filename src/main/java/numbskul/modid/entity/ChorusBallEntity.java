package numbskul.modid.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class ChorusBallEntity extends SnowballEntity {

    public ChorusBallEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    public ChorusBallEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public ChorusBallEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 0);
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 40, 3));
        }
    }
}
