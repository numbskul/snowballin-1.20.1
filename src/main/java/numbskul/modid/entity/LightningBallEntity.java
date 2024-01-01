package numbskul.modid.entity;

import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class LightningBallEntity extends SnowballEntity {

    public LightningBallEntity(EntityType<? extends SnowballEntity> entityType, World world) {
        super(entityType, world);
    }

    public LightningBallEntity(World world, LivingEntity owner) {
        super(world, owner);
    }

    public LightningBallEntity(World world, double x, double y, double z) {
        super(world, x, y, z);
    }


    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient) {
            this.getWorld().sendEntityStatus(this, EntityStatuses.PLAY_DEATH_SOUND_OR_ADD_PROJECTILE_HIT_PARTICLES);
            LightningEntity bolt = EntityType.LIGHTNING_BOLT.create(this.getWorld());
            assert bolt != null;
            bolt.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0f);
            this.getWorld().spawnEntity(bolt);
            this.discard();
        }
    }
}
