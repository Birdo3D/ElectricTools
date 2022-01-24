package fr.birdo.electrictools.gui;

import fr.birdo.electrictools.ElectricTools;
import fr.birdo.electrictools.gui.button.Button;
import fr.birdo.electrictools.gui.button.TexturedButton;
import fr.birdo.electrictools.util.Mode;

import javax.swing.*;
import java.awt.*;

public class Pannel extends JPanel {

    private static Mode mode = Mode.DIAGRAMS;
    private static Graphics graphics;

    public void paintComponent(Graphics g) {
        graphics = g;
        //Background
        g.drawImage(ElectricTools.getResource("unknown.png"), 0, 0, AdaptativeScreen.get(ElectricTools.width, ElectricTools.frame.getWidth(), 1225) - 15, AdaptativeScreen.get(ElectricTools.height, ElectricTools.frame.getHeight() - 40, 687), this);
        getGuiFromMode(mode);
        drawButtons(mode);
    }

    public static void setMode(Mode modeIn) {
        mode = modeIn;
    }

    public static SimpleGui getGuiFromMode(Mode modeIn) {
        switch (modeIn) {
            case DIAGRAMS:
                return new GuiDiagrams(graphics);
            case TEST:
                return new GuiTest(graphics);
        }
        return null;
    }

    public static Mode getMode() {
        return mode;
    }

    private void drawButtons(Mode modeIn) {
        for (Button button : getGuiFromMode(modeIn).getButtonList()) {
            if (button instanceof TexturedButton) {
                //System.out.println("X : " + AdaptativeScreen.getHeight(ElectricTools.width, ElectricTools.frame.getWidth(), button.getSizeX()));
                //System.out.println("Y : " + AdaptativeScreen.getHeight(ElectricTools.height, ElectricTools.frame.getHeight(), button.getSizeY()));
                System.out.println(((TexturedButton) button).isHover());
                if (((TexturedButton) button).isHover())
                    graphics.drawImage(((TexturedButton) button).getHoverTexture(), AdaptativeScreen.getWidth(button.getPosX()), AdaptativeScreen.getHeight(button.getPosY()), AdaptativeScreen.getWidth(button.getSizeX()), AdaptativeScreen.getHeight(button.getSizeY()), null);
                else
                    graphics.drawImage(((TexturedButton) button).getTexture(), AdaptativeScreen.getWidth(button.getPosX()), AdaptativeScreen.getHeight(button.getPosY()), AdaptativeScreen.getWidth(button.getSizeX()), AdaptativeScreen.getHeight(button.getSizeY()), null);
            }
        }
    }
}