package me.contaria.standardsettings.mixin.accessors;

import net.minecraft.client.options.BooleanOption;
import net.minecraft.client.options.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(BooleanOption.class)
public interface BooleanOptionAccessor {
    @Invoker("set")
    void standardsettings$set(GameOptions options, boolean value);
}
