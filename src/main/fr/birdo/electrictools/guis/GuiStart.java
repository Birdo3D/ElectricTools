package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.GuiUtilities;
import main.fr.birdo.electrictools.utils.ResourceLoader;

import java.awt.*;

public class GuiStart extends Gui {

    public GuiStart() {
        super("gui_start", "Welcome to ElectricTools !", 800, 400);
        setContentPane(this);
        addButton(new Button(0, 740, 0, 60, 30));
        addButton(new Button(1, 680, 0, 60, 30));
        addButton(new Button(2, 620, 0, 60, 30));
    }

    public void paintComponent(Graphics g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), (int) this.getFrame().getSize().getHeight());
        //Top Bar
        g.setColor(ElectricTools.mode.getTopBarColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), 30);
        //Logo
        g.drawImage(ResourceLoader.getImage("logo.png"), 5, 5, 20, 20, null);
        //Buttons
        int frameSizeX = (int) this.getFrame().getSize().getWidth();
        for (Button button : this.getButtons()) {
            switch (button.getId()) {
                case 0:
                    button.setPosX(frameSizeX - 60);
                    if (button.isHover()) {
                        g.setColor(Color.RED);
                        g.fillRect(frameSizeX - 60, 0, 60, 30);
                    }
                    g.setColor(Color.WHITE);
                    g.drawLine(frameSizeX - 35, 10, frameSizeX - 25, 20);
                    g.drawLine(frameSizeX - 25, 10, frameSizeX - 35, 20);
                    break;
                case 1:
                    button.setPosX(frameSizeX - 120);
                    if (button.isHover()) {
                        g.setColor(Color.GRAY);
                        g.fillRect(frameSizeX - 120, 0, 60, 30);
                    }
                    g.setColor(Color.WHITE);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    if (this.getFrame().getSize().getHeight() == screenSize.getHeight() && this.getFrame().getSize().getWidth() == screenSize.getWidth())
                        g.drawRect(frameSizeX - 95, 10, 10, 10);
                    else
                        g.drawRect(frameSizeX - 95, 10, 10, 10);
                    break;
                case 2:
                    button.setPosX(frameSizeX - 180);
                    if (button.isHover()) {
                        g.setColor(Color.GRAY);
                        g.fillRect(frameSizeX - 180, 0, 60, 30);
                    }
                    g.setColor(Color.WHITE);
                    g.drawLine(frameSizeX - 155, 15, frameSizeX - 145, 15);
                    break;
            }
        }
    }

    public void buttonClicked(Button button, int mouseButton, int clickCount) {
        switch (button.getId()) {
            case 0:
                GuiUtilities.closeGui(this);
                break;
            case 1:
                if (this.isMaximized())
                    GuiUtilities.minimizeGui(this);
                else
                    GuiUtilities.maximizeGui(this);
                break;
            case 2:
                this.getFrame().setState(Frame.ICONIFIED);
                break;
        }
    }
}
