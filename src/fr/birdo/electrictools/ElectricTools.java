package fr.birdo.electrictools;

import fr.birdo.electrictools.gui.Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ElectricTools extends JPanel {

    public static void main(String[] args) {
        Gui.initGui();
        updater();
    }

    public static void updater() {
        while (true){
            try {
                Thread.sleep(1000/30);
                //Code to tick
                Gui.frame.remove(Gui.contentPane);
                Gui.frame.revalidate();
                Gui.frame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static BufferedImage getResource(String resource) {
        try {
            return ImageIO.read(ElectricTools.class.getResourceAsStream("/fr/birdo/electrictools/ressources/" + resource));
        } catch (IOException e) {
            throw new IllegalArgumentException("Error - Resource Finder");
        }
    }
}