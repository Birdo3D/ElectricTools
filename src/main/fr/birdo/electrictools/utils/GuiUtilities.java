package main.fr.birdo.electrictools.utils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GuiUtilities {

    private static final List<Gui> enableGuis = new ArrayList<>();

    public static void openGui(Gui gui) {
        enableGuis.add(gui);
        gui.setFrame();
    }

    public static void closeGui(Gui gui) {
        enableGuis.remove(gui);
        gui.getFrame().dispose();
    }

    public static void updateGui(Gui gui) {
        Point p = MouseInfo.getPointerInfo().getLocation();
        for (Button button : gui.getButtons())
            button.setHover(isButton(button, (int) p.getX(), (int) p.getY()));
        gui.getFrame().remove(gui.getContentPane());
        gui.getFrame().revalidate();
        gui.getFrame().repaint();
    }

    public static List<Gui> getEnableGuis() {
        return enableGuis;
    }

    public static void maximizeGui(Gui gui) {
        gui.setSize((int) gui.getFrame().getSize().getWidth(), (int) gui.getFrame().getSize().getHeight());
        gui.setPosition((int) gui.getFrame().getLocation().getX(), (int) gui.getFrame().getLocation().getY());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice screenDevice = graphicsEnvironment.getDefaultScreenDevice();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(screenDevice.getDefaultConfiguration());
        int sizeX = (int) screenSize.getWidth();
        int sizeY = (int) screenSize.getHeight();
        int posX = 0;
        int posY = 0;
        if (insets.top > 0) {
            posY = posY + insets.top;
            sizeY = sizeY - insets.top;
        } else if (insets.left > 0) {
            posX = posX + insets.left;
            sizeX = sizeX - insets.left;
        } else if (insets.right > 0)
            sizeX = sizeX - insets.right;
        else if (insets.bottom > 0)
            sizeY = sizeY - insets.bottom;
        gui.getFrame().setSize(sizeX, sizeY);
        gui.getFrame().setLocation(posX, posY);
        gui.maximizeGui(true);
    }

    public static void minimizeGui(Gui gui) {
        gui.getFrame().setSize(gui.getSizeX(), gui.getSizeY());
        gui.getFrame().setLocation(gui.getPosX(), gui.getPosY());
        gui.maximizeGui(false);
    }

    public static boolean isButton(Button button, int x, int y) {
        return x > button.getPosX() && x < button.getPosX() + button.getSizeX() && y > button.getPosY() && y < button.getPosY() + button.getSizeY();
    }
}