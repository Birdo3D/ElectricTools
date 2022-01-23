package fr.birdo.electrictools;

import fr.birdo.electrictools.event.MouseEvent;
import fr.birdo.electrictools.gui.*;
import fr.birdo.electrictools.util.Updater;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ElectricTools {

    public static final JFrame frame = new JFrame();
    private static final JPanel pannel = new Pannel();
    private static final String resourcePath = "/fr/birdo/electrictools/ressources/";
    public static final int width = 854;
    public static final int height = 480;

    public static void main(String[] args) {
        frame.addMouseListener(new MouseEvent());
        frame.addMouseMotionListener(new MouseEvent());
        frame.setSize(width, height);
        frame.setTitle("ElectricTools");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(pannel);
        Updater.tick();
    }

    public static void updateScreen() {
        frame.remove(pannel);
        frame.revalidate();
        frame.repaint();
    }

    public static BufferedImage getResource(String resource) {
        try {
            return ImageIO.read(ElectricTools.class.getResourceAsStream(resourcePath + resource));
        } catch (IOException e) {
            throw new IllegalArgumentException("Error 56");
        }
    }
}