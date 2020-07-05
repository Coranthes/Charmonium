package svenhjol.charmonium.ambience.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.meson.helper.WorldHelper;

import javax.annotation.Nullable;

public class NetherAmbientSounds extends BaseAmbientSounds {
    public NetherAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    public boolean isValid() {
        if (world == null) return false;
        return WorldHelper.isDimension(world, new ResourceLocation("the_nether"));
    }

    @Override
    public int getShortSoundDelay() {
        return world.rand.nextInt(200) + 200;
    }

    @Nullable
    @Override
    public SoundEvent getLongSound() {
        return CharmoniumSounds.AMBIENCE_NETHER_LONG;
    }

    @Nullable
    @Override
    public SoundEvent getShortSound() {
        return CharmoniumSounds.AMBIENCE_NETHER_SHORT;
    }
}
