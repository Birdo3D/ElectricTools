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
        for (int i = 0; i < GuiUtilities.getEnableGuis().size(); i++) {
            Gui gui = GuiUtilities.getEnableGuis().get(i);
            JFrame frame = (JFrame) e.getComponent();
            if (frame.equals(gui.getFrame()))
                for (Button button : gui.getButtons())
                    if (GuiUtilities.isButton(button, e.getX(), e.getY()))
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

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
