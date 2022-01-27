package main.fr.birdo.electrictools.utils;

import java.awt.image.BufferedImage;

public class Button {

    private final BufferedImage texture;
    private BufferedImage hoverTexture;
    private final int index;
    private final int posX;
    private final int posY;
    private final int sizeX;
    private final int sizeY;
    private boolean isHover;

    public Button(int index, BufferedImage texture, int posX, int posY, int sizeX, int sizeY) {
        this.index = index;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.texture = texture;
        this.hoverTexture = texture;
    }

    public void setHover(boolean hover) {
        this.isHover = hover;
    }

    public Boolean isHover(){
        return this.isHover;
    }

    public BufferedImage getTexture() {
        return this.texture;
    }

    public BufferedImage getHoverTexture() {
        return this.hoverTexture;
    }

    public Button setHoverTexture(BufferedImage texture) {
        this.hoverTexture = texture;
        return this;
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
}