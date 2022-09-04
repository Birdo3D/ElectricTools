package main.fr.birdo.electrictools.utils;

import java.util.ArrayList;
import java.util.List;

public class GuiUtilities {

    private static final List<Gui> enableGuis = new ArrayList<>();

    public static void openGui(Gui gui) {
        gui.setFrame();
        enableGuis.add(gui);
    }

    public static void closeGui(Gui gui) {
        gui.getFrame().dispose();
        enableGuis.remove(gui);
    }

    public static void updateGui(Gui gui) {
        gui.getFrame().remove(gui.getContentPane());
        gui.getFrame().revalidate();
        gui.getFrame().repaint();
    }

    public static List<Gui> getEnableGuis() {
        return enableGuis;
    }

    public boolean isButton(Button button, int x, int y) {
        int posX = AdaptativeScreen.getWidth(button.getPosX()) + button.getPosXModifier();
        int posY = AdaptativeScreen.getWidth(button.getPosY()) + button.getPosYModifier();
        int sizeX = button.getSizeX();
        int sizeY = button.getSizeY();
        if (button.isResizable()) {
            sizeX = AdaptativeScreen.getWidth(button.getSizeX());
            sizeY = AdaptativeScreen.getHeight(button.getSizeY());
        }
        return ((x - 8) >= posX && (x - 8) <= (posX + sizeX)) && ((y - 31) >= posY && (y - 31) <= (posY + sizeY));
    }
}