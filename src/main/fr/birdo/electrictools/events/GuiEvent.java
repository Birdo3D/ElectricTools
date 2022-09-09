package main.fr.birdo.electrictools.events;

import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.GuiUtilities;

import javax.swing.*;
import java.awt.event.*;

public class GuiEvent implements MouseListener, MouseMotionListener, MouseWheelListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Gui gui : GuiUtilities.getEnableGuis()) {
            JFrame frame = (JFrame) e.getComponent();
            if (frame.equals(gui.getFrame()))
                for (Button button : gui.getButtons())
                    if (isButton(button, e.getX(), e.getY()))
                        gui.buttonClicked(button, e.getButton(), e.getClickCount());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for (Gui gui : GuiUtilities.getEnableGuis()) {
            JFrame frame = (JFrame) e.getComponent();
            if (frame.equals(gui.getFrame()))
                for (Button button : gui.getButtons())
                    gui.buttonIsHover(button, isButton(button, e.getX(), e.getY()));
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }

    private static boolean isButton(Button button, int x, int y) {
        return x > button.getPosX() && x < button.getPosX() + button.getSizeX() && y > button.getPosY() && y < button.getPosY() + button.getSizeY();
    }
}
