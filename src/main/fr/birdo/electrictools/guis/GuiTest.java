package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.GuiGeneric;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuiTest extends GuiGeneric {

    private final List<main.fr.birdo.electrictools.utils.Button> buttons = new ArrayList<>();

    public GuiTest() {
        buttons.add(new main.fr.birdo.electrictools.utils.Button(1, ElectricTools.getResource("btn.png"), 102, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        buttons.add(new main.fr.birdo.electrictools.utils.Button(0, ElectricTools.getResource("btn.png"), 373, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
    }

    public static void drawScreen(Graphics graphics) {
        graphics.drawString("Mode 2 : Test", 500, 500);
    }

    public java.util.List<Button> getButtons() {
        return this.buttons;
    }

    public void onButtonClicked(int buttonIndex) {
        switch (buttonIndex) {
            case 1:
                Gui.setMode(Gui.Mode.DIAGRAMS);
                for (Button button : Objects.requireNonNull(Gui.getGui()).getButtons())
                    button.setHover(button.getId() == 0);
                break;
        }
    }
}