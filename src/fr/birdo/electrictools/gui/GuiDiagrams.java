package fr.birdo.electrictools.gui;

import fr.birdo.electrictools.ElectricTools;
import fr.birdo.electrictools.gui.button.Button;
import fr.birdo.electrictools.gui.button.TexturedButton;
import fr.birdo.electrictools.util.Mode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiDiagrams extends SimpleGui {

    private final List<fr.birdo.electrictools.gui.button.Button> buttonList = new ArrayList<>();

    public GuiDiagrams(Graphics graphics) {
        //graphics.drawString("Active Mode : Diagrams", 20, 40);
        //buttonList.add(new TexturedButton(0, ElectricTools.getResource("icon.png"), 51, 94, 100, 100));
        buttonList.add(new TexturedButton(1, ElectricTools.getResource("icon.png"), 8, 8, AdaptativeScreen.getWidth(408), AdaptativeScreen.getHeight(12)));
        buttonList.add(new TexturedButton(2, ElectricTools.getResource("icon.png"), 422, 8, AdaptativeScreen.getWidth(408), AdaptativeScreen.getHeight(12)));
        //Grid
        int test = ElectricTools.width + ElectricTools.height;
        int test2 = ElectricTools.frame.getWidth() + ElectricTools.frame.getHeight();
        int zoomValue = 0;
        int rectSize = AdaptativeScreen.get(test, test2, 20);
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 20; i++) {
                int a = AdaptativeScreen.get(ElectricTools.width, ElectricTools.frame.getWidth(), 200) + (i * rectSize);
                int b = AdaptativeScreen.get(ElectricTools.height, ElectricTools.frame.getHeight(), 100) + (j * rectSize);
                graphics.drawRect(a, b, rectSize, rectSize);
            }
        }
    }

    public void onButtonClicked(int buttonIndex) {
        System.out.println(buttonIndex);
        if (buttonIndex == 1) {
           Pannel.setMode(Mode.DIAGRAMS);
        }else if (buttonIndex == 2) {
            Pannel.setMode(Mode.TEST);
        }
    }

    public List<Button> getButtonList() {
        return this.buttonList;
    }
}