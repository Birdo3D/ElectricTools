package fr.birdo.electrictools.gui;

import fr.birdo.electrictools.ElectricTools;

public class AdaptativeScreen {

    public static int get(int baseScreenHeight, int newScreenHeight, int baseTextureHeight){
        return baseTextureHeight * newScreenHeight / baseScreenHeight;
    }

    public static int getWidth(int baseTextureWidth){
        return baseTextureWidth * Gui.frame.getWidth() / Gui.width;
    }

    public static int getHeight(int baseTextureHeight){
        return baseTextureHeight * Gui.frame.getHeight() / Gui.height;
    }
}