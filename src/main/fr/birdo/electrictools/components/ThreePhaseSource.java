package main.fr.birdo.electrictools.components;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.ComponentGeneric;

public class ThreePhaseSource extends ComponentGeneric {

    public ThreePhaseSource() {
        super("Source triphasée", Components.Category.ELECTRIC, 1, ElectricTools.getResource("test.png"));
    }
}