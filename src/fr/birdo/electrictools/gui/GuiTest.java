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
        buttonList.add(new TexturedButton(0, ElectricTools.getResource("btn.png"), 102, 12, 198, 27));
        buttonList.add(new TexturedButton(1, ElectricTools.getResource("btn.png"), 373, 12, 198, 27));
    }

    public void onButtonClicked(int buttonIndex) {
        if (buttonIndex == 0) {
            Pannel.setMode(Mode.DIAGRAMS);
        } else if (buttonIndex == 1) {
            Pannel.setMode(Mode.TEST);
        }
    }

    public List<Button> getButtonList() {
        return this.buttonList;
    }
}
