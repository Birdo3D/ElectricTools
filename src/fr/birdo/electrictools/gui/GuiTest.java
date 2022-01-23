package fr.birdo.electrictools.gui;

import fr.birdo.electrictools.ElectricTools;
import fr.birdo.electrictools.gui.button.Button;
import fr.birdo.electrictools.gui.button.TexturedButton;
import fr.birdo.electrictools.util.Mode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiTest extends SimpleGui {

    private final List<Button> buttonList = new ArrayList<>();

    public GuiTest(Graphics graphics) {
        buttonList.add(new TexturedButton(1, ElectricTools.getResource("icon.png"), 8, 8, 408, 12));
        buttonList.add(new TexturedButton(2, ElectricTools.getResource("icon.png"), 422, 8, 408, 12));
    }

    public void onButtonClicked(int buttonIndex) {
        System.out.println(buttonIndex);
        if (buttonIndex == 1) {
            Pannel.setMode(Mode.DIAGRAMS);
        } else if (buttonIndex == 2) {
            Pannel.setMode(Mode.TEST);
        }
    }

    public List<Button> getButtonList() {
        return this.buttonList;
    }
}
