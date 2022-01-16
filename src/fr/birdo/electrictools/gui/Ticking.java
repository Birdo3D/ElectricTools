package fr.birdo.electrictools.gui;

import fr.birdo.electrictools.ElectricTools;

public class Ticking {

    private static int ticksPerSecond = 20;

    public static void tick(){
        while (true){
            try {
                Thread.sleep(1000/ticksPerSecond);
                //Class to tick
                ElectricTools.updateScreen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
