package main.fr.birdo.electrictools.utils;

import java.awt.*;

public class ToolBar {

    private final int size;
    private final Gui gui;

    public ToolBar(Gui gui, int size) {
        this.size = size;
        this.gui = gui;
        gui.addButton(new Button(997, 740, 0, 60, size));
        gui.addButton(new Button(998, 680, 0, 60, size));
        gui.addButton(new Button(999, 620, 0, 60, size));
    }

    public void drawToolbar() {
        Graphics g = this.gui.getContentPane().getGraphics();
        //Logo
        g.drawImage(ResourceLoader.getImage("logo.png"), 5, 5, 20, 20, null);
        //Buttons
        int frameSizeX = (int) this.gui.getFrame().getSize().getWidth();
        for (Button button : this.gui.getButtons()) {
            switch (button.getId()) {
                case 997:
                    button.setPosX(frameSizeX - 60);
                    if (button.isHover()) {
                        g.setColor(Color.RED);
                        g.fillRect(frameSizeX - 60, 0, 60, 30);
                    }
                    g.setColor(Color.WHITE);
                    g.drawLine(frameSizeX - 35, 10, frameSizeX - 25, 20);
                    g.drawLine(frameSizeX - 25, 10, frameSizeX - 35, 20);
                    break;
                case 998:
                    button.setPosX(frameSizeX - 120);
                    if (button.isHover()) {
                        g.setColor(Color.GRAY);
                        g.fillRect(frameSizeX - 120, 0, 60, 30);
                    }
                    g.setColor(Color.WHITE);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    if (this.gui.getFrame().getSize().getHeight() == screenSize.getHeight() && this.gui.getFrame().getSize().getWidth() == screenSize.getWidth())
                        g.drawRect(frameSizeX - 95, 10, 10, 10);
                    else
                        g.drawRect(frameSizeX - 95, 10, 10, 10);
                    break;
                case 999:
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

    public int getSize() {
        return this.size;
    }

    public void buttonClicked(Button button) {
        switch (button.getId()) {
            case 997:
                GuiUtilities.closeGui(this.gui);
                break;
            case 998:
                if (this.gui.isMaximized())
                    GuiUtilities.minimizeGui(this.gui);
                else
                    GuiUtilities.maximizeGui(this.gui);
                break;
            case 999:
                this.gui.getFrame().setState(Frame.ICONIFIED);
                break;
        }
    }
}
