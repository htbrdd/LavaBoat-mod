package LavaBoat.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

/*
 * LavaBoat mod
 *
 * @author NightKosh
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 */
public class EntityLavaBoat extends EntityNKBoat {

    public EntityLavaBoat(World world) {
        super(world);
        this.isImmuneToFire = true;
    }

    public EntityLavaBoat(World world, double x, double y, double z) {
        this(world);
        this.setPosition(x + 0.5, y + this.getYOffset() + 1, z + 0.5);
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    /**
     * Returns the Y offset from the entity's position for any entity riding
     * this one.
     */
    @Override
    public double getMountedYOffset() {
        return 0.35;
    }

    @Override
    protected EnumParticleTypes getParticles() {
        return EnumParticleTypes.LAVA;
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player) {
        if (this.riddenByEntity != null && this.riddenByEntity == player) {
            PotionEffect effect = new PotionEffect(Potion.fireResistance.getId(), 300);
            player.addPotionEffect(effect);
        }
        super.onCollideWithPlayer(player);
    }

    @Override
    protected Material getWaterMaterial() {
        return Material.lava;
    }

    @Override
    protected double getYShift() {
        return -0.05;
    }

    @Override
    protected int getItemDamage() {
        return 3;
    }
}
