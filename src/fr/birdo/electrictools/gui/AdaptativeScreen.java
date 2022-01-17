package fr.birdo.electrictools.gui;

public class AdaptativeScreen {

    public static int getHeight(int baseScreenHeight, int newScreenHeight, int baseTextureHeight){
        return baseTextureHeight * newScreenHeight / baseScreenHeight;
    }
}//button.getSizeY()*ElectricTools.frame.getHeight()/480