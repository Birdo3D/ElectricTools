package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import java.awt.*;

public class GuiSwitchboard extends Gui {

    public GuiSwitchboard() {
        super("gui_switchboard", "Untitled" + " - " + Translation.getTranslation("gui_switchboard.title"), 800, 400);
        setContentPane(this);
        ToolbarButton toolbarButton0 = new ToolbarButton(0, Translation.getTranslation(this.getLabel() + ".tb_button.file"), 0);
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9010, Translation.getTranslation(this.getLabel() + ".scrolling_button.new"), ResourceLoader.getImage("logo.png")));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9011, Translation.getTranslation(this.getLabel() + ".scrolling_button.open"), ResourceLoader.getImage("logo.png")));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9012, Translation.getTranslation(this.getLabel() + ".scrolling_button.close"), ResourceLoader.getImage("logo.png")));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9013, Translation.getTranslation(this.getLabel() + ".scrolling_button.save"), null));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9014, Translation.getTranslation(this.getLabel() + ".scrolling_button.save_as"), null));
        addButton(toolbarButton0);
        addButton(new ToolbarButton(1, Translation.getTranslation(this.getLabel() + ".tb_button.edit"), 1));
        addButton(new ToolbarButton(2, Translation.getTranslation(this.getLabel() + ".tb_button.view"), 2));
        addButton(new ToolbarButton(3, Translation.getTranslation(this.getLabel() + ".tb_button.navigate"), 3));
        addButton(new ToolbarButton(4, Translation.getTranslation(this.getLabel() + ".tb_button.code"), 4));
        setToolbar(new ToolBar(this, 30));
    }

    public void paintComponent(Graphics g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), (int) this.getFrame().getSize().getHeight());
        //Top Bar
        getToolBar().drawToolbar();
        //Second Toolbar
        g.setColor(Color.GRAY);
        g.fillRect(0, this.getToolBar().getSize(), this.getWidth(), 80);
    }

    public void buttonClicked(Button button, int mouseButton, int clickCount) {
        switch (button.getId()) {
            case 9012:
                GuiUtilities.closeGui(this);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                GuiUtilities.openGui(Guis.startGui);
                break;
        }
    }
}