package fr.birdo.electrictools.event;

import fr.birdo.electrictools.gui.button.Button;
import fr.birdo.electrictools.util.Mode;
import fr.birdo.electrictools.gui.Pannel;

import java.awt.event.MouseListener;

public class MouseEvent implements MouseListener {

    public void mousePressed(java.awt.event.MouseEvent e) {
        for (Mode mode : Mode.values())
            if (mode == Pannel.getMode())
                for (Button button : Pannel.getGuiFromMode(Pannel.getMode()).getButtonList())
                    //System.out.println("x :" + button.getPosX() + " -- " + e.getX() + " -- " + (button.getPosX() + button.getSizeX()));
                    //System.out.println("y :" + button.getPosY() + " -- " + (e.getY() - 31) + " -- " + (button.getPosY() + button.getSizeY()));
                    if (e.getX() >= button.getPosX() && e.getX() <= (button.getPosX() + button.getSizeX()))
                        if ((e.getY() - 31) >= button.getPosY() && (e.getY() - 31) <= (button.getPosY() + button.getSizeY()))
                            Pannel.getGuiFromMode(Pannel.getMode()).onButtonClicked(button.getId());
    }

    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    public void mouseReleased(java.awt.event.MouseEvent e) {
    }

    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    public void mouseExited(java.awt.event.MouseEvent e) {
    }
}
