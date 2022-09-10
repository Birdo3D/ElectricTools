package main.fr.birdo.electrictools.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {

    private final int index;
    private int posX;
    private int posY;
    private final int sizeX;
    private final int sizeY;
    private boolean isHover;

    public Button(int index, int posX, int posY, int sizeX, int sizeY) {
        this.index = index;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public void setHover(boolean hover) {
        this.isHover = hover;
    }

    public Boolean isHover() {
        return this.isHover;
    }

    public int getId() {
        return this.index;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public Button setPosX(int posX) {
        this.posX = posX;
        return this;
    }

    public Button setPosY(int posY) {
        this.posY = posY;
        return this;
    }
}