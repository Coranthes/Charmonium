package svenhjol.charmonium.ambience.client;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import svenhjol.charm.tweaks.client.AmbientMusicClient;
import svenhjol.charmonium.base.CharmoniumSounds;
import svenhjol.meson.Meson;
import svenhjol.meson.helper.ClientHelper;
import svenhjol.meson.helper.PlayerHelper;
import svenhjol.meson.helper.WorldHelper;

public class MusicClient {
    public MusicClient() {
        if (!Meson.isModuleEnabled("charm:ambient_music_improvements")) return;

        // play Þarna in overworld anywhere
        AmbientMusicClient.conditions.add(new AmbientMusicClient.AmbientMusicCondition(CharmoniumSounds.MUSIC_THARNA, 1200, 3600, mc -> {
            PlayerEntity player = ClientHelper.getClientPlayer();
            if (player == null || player.world == null) return false;
            return player.world.rand.nextFloat() < 0.08F
                && WorldHelper.isDimension(player.world, new ResourceLocation("overworld"));
        }));

        // play Steinn in overworld underground
        AmbientMusicClient.conditions.add(new AmbientMusicClient.AmbientMusicCondition(CharmoniumSounds.MUSIC_STEINN, 1200, 3600, mc -> {
            PlayerEntity player = ClientHelper.getClientPlayer();
            if (player == null || player.world == null) return false;
            return PlayerHelper.getPosition(player).getY() < 48
                && WorldHelper.isDimension(player.world, new ResourceLocation("overworld"))
                && player.world.rand.nextFloat() < 0.1F;
        }));

        // play Mús in cold environments
        AmbientMusicClient.conditions.add(new AmbientMusicClient.AmbientMusicCondition(CharmoniumSounds.MUSIC_MUS, 1200, 3600, mc ->
            mc.player != null
                && mc.player.world.getBiome(PlayerHelper.getPosition(mc.player)).getCategory() == Biome.Category.ICY
                && mc.player.world.rand.nextFloat() < 0.28F
        ));

        // play Undir in nether underground
        AmbientMusicClient.conditions.add(new AmbientMusicClient.AmbientMusicCondition(CharmoniumSounds.MUSIC_UNDIR, 1200, 3600, mc -> {
            PlayerEntity player = ClientHelper.getClientPlayer();
            if (player == null) return false;
            return PlayerHelper.getPosition(player).getY() < 48
                && WorldHelper.isDimension(player.world, new ResourceLocation("the_nether"))
                && player.world.rand.nextFloat() < 0.33F;
        }));
    }
}
