package fr.birdo.electrictools.event;

import fr.birdo.electrictools.gui.AdaptativeScreen;
import fr.birdo.electrictools.gui.Button;
import fr.birdo.electrictools.gui.Gui;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Objects;

public class MouseEvent implements MouseListener, MouseMotionListener {

    public void mousePressed(java.awt.event.MouseEvent e) {
        for (Button button : Objects.requireNonNull(Gui.getGui()).getButtons())
            if (isButton(button, e.getX(), e.getY()))
                Gui.getGui().onButtonClicked(button.getId());
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    public void mouseExited(java.awt.event.MouseEvent e) {
    }

    public void mouseDragged(java.awt.event.MouseEvent e) {
        //System.out.println("X : " + e.getX());
        //System.out.println("Y : " + e.getY());
    }

    public void mouseMoved(java.awt.event.MouseEvent e) {
        for (Button button : Objects.requireNonNull(Gui.getGui()).getButtons())
            button.setHover(isButton(button, e.getX(), e.getY()));
    }

    public boolean isButton(Button button, int x, int y) {
        return (x >= AdaptativeScreen.getWidth(button.getPosX()) && x <= (AdaptativeScreen.getWidth(button.getPosX()) + AdaptativeScreen.getWidth(button.getSizeX()))) && ((y - 31) >= AdaptativeScreen.getHeight(button.getPosY()) && (y - 31) <= (AdaptativeScreen.getHeight(button.getPosY()) + AdaptativeScreen.getHeight(button.getSizeY())));
    }
}