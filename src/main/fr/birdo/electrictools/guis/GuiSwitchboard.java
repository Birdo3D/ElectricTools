package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import java.awt.*;

public class GuiSwitchboard extends Gui {

    public GuiSwitchboard() {
        super("gui_switchboard", "Untitled - ElectricTools Switchboard", 800, 400);
        setContentPane(this);
        ToolbarButton toolbarButton0 = new ToolbarButton(0, "File", 0);
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9010, "button 1", null));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9011, "button 2", null));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9012, "button 3", null));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9013, "button 4", null));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9014, "button 5", null));
        addButton(toolbarButton0);
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