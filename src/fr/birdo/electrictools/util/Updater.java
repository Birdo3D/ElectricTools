package fr.birdo.electrictools.util;

import fr.birdo.electrictools.ElectricTools;

public class Updater {

    private static int updatePerSecond = 60;

    public static void tick(){
        while (true){
            try {
                Thread.sleep(1000/updatePerSecond);
                //Class to tick
                ElectricTools.updateScreen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
