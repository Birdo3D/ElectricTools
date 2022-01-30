package main.fr.birdo.electrictools.components;

import main.fr.birdo.electrictools.components.electrical.ElectricalSource1;
import main.fr.birdo.electrictools.components.electrical.ElectricalSource2;
import main.fr.birdo.electrictools.utils.AdaptativeScreen;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.ElectricalComponentGeneric;

import java.util.ArrayList;
import java.util.List;

public class Components {

    private static final List<ElectricalComponentGeneric> electricalComponents = new ArrayList<>();

    public static void initComponents(){
        addElectricalComponent(new ElectricalSource1());
        addElectricalComponent(new ElectricalSource2());
    }

    public static List<ElectricalComponentGeneric> getElectricalComponents(){
        return electricalComponents;
    }

    public static void addElectricalComponent(ElectricalComponentGeneric electricalComponentGeneric){
        electricalComponents.add(electricalComponentGeneric);
    }
}
