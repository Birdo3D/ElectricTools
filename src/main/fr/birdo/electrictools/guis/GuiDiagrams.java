package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.AdaptativeScreen;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.GenericGui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiDiagrams extends GenericGui {

    private final List<main.fr.birdo.electrictools.utils.Button> buttons = new ArrayList<>();

    public GuiDiagrams() {
        buttons.add(new main.fr.birdo.electrictools.utils.Button(0, ElectricTools.getResource("btn.png"), 102, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        buttons.add(new main.fr.birdo.electrictools.utils.Button(1, ElectricTools.getResource("btn.png"), 373, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
    }

    public static void drawScreen(Graphics graphics) {
        //Grid
        int test = Gui.width + Gui.height;
        int test2 = Gui.frame.getWidth() + Gui.frame.getHeight();
        int zoomValue = 0;
        int rectSize = AdaptativeScreen.get(test, test2, 20);
        for (int j = 0; j < 24; j++) {
            for (int i = 0; i < 46; i++) {
                int a = AdaptativeScreen.get(Gui.width, Gui.frame.getWidth(), 272) + (i * rectSize);
                int b = AdaptativeScreen.get(Gui.height, Gui.frame.getHeight(), 154 - 8) + (j * rectSize);
                graphics.setColor(Color.GRAY);
                graphics.drawRect(a, b, rectSize, rectSize);
            }
        }
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