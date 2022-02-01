package main.fr.birdo.electrictools.components;

import main.fr.birdo.electrictools.utils.ComponentGeneric;

import java.util.ArrayList;
import java.util.List;

public class Components {

    private static final List<ComponentGeneric> components = new ArrayList<>();

    public static void initComponents() {
        components.add(new SinglePhaseSource());
        components.add(new ThreePhaseSource());
    }

    public static List<ComponentGeneric> getComponents() {
        return components;
    }

    public enum Category {
        ELECTRIC("Electrical"),
        TEST("Test");

        private final String name;

        Category(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}