package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import java.awt.*;

public class GuiStart extends Gui {

    public GuiStart() {
        super("gui_start", Translation.getTranslation("gui_start.title"), 800, 400);
        setContentPane(this);
        setToolbar(new ToolBar(this, 30));
        //New switchboard button
        addButton(new Button(0, 60, 60, 80, 80));
    }

    public void paintComponent(Graphics g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), (int) this.getFrame().getSize().getHeight());
        //Top Bar
        getToolBar().drawToolbar();
        //Buttons
        for (Button button : this.getButtons()) {
            switch (button.getId()) {
                case 0:
                    if (button.isHover()) {
                        g.setColor(Color.magenta);
                        g.fillRoundRect(60, 60, 80, 80, 14, 14);
                    }
                    g.setColor(Color.YELLOW);
                    g.fillRoundRect(80, 80, 40, 40, 14, 14);
                    break;
            }
        }
    }

    public void buttonClicked(Button button, int mouseButton, int clickCount) {
        switch (button.getId()) {
            case 0:
                GuiUtilities.closeGui(this);
                try {
                    Thread.sleep(1000 / 5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                GuiUtilities.openGui(Guis.switchboardGui);
                break;
        }
    }
}