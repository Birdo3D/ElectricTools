package fr.birdo.electrictools.gui;

import javax.swing.*;
import java.awt.*;

public class Pannel extends JPanel {

    private static Mode mode = Mode.DIAGRAMS;
    private static Graphics graphics;

    public void paintComponent(Graphics g) {
        graphics = g;
        switch (mode) {
            case DIAGRAMS:
                new GuiDiagrams(g);
        }
    }

    public static void setMode(Mode modeIn) {
        mode = modeIn;
    }

    public static SimpleGui getGuiFromMode(Mode modeIn) {
        switch (modeIn) {
            case DIAGRAMS:
                return new GuiDiagrams(graphics);
        }
        return null;
    }

    public static Mode getMode(){
        return mode;
    }
}