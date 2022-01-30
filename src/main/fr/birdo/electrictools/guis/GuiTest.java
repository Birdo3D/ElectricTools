package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.GuiGeneric;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiTest extends GuiGeneric {

    private final List<main.fr.birdo.electrictools.utils.Button> buttons = new ArrayList<>();

    public GuiTest(){
        buttons.add(new main.fr.birdo.electrictools.utils.Button(0, ElectricTools.getResource("btn.png"), 102, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        buttons.add(new main.fr.birdo.electrictools.utils.Button(1, ElectricTools.getResource("btn.png"), 373, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
    }

    public static void drawScreen(Graphics graphics) {
        graphics.drawString("Coucou", 500, 500);
    }

    public java.util.List<Button> getButtons() {
        return this.buttons;
    }

    public void onButtonClicked(int buttonIndex) {
        switch (buttonIndex) {
            case 0:
                Gui.setMode(Gui.Mode.DIAGRAMS);
                break;
            case 1:
                Gui.setMode(Gui.Mode.TEST);
                break;
        }
    }
}