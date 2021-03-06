package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.events.MouseEvent;
import main.fr.birdo.electrictools.utils.AdaptativeScreen;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.GuiGeneric;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Gui extends JPanel {

    public static final JFrame frame = new JFrame();
    public static final JPanel contentPane = new Gui();
    public static final int width = 1225;
    public static final int height = 685;
    private static Mode mode = Mode.DIAGRAMS;
    public static Graphics graphics;
    private static final GuiGeneric guiDiagrams = new GuiDiagrams();
    private static final GuiGeneric guiTest = new GuiTest();
    public static boolean test = true;

    public static void initGui() {
        frame.addMouseListener(new MouseEvent());
        frame.addMouseMotionListener(new MouseEvent());
        frame.addMouseWheelListener(new MouseEvent());
        frame.setSize(width, height);
        frame.setTitle("ElectricTools");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPane);
        frame.setMinimumSize(new Dimension(width, height));
    }

    public void paintComponent(Graphics g) {
        //Initialize variables
        graphics = g;
        //Gui
        graphics.drawImage(ElectricTools.getResource("1.png"), 0, 0, frame.getWidth(), frame.getHeight(), null);
        graphics.drawImage(ElectricTools.getResource("2.png"), AdaptativeScreen.getWidth(2), AdaptativeScreen.getHeight(150 - 8), AdaptativeScreen.getWidth(264), AdaptativeScreen.getHeight(686 - 8), null);
        switch (getMode()) {
            case DIAGRAMS:
                GuiDiagrams.drawScreen(g);
                break;
            case TEST:
                GuiTest.drawScreen(g);
                break;
        }
        //Background
        if (test)
            g.drawImage(ElectricTools.getResource("background.png"), 0, 0, AdaptativeScreen.getWidth(1225) - 15, AdaptativeScreen.get(height, frame.getHeight() - 40, 687), null);
        //Draw Buttons
        for (Button button : Objects.requireNonNull(getGui()).getButtons()) {
            int posX = AdaptativeScreen.getWidth(button.getPosX()) + button.getPosXModifier();
            int posY = AdaptativeScreen.getHeight(button.getPosY()) + button.getPosYModifier();
            if (button.hasTexture()) {
                Image buttonTexture = button.getTexture();
                int sizeX = button.getSizeX();
                int sizeY = button.getSizeY();
                if (button.isResizable()) {
                    sizeX = AdaptativeScreen.getWidth(button.getSizeX());
                    sizeY = AdaptativeScreen.getHeight(button.getSizeY());
                }
                if (button.isHover())
                    buttonTexture = (button).getHoverTexture();
                graphics.drawImage(buttonTexture, posX, posY, sizeX, sizeY, null);
            }
            if (button.hasText()) {
                JLabel jlabel = new JLabel(button.getText());
                int x = posX;
                int y = posY + 8;
                if (button.isCenterText()) {
                    x = posX + AdaptativeScreen.getWidth(button.getSizeX()) / 2 - jlabel.getFontMetrics(jlabel.getFont()).stringWidth(jlabel.getText()) / 2;
                    y = posY + AdaptativeScreen.getHeight(button.getSizeY()) / 2 + 8 - 4;
                }
                if (button.hasTextColor())
                    graphics.setColor(button.getTextColor());
                graphics.drawString(button.getText(), x, y);
            }
        }
    }

    public static void setMode(Mode modeIn) {
        mode = modeIn;
    }

    public static Mode getMode() {
        return mode;
    }

    public static GuiGeneric getGui() {
        switch (getMode()) {
            case DIAGRAMS:
                return guiDiagrams;
            case TEST:
                return guiTest;
        }
        return null;
    }

    public enum Mode {
        DIAGRAMS,
        TEST
    }
}
