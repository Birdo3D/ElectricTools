package fr.birdo.electrictools.gui;

public enum Mode {

    DIAGRAMS(0);

    private int id;

    Mode(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}