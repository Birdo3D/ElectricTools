package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.ResourceLoader;

import java.awt.*;

public class GuiStart extends Gui {

    private int guiSizeX = 800;
    private int guiSizeY = 400;

    public GuiStart() {
        super("gui_start", "Welcome to ElectricTools !", 800, 400);
        setContentPane(this);
        addButton(new Button(0,  "Test Button", 740, 0, 60, 30));
    }

    public void paintComponent(Graphics g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, this.guiSizeX, this.guiSizeY);
        //Top Bar
        g.setColor(ElectricTools.mode.getTopBarColor());
        g.fillRect(0, 0, this.guiSizeX, 30);
        //Logo
        g.drawImage(ResourceLoader.getImage("logo.png"), 5, 5, 20, 20, null);
    }

    public void buttonHover(Button button) {
    }

    public void buttonClicked(Button button) {
        System.out.println("Okkkk");
    }
}
