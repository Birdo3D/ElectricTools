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
        buttonList.add(new TexturedButton(0, ElectricTools.getResource("btn.png"), 102, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        buttonList.add(new TexturedButton(1, ElectricTools.getResource("btn.png"), 373, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        //Grid 272 154
        int test = ElectricTools.width + ElectricTools.height;
        int test2 = ElectricTools.frame.getWidth() + ElectricTools.frame.getHeight();
        int zoomValue = 0;
        int rectSize = AdaptativeScreen.get(test, test2, 20);
        for (int j = 0; j < 24; j++) {
            for (int i = 0; i < 46; i++) {
                int a = AdaptativeScreen.get(ElectricTools.width, ElectricTools.frame.getWidth(), 272) + (i * rectSize);
                int b = AdaptativeScreen.get(ElectricTools.height, ElectricTools.frame.getHeight(), 154 - 8) + (j * rectSize);
                graphics.drawRect(a, b, rectSize, rectSize);
                graphics.setColor(Color.GRAY);
            }
        }
    }

    public void onButtonClicked(int buttonIndex) {
        if (buttonIndex == 0) {
           Pannel.setMode(Mode.DIAGRAMS);
        }else if (buttonIndex == 1) {
            Pannel.setMode(Mode.TEST);
        }
    }

    public List<Button> getButtonList() {
        return this.buttonList;
    }
}