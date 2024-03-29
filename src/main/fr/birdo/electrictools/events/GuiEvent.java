package main.fr.birdo.electrictools.events;

import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.GuiUtilities;
import main.fr.birdo.electrictools.utils.ToolbarButton;

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
        boolean isButton = false;
        for (int i = 0; i < GuiUtilities.getEnableGuis().size(); i++) {
            Gui gui = GuiUtilities.getEnableGuis().get(i);
            JFrame frame = (JFrame) e.getComponent();
            if (frame.equals(gui.getFrame())) {
                for (Button button : gui.getButtons()) {
                    if (GuiUtilities.isButton(button, e.getX(), e.getY())) {
                        if (button instanceof ToolbarButton)
                            ((ToolbarButton) button).setClicked(true);
                        gui.buttonClicked(button, e.getButton(), e.getClickCount());
                        if (gui.getToolBar() != null && e.getY() <= gui.getToolBar().getSize())
                            gui.getToolBar().buttonClicked(button);
                    } else if (button instanceof ToolbarButton)
                        ((ToolbarButton) button).setClicked(false);
                }
                for (Button button : gui.getButtons())
                    if (GuiUtilities.isButton(button, e.getX(), e.getY()))
                        isButton = true;
                if (gui.getToolBar() != null && e.getY() <= gui.getToolBar().getSize() && e.getClickCount() == 2 && !isButton)
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
        boolean isButton = false;
        for (int i = 0; i < GuiUtilities.getEnableGuis().size(); i++) {
            Gui gui = GuiUtilities.getEnableGuis().get(i);
            JFrame frame = (JFrame) e.getComponent();
            if (frame.equals(gui.getFrame())) {
                if (!gui.isDragged()) {
                    gui.setDragged(true);
                    this.posX = e.getX();
                    this.posY = e.getY();
                }
                for (Button button : gui.getButtons())
                    if (GuiUtilities.isButton(button, this.posX, this.posY))
                        isButton = true;
                if (gui.isMovable() && gui.getToolBar() != null && e.getY() <= gui.getToolBar().getSize() && !isButton) {
                    frame.setLocation(frame.getX() + (e.getX() - this.posX), frame.getY() + (e.getY() - this.posY));
                    if (gui.isMaximized())
                        gui.maximizeGui(false);
                }
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
