package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import java.awt.*;

public class GuiStart extends Gui {

    public GuiStart() {
        super("gui_start", "Welcome to ElectricTools !", 800, 400);
        setContentPane(this);
        setToolbar(new ToolBar(this, 30));
    }

    public void paintComponent(Graphics g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), (int) this.getFrame().getSize().getHeight());
        //Top Bar
        g.setColor(ElectricTools.mode.getTopBarColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), 30);
        //Toolbar
        getToolBar().drawToolbar();
    }

    public void buttonClicked(Button button, int mouseButton, int clickCount) {

    }
}
