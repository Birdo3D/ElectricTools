package fr.birdo.electrictools.gui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiTest extends GenericGui {

    private final List<Button> buttons = new ArrayList<>();

    public GuiTest(){

    }

    public GuiTest(Graphics graphics) {
        graphics.drawString("Coucou", 100, 100);
    }

    public java.util.List<Button> getButtons() {
        return this.buttons;
    }

    public void onButtonClicked(int buttonIndex) {
    }
}