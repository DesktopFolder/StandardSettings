package me.contaria.standardsettings.compat;

import me.jellysquid.mods.sodium.client.SodiumClientMod;

public class SodiumCompat {

    public static void setEntityCulling(boolean value) {
        SodiumClientMod.options().advanced.useEntityCulling = value;
    }

    public static boolean getEntityCulling() {
        return SodiumClientMod.options().advanced.useEntityCulling;
    }
}
