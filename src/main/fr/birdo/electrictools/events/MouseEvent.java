package main.fr.birdo.electrictools.events;

import main.fr.birdo.electrictools.guis.GuiDiagrams;
import main.fr.birdo.electrictools.utils.AdaptativeScreen;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.guis.Gui;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Objects;

public class MouseEvent implements MouseListener, MouseMotionListener, MouseWheelListener {

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

    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            GuiDiagrams.setGridZoomValue(GuiDiagrams.getGridZoomValue() + 1);
        } else {
            GuiDiagrams.setGridZoomValue(GuiDiagrams.getGridZoomValue() - 1);
        }
    }

    public boolean isButton(Button button, int x, int y) {
        return (x >= AdaptativeScreen.getWidth(button.getPosX()) && x <= (AdaptativeScreen.getWidth(button.getPosX()) + AdaptativeScreen.getWidth(button.getSizeX()))) && ((y - 31) >= AdaptativeScreen.getHeight(button.getPosY()) && (y - 31) <= (AdaptativeScreen.getHeight(button.getPosY()) + AdaptativeScreen.getHeight(button.getSizeY())));
    }
}