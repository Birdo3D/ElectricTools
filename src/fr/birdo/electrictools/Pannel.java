package fr.birdo.electrictools;

import javax.swing.*;
import java.awt.*;

public class Pannel extends JPanel {

    int i = 0;

    public void paintComponent(Graphics g){
        g.drawString(String.valueOf(i), 10, 20);
        i++;
    }
}