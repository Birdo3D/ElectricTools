package fr.birdo.electrictools.gui;

import fr.birdo.electrictools.ElectricTools;
import fr.birdo.electrictools.gui.button.Button;
import fr.birdo.electrictools.gui.button.TexturedButton;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiDiagrams extends SimpleGui {

    private final List<fr.birdo.electrictools.gui.button.Button> buttonList = new ArrayList<>();

    public GuiDiagrams(Graphics graphics){
        graphics.drawString("Active Mode : Diagrams", 20, 40);
        buttonList.add(new TexturedButton(0, ElectricTools.getResource("icon.png"), 51, 94, 100, 100));
    }

    public void onButtonClicked(int buttonIndex) {
        System.out.println("Button pressed !");
    }

    public List<Button> getButtonList() {
        return this.buttonList;
    }
}