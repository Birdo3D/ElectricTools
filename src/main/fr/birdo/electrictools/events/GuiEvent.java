package main.fr.birdo.electrictools.events;

import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.Gui;
import main.fr.birdo.electrictools.utils.GuiUtilities;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GuiEvent implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (Gui gui : GuiUtilities.getEnableGuis()) {
            gui.buttonClicked(null);
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
}
