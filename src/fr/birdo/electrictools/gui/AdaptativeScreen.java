package fr.birdo.electrictools.gui;

import fr.birdo.electrictools.ElectricTools;

public class AdaptativeScreen {

    public static int get(int baseScreenHeight, int newScreenHeight, int baseTextureHeight){
        return baseTextureHeight * newScreenHeight / baseScreenHeight;
    }

    public static int getWidth(int baseTextureWidth){
        return baseTextureWidth * ElectricTools.frame.getWidth() / ElectricTools.width;
    }

    public static int getHeight(int baseTextureHeight){
        return baseTextureHeight * ElectricTools.frame.getHeight() / ElectricTools.height;
    }
}