package main.fr.birdo.electrictools;

import main.fr.birdo.electrictools.components.Components;
import main.fr.birdo.electrictools.guis.Gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class ElectricTools extends JPanel {

    public static void main(String[] args) {
        Components.initComponents();
        Gui.initGui();
        updater();
    }

    @SuppressWarnings({"InfiniteLoopStatement", "BusyWait", "deprecation"})
    public static void updater() {
        while (true) {
            try {
                Thread.sleep(1000 / 30);
                /* Code to tick */
                Gui.frame.remove(Gui.contentPane);
                Gui.frame.revalidate();
                Gui.frame.repaint();
                if (Gui.frame.getWidth() < Gui.width || Gui.frame.getHeight() < Gui.height) {
                    Gui.frame.resize(Gui.width, Gui.height);
                    Gui.frame.setLocationRelativeTo(null);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static BufferedImage getResource(String resource) {
        try {
            return ImageIO.read(Objects.requireNonNull(ElectricTools.class.getResourceAsStream("/main/resources/textures/" + resource)));
        } catch (IOException e) {
            throw new IllegalArgumentException("Error - Resource Finder");
        }
    }
}