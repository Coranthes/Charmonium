package svenhjol.charmonium.ambience.client.ambience;

import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;
import svenhjol.charmonium.ambience.client.ambience.BaseAmbientSounds;
import svenhjol.charmonium.ambience.client.iface.IBiomeAmbience;
import svenhjol.charmonium.base.CharmoniumSounds;

import javax.annotation.Nullable;

public class OceanAmbientSounds extends BaseAmbientSounds implements IBiomeAmbience {
    public OceanAmbientSounds(PlayerEntity player, SoundHandler soundHandler) {
        super(player, soundHandler);
    }

    @Nullable
    @Override
    public SoundEvent getLongSound() {
        return CharmoniumSounds.AMBIENCE_OCEAN_LONG;
    }

    @Nullable
    @Override
    public SoundEvent getShortSound() {
        return null;
    }

    @Override
    public boolean validBiomeConditions(Biome.Category biomeCategory) {
        return biomeCategory == Biome.Category.OCEAN
            && isOutside();
    }
}
