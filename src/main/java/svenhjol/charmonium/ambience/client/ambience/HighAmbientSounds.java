package svenhjol.charmonium.ambience.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.meson.helper.PlayerHelper;
import svenhjol.meson.helper.WorldHelper;

import javax.annotation.Nullable;

public class HighAmbientSounds extends BaseAmbientSounds {
    public HighAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    @Override
    public boolean isValid() {
        return WorldHelper.isDimension(world, new ResourceLocation("overworld"))
            && PlayerHelper.getPosition(player).getY() > 150
            && !player.canSwim();
    }

    @Nullable
    @Override
    public SoundEvent getLongSound() {
        return CharmoniumSounds.AMBIENCE_HIGH;
    }

    @Nullable
    @Override
    public SoundEvent getShortSound() {
        return null;
    }
}
