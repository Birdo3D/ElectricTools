package main.fr.birdo.electrictools.components;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.ComponentGeneric;

public class SinglePhaseSource extends ComponentGeneric {

    public SinglePhaseSource() {
        super("Source monophasée", Components.Category.ELECTRIC, 0, ElectricTools.getResource("1.png"));
    }
}