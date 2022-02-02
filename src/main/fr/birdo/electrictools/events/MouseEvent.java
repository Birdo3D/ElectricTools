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
                Gui.getGui().onButtonClicked(button.getId(), e.getButton(), e.getClickCount());
        if (Gui.getMode() == Gui.Mode.DIAGRAMS && GuiDiagrams.isGrid(e.getX(), e.getY()))
            switch (e.getButton()) {
                case 4:
                    GuiDiagrams.setGridZoomValue(GuiDiagrams.getGridZoomValue() - 4);
                    break;
                case 5:
                    GuiDiagrams.setGridZoomValue(GuiDiagrams.getGridZoomValue() + 4);
                    break;
            }
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
    }

    public void mouseMoved(java.awt.event.MouseEvent e) {
        for (Button button : Objects.requireNonNull(Gui.getGui()).getButtons())
            button.setHover(isButton(button, e.getX(), e.getY()));
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        //Grid zoom (for GuiDiagrams)
        if (Gui.getMode() == Gui.Mode.DIAGRAMS && GuiDiagrams.isGrid(e.getX(), e.getY()))
            if (e.getWheelRotation() < 0) {
                GuiDiagrams.setGridZoomValue(GuiDiagrams.getGridZoomValue() + 1);
            } else {
                GuiDiagrams.setGridZoomValue(GuiDiagrams.getGridZoomValue() - 1);
            }
    }

    public boolean isButton(Button button, int x, int y) {
        int posX = AdaptativeScreen.getWidth(button.getPosX()) + button.getPosXModifier();
        int posY = AdaptativeScreen.getWidth(button.getPosY()) + button.getPosYModifier();
        int sizeX = button.getSizeX();
        int sizeY = button.getSizeY();
        if (button.isResizable()) {
            sizeX = AdaptativeScreen.getWidth(button.getSizeX());
            sizeY = AdaptativeScreen.getHeight(button.getSizeY());
        }
        return (x >= posX && x <= (posX + sizeX)) && ((y - 31) >= posY && (y - 31) <= (posY + sizeY));
    }
}