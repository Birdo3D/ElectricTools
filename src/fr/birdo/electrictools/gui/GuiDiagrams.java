package fr.birdo.electrictools.gui;

import fr.birdo.electrictools.ElectricTools;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiDiagrams extends GenericGui {

    private final List<Button> buttons = new ArrayList<>();

    public GuiDiagrams(){
        buttons.add(new Button(0, ElectricTools.getResource("btn.png"), 102, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        buttons.add(new Button(1, ElectricTools.getResource("btn.png"), 373, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
    }

    public GuiDiagrams(Graphics graphics) {
        //Grid
        int test = Gui.width + Gui.height;
        int test2 = Gui.frame.getWidth() + Gui.frame.getHeight();
        int zoomValue = 0;
        int rectSize = AdaptativeScreen.get(test, test2, 20);
        for (int j = 0; j < 24; j++) {
            for (int i = 0; i < 46; i++) {
                int a = AdaptativeScreen.get(Gui.width, Gui.frame.getWidth(), 272) + (i * rectSize);
                int b = AdaptativeScreen.get(Gui.height, Gui.frame.getHeight(), 154 - 8) + (j * rectSize);
                graphics.drawRect(a, b, rectSize, rectSize);
                graphics.setColor(Color.GRAY);
            }
        }
    }

    public java.util.List<Button> getButtons() {
        return this.buttons;
    }

    public void onButtonClicked(int buttonIndex) {
        if (buttonIndex == 0) {
            Gui.setMode(Gui.Mode.DIAGRAMS);
        } else if (buttonIndex == 1) {
            Gui.setMode(Gui.Mode.TEST);
        }
    }
}