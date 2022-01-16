package fr.birdo.electrictools;

import javax.swing.*;

public class ElectricTools {

    static JFrame frame = new JFrame();
    static JPanel pannel = new Pannel();

    public static void main(String[] args)
    {
        frame.setSize(854, 480);
        frame.setTitle("ElectricTools");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(pannel);
        Ticking.tick();
    }

    public static void updateScreen(){
        frame.remove(pannel);
        frame.revalidate();
        frame.repaint();
    }
}