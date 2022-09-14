package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.ResourceLoader;

import java.awt.*;

public class GuiLoading extends Gui {

    public GuiLoading() {
        super("gui_loading", "Loading ElectricTools", 200, 200);
        setContentPane(this);
        setMovable(false);
    }

    public void paintComponent(Graphics g) {
        //Background
        g.drawImage(ResourceLoader.getImage("logo.png"), 0, 0, 200, 200, null);
    }
}
