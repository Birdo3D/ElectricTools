package main.fr.birdo.electrictools.utils;

import main.fr.birdo.electrictools.guis.GuiStart;
import main.fr.birdo.electrictools.guis.Guis;

public class AdaptativeScreen {

    public static int get(int baseScreenHeight, int newScreenHeight, int baseTextureHeight) {
        return baseTextureHeight * newScreenHeight / baseScreenHeight;
    }

    public static int getWidth(int baseTextureWidth) {
        return baseTextureWidth * Guis.startGui.getFrame().getWidth() / Guis.startGui.getWidth();
    }

    public static int getHeight(int baseTextureHeight) {
        return baseTextureHeight * Guis.startGui.getFrame().getHeight() / Guis.startGui.getHeight();
    }
}