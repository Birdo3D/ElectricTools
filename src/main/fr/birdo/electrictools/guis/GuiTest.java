package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.GenericGui;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiTest extends GenericGui {

    private final List<main.fr.birdo.electrictools.utils.Button> buttons = new ArrayList<>();

    public GuiTest(){
    }

    public static void drawScreen(Graphics graphics) {
        graphics.drawString("Coucou", 500, 500);
    }

    public java.util.List<Button> getButtons() {
        return this.buttons;
    }

    public void onButtonClicked(int buttonIndex) {
    }
}