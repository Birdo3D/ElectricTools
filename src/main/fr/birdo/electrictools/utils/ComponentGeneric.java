package main.fr.birdo.electrictools.utils;

import main.fr.birdo.electrictools.components.Components;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ComponentGeneric {

    private final String name;
    private final Components.Category category;
    private final int index;
    private final BufferedImage texture;
    private final List<ComponentTerminalGeneric> terminals = new ArrayList<>();

    public ComponentGeneric(String name, Components.Category category, int index, BufferedImage texture) {
        this.name = name;
        this.category = category;
        this.index = index;
        this.texture = texture;
    }

    public ComponentGeneric addTerminal(ComponentTerminalGeneric terminal) {
        this.terminals.add(terminal);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Components.Category getCategory() {
        return this.category;
    }

    public Integer getId() {
        return this.index;
    }

    public BufferedImage getTexture() {
        return this.texture;
    }

    public List<ComponentTerminalGeneric> getTerminals() {
        return this.terminals;
    }
}