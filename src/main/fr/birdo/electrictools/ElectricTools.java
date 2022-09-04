package main.fr.birdo.electrictools;

import main.fr.birdo.electrictools.guis.Guis;
import main.fr.birdo.electrictools.utils.GuiUtilities;
import main.fr.birdo.electrictools.utils.Mode;

import javax.swing.*;

public class ElectricTools extends JPanel {

    public static Mode mode = Mode.DARK_MODE;

    public static void main(String[] args) {
        GuiUtilities.openGui(Guis.startGui);
    }
}