package main.fr.birdo.electrictools.events;

import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.GuiUtilities;

import javax.swing.*;
import java.awt.event.*;

public class GuiEvent implements MouseListener, MouseMotionListener, MouseWheelListener {

    private int posX;
    private int posY;

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < GuiUtilities.getEnableGuis().size(); i++) {
            Gui gui = GuiUtilities.getEnableGuis().get(i);
            JFrame frame = (JFrame) e.getComponent();
            if (frame.equals(gui.getFrame())) {
                for (Button button : gui.getButtons())
                    if (GuiUtilities.isButton(button, e.getX(), e.getY())) {
                        gui.buttonClicked(button, e.getButton(), e.getClickCount());
                        if (gui.getToolBar() != null && e.getY() <= gui.getToolBar().getSize())
                            gui.getToolBar().buttonClicked(button);
                    }
                if (gui.getToolBar() != null && e.getY() <= gui.getToolBar().getSize() && e.getClickCount() == 2)
                    if (gui.isMaximized())
                        GuiUtilities.minimizeGui(gui);
                    else
                        GuiUtilities.maximizeGui(gui);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for (int i = 0; i < GuiUtilities.getEnableGuis().size(); i++) {
            Gui gui = GuiUtilities.getEnableGuis().get(i);
            gui.setDragged(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for (int i = 0; i < GuiUtilities.getEnableGuis().size(); i++) {
            Gui gui = GuiUtilities.getEnableGuis().get(i);
            JFrame frame = (JFrame) e.getComponent();
            if (frame.equals(gui.getFrame())) {
                if (!gui.isDragged()) {
                    gui.setDragged(true);
                    this.posX = e.getX();
                    this.posY = e.getY();
                }
                if (gui.isMovable() && gui.getToolBar() != null && e.getY() <= gui.getToolBar().getSize() && !gui.isMaximized())
                    frame.setLocation(frame.getX() + (e.getX() - this.posX), frame.getY() + (e.getY() - this.posY));
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
