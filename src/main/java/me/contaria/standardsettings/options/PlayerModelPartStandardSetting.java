package me.contaria.standardsettings.options;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import me.contaria.standardsettings.StandardGameOptions;
import net.minecraft.client.gui.screen.ScreenTexts;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.text.Text;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlayerModelPartStandardSetting extends StandardSetting<Boolean> {
    private final PlayerModelPart playerModelPart;

    public PlayerModelPartStandardSetting(String id, @Nullable String category, StandardGameOptions options, PlayerModelPart playerModelPart) {
        super(id, category, options);
        this.playerModelPart = playerModelPart;

        this.set(this.getOption());
    }

    @Override
    public Boolean get(GameOptions options) {
        return options.getEnabledPlayerModelParts().contains(this.playerModelPart);
    }

    @Override
    public void set(GameOptions options, Boolean value) {
        options.setPlayerModelPart(this.playerModelPart, value);
    }

    @Override
    protected void valueFromJson(JsonElement jsonElement) {
        this.set(jsonElement.getAsBoolean());
    }

    @Override
    protected JsonElement valueToJson() {
        return new JsonPrimitive(this.get());
    }

    @Override
    public @NotNull Text getName() {
        return this.playerModelPart.getOptionName();
    }

    @Override
    public @NotNull Text getDisplayText() {
        return ScreenTexts.getToggleText(this.get());
    }

    @Override
    public @NotNull AbstractButtonWidget createMainWidget() {
        return new ButtonWidget(0, 0, 120, 20, this.getText(), button -> {
            this.options.togglePlayerModelPart(this.playerModelPart);
            button.setMessage(this.getText());
        });
    }
}
