package main.fr.birdo.electrictools.utils;

import main.fr.birdo.electrictools.ElectricTools;

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
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
        FontMetrics metrics = g.getFontMetrics(g.getFont());
        //Font
        g.setColor(ElectricTools.mode.getTopBarColor());
        g.fillRect(0, 0, (int) this.gui.getFrame().getSize().getWidth(), this.size);
        //Logo
        g.drawImage(ResourceLoader.getImage("logo.png"), 10, (this.size - 20) / 2, 20, 20, null);
        //Left Buttons
        int buttonX = 40;
        for (int i = 0; i < this.gui.getButtons().size(); i++) {
            for (Button button : this.gui.getButtons()) {
                if (button instanceof ToolbarButton) {
                    if (((ToolbarButton) button).getPosition() == i) {
                        if (buttonX == 40)
                            buttonX = 50;
                        button.setPosX(buttonX - 10);
                        button.setSizeX(metrics.stringWidth(((ToolbarButton) button).getText()) + 20);
                        button.setSizeY(this.size);
                        if (button.isHover())
                            for (Button button1 : this.gui.getButtons())
                                if (button1 instanceof ToolbarButton)
                                    if (((ToolbarButton) button1).isClicked()) {
                                        ((ToolbarButton) button1).setClicked(false);
                                        ((ToolbarButton) button).setClicked(true);
                                    }
                        if (((ToolbarButton) button).isClicked()) {
                            //Hover button
                            g.setColor(Color.CYAN);//Hover button color
                            g.fillRect(button.getPosX(), button.getPosY(), button.getSizeX(), button.getSizeY());
                            //Draw menu
                            g.setColor(ElectricTools.mode.getTopBarColor());//Button menu color
                            g.fillRect(button.getPosX(), button.getPosY() + button.getSizeY(), 300, ((ToolbarButton) button).getButtonInMenu().size() * 20);
                            for (int i1 = 0; i1 < ((ToolbarButton) button).getButtonInMenu().size(); i1++) {
                                ScrollingMenuButton smButton = ((ToolbarButton) button).getButtonInMenu().get(i1);
                                g.setColor(Color.CYAN);//Button hover color
                                smButton.setPosX(button.getPosX());
                                smButton.setPosY(button.getPosY() + button.getSizeY() + i1 * 20);
                                smButton.setSizeX(300);
                                smButton.setSizeY(20);
                                if (smButton.isHover())
                                    g.fillRect(button.getPosX(), button.getPosY() + button.getSizeY() + i1 * 20, 300, 20);
                                g.setColor(ElectricTools.mode.getBackgroundColor());//Button text color
                                g.drawString(smButton.getText(), button.getPosX() + 24, button.getPosY() + button.getSizeY() + metrics.getAscent() + i1 * 20);
                                if (smButton.getIcon() != null)
                                    g.drawImage(smButton.getIcon(), button.getPosX() + 4, button.getPosY() + button.getSizeY() + i1 * 20 + 2, 16, 16, null);
                            }
                        }
                        g.setColor(ElectricTools.mode.getBackgroundColor());//Buttons text color
                        g.drawString(((ToolbarButton) button).getText(), buttonX, metrics.getAscent() + (this.size - 20) / 2);
                        buttonX = buttonX + 20 + metrics.stringWidth(((ToolbarButton) button).getText());
                    }
                }
            }
        }
        //Title
        if (buttonX > 40)
            buttonX = buttonX + 20;
        g.setColor(ElectricTools.mode.getBackgroundColor());//Title text color
        g.drawString(this.gui.getTitle(), buttonX, metrics.getAscent() + (this.size - 20) / 2);
        //Right buttons
        int frameSizeX = (int) this.gui.getFrame().getSize().getWidth();
        for (Button button : this.gui.getButtons()) {
            switch (button.getId()) {
                case 997:
                    button.setPosX(frameSizeX - 60);
                    if (button.isHover()) {
                        g.setColor(Color.RED);
                        g.fillRect(frameSizeX - 60, 0, 60, this.size);
                    }
                    g.setColor(Color.WHITE);
                    g.drawLine(frameSizeX - 35, (this.size - 10) / 2, frameSizeX - 25, (this.size - 10) / 2 + 10);
                    g.drawLine(frameSizeX - 25, (this.size - 10) / 2, frameSizeX - 35, (this.size - 10) / 2 + 10);
                    break;
                case 998:
                    button.setPosX(frameSizeX - 120);
                    if (button.isHover()) {
                        g.setColor(Color.GRAY);
                        g.fillRect(frameSizeX - 120, 0, 60, this.size);
                    }
                    g.setColor(Color.WHITE);
                    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                    if (this.gui.getFrame().getSize().getHeight() == screenSize.getHeight() && this.gui.getFrame().getSize().getWidth() == screenSize.getWidth())
                        g.drawRect(frameSizeX - 95, (this.size - 10) / 2, 10, 10);
                    else
                        g.drawRect(frameSizeX - 95, (this.size - 10) / 2, 10, 10);
                    break;
                case 999:
                    button.setPosX(frameSizeX - 180);
                    if (button.isHover()) {
                        g.setColor(Color.GRAY);
                        g.fillRect(frameSizeX - 180, 0, 60, this.size);
                    }
                    g.setColor(Color.WHITE);
                    g.drawLine(frameSizeX - 155, this.size / 2, frameSizeX - 145, this.size / 2);
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
