package fr.birdo.electrictools.util;

public enum Mode {

    DIAGRAMS(0),
    TEST(1);

    private int id;

    Mode(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}