package main.fr.birdo.electrictools.items;

import main.fr.birdo.electrictools.utils.ResourceLoader;

import java.awt.*;

public enum CircuitType {

    EMPTY(null),
    LIGHT(ResourceLoader.getImage("light.png")),
    SOCKET(ResourceLoader.getImage("socket.png"));

    final Image icon;

    CircuitType(Image icon) {
        this.icon = icon;
    }

    public Image getIcon() {
        return this.icon;
    }
}