package fr.birdo.electrictools;

import fr.birdo.electrictools.gui.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ElectricTools {

    private static final JFrame frame = new JFrame();
    private static final JPanel pannel = new Pannel();
    private static final String resourcePath = "/fr/birdo/electrictools/ressources/";

    public static void main(String[] args) {
        frame.addMouseListener(new MouseEvent());
        frame.setSize(854, 480);
        frame.setTitle("ElectricTools");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(pannel);
        Ticking.tick();
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