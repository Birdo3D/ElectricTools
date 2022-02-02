package main.fr.birdo.electrictools.utils;

import javax.swing.*;

public class Text {

    public static int getLength(String str) {
        JLabel jlabel = new JLabel(str);
        return jlabel.getFontMetrics(jlabel.getFont()).stringWidth(jlabel.getText());
    }
}
