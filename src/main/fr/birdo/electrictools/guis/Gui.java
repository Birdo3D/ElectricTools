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
    }

    public void paintComponent(Graphics g) {
        //Initialize variables
        graphics = g;
        //Gui
        graphics.drawImage(ElectricTools.getResource("1.png"), 0, 0, frame.getWidth(), frame.getHeight(), null);
        switch (getMode()) {
            case DIAGRAMS:
                GuiDiagrams.drawScreen(g);
                break;
            case TEST:
                GuiTest.drawScreen(g);
                break;
        }
        //Background
        g.drawImage(ElectricTools.getResource("unknown3.png"), 0, 0, AdaptativeScreen.get(width, frame.getWidth(), 1225) - 15, AdaptativeScreen.get(height, frame.getHeight() - 40, 687), null);
        //Draw Buttons
        for (Button button : Objects.requireNonNull(getGui()).getButtons()) {
            Image buttonTexture = button.getTexture();
            if (button.isHover())
                buttonTexture = (button).getHoverTexture();
            graphics.drawImage(buttonTexture, AdaptativeScreen.getWidth(button.getPosX()), AdaptativeScreen.getHeight(button.getPosY()), AdaptativeScreen.getWidth(button.getSizeX()), AdaptativeScreen.getHeight(button.getSizeY()), null);
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

    enum Mode {
        DIAGRAMS,
        TEST
    }
}
