package main.fr.birdo.electrictools.utils;

public class ElectricalTerminalGeneric {

    private final int name;
    private final int posX;
    private final int posY;

    public ElectricalTerminalGeneric(int name, int posX, int posY) {
        this.name = name;
        this.posX = posX;
        this.posY = posY;
    }

    public Integer getName() {
        return this.name;
    }

    public Integer getPosX() {
        return this.posX;
    }

    public Integer getPosY() {
        return this.posY;
    }
}
