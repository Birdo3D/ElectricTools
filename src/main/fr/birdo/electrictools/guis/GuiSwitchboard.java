package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.ToolBar;
import main.fr.birdo.electrictools.utils.ToolbarButton;

import java.awt.*;

public class GuiSwitchboard extends Gui {

    public GuiSwitchboard() {
        super("gui_switchboard", "File - Switchboard", 800, 400);
        setContentPane(this);
        addButton(new ToolbarButton(0, "File", 0));
        addButton(new ToolbarButton(1, "Edit", 1));
        addButton(new ToolbarButton(2, "View", 2));
        addButton(new ToolbarButton(3, "Navigate", 3));
        addButton(new ToolbarButton(4, "Code", 4));
        setToolbar(new ToolBar(this, 30));
    }

    public void paintComponent(Graphics g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), (int) this.getFrame().getSize().getHeight());
        //Top Bar
        getToolBar().drawToolbar();
    }

    public void buttonClicked(Button button, int mouseButton, int clickCount) {

    }
}