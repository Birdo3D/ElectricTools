package main.fr.birdo.electrictools.utils;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class ElectricalComponentGeneric {

    private final String name;
    private final int index;
    private final BufferedImage texture;
    private final List<ElectricalTerminalGeneric> terminals = new ArrayList<>();

    public ElectricalComponentGeneric(String name, int index, BufferedImage texture) {
        this.name = name;
        this.index = index;
        this.texture = texture;
    }

    public ElectricalComponentGeneric addTerminal(ElectricalTerminalGeneric terminal) {
        this.terminals.add(terminal);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Integer getId() {
        return this.index;
    }

    public BufferedImage getTexture() {
        return this.texture;
    }

    public List<ElectricalTerminalGeneric> getTerminals() {
        return this.terminals;
    }
}