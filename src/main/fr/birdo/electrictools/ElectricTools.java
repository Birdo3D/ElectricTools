package main.fr.birdo.electrictools;

import main.fr.birdo.electrictools.guis.Guis;
import main.fr.birdo.electrictools.utils.*;

import javax.swing.*;

public class ElectricTools extends JPanel {

    public static Mode mode = Mode.DARK_MODE;
    public static Translation.Languages language = Translation.Languages.GB_en;

    public static void main(String[] args) {
        Thread newThread = new Thread(ElectricTools::refresh);
        newThread.start();
        GuiUtilities.openGui(Guis.loadingGui);
        //Loading
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GuiUtilities.closeGui(Guis.loadingGui);
        GuiUtilities.openGui(Guis.startGui);
    }

    @SuppressWarnings("BusyWait")
    public static void refresh() {
        int stop = 0;
        while (true) {
            try {
                Thread.sleep(1000 / 30);
                if (GuiUtilities.getEnableGuis().isEmpty())
                    stop++;
                if (stop > 90)
                    System.exit(0);
                for (Gui gui : GuiUtilities.getEnableGuis())
                    if (gui != null && gui.getFrame() != null)
                        GuiUtilities.updateGui(gui);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}