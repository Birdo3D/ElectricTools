package main.fr.birdo.electrictools;

import main.fr.birdo.electrictools.guis.Guis;
import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.GuiUtilities;
import main.fr.birdo.electrictools.utils.Mode;

import javax.swing.*;
import java.awt.*;

public class ElectricTools extends JPanel {

    public static Mode mode = Mode.DARK_MODE;

    public static void main(String[] args) {
        GuiUtilities.openGui(Guis.startGui);
        refresh();
    }

    public static void refresh() {
        while (true) {
            try {
                Thread.sleep(1000 / 30);
                if (GuiUtilities.getEnableGuis().isEmpty())
                    System.exit(2410);
                for (Gui gui : GuiUtilities.getEnableGuis()) {
                    GuiUtilities.updateGui(gui);
                    if (gui.isMaximized()) {
                        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
                        if ((insets.top > 0 && gui.getPosY() < 0) &&
                                (insets.left > 0 && gui.getPosX() < 0) &&
                                (insets.right > 0 && gui.getPosX() == 0 && Toolkit.getDefaultToolkit().getScreenSize().getWidth() - gui.getSizeX() > 0) &&
                                (insets.bottom > 0 && gui.getPosY() == 0 && Toolkit.getDefaultToolkit().getScreenSize().getHeight() - gui.getSizeY() > 0))
                            GuiUtilities.maximizeGui(gui);
                    }
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}