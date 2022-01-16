package fr.birdo.electrictools.gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiDiagrams extends SimpleGui {

    private List<Button> buttonList = new ArrayList<>();

    public GuiDiagrams(Graphics graphics){
        graphics.drawString("Active Mode : Diagrams", 20, 40);
        buttonList.add(new Button(0, 0, 0, 50, 50));
    }

    public void onButtonClicked(int buttonIndex) {
        System.out.println("Button pressed !");
    }

    public List<Button> getButtonList() {
        return this.buttonList;
    }
}