package main.fr.birdo.electrictools.utils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {

    private BufferedImage texture;
    private BufferedImage hoverTexture;
    private final String text;
    private boolean centerText = true;
    private Color textColor;
    private final int index;
    private final int posX;
    private final int posY;
    private int posXModifier = 0;
    private int posYModifier = 0;
    private final int sizeX;
    private final int sizeY;
    private boolean isHover;

    public Button(int index, String text, int posX, int posY, int sizeX, int sizeY) {
        this.index = index;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.text = text;
    }

    public void setHover(boolean hover) {
        this.isHover = hover;
    }

    public Button setTextColor(Color color) {
        this.textColor = color;
        return this;
    }

    public Button setTextCenter(boolean center) {
        this.centerText = center;
        return this;
    }

    public boolean isCenterText() {
        return this.centerText;
    }

    public Button setPosModifier(int x, int y) {
        this.posXModifier = x;
        this.posYModifier = y;
        return this;
    }

    public int getPosXModifier() {
        return this.posXModifier;
    }

    public int getPosYModifier() {
        return this.posYModifier;
    }

    public Color getTextColor() {
        return this.textColor;
    }

    public Boolean isHover() {
        return this.isHover;
    }

    public BufferedImage getTexture() {
        return this.texture;
    }

    public BufferedImage getHoverTexture() {
        return this.hoverTexture;
    }

    public String getText() {
        return this.text;
    }

    public Boolean hasTexture() {
        return this.texture != null;
    }

    public Boolean hasText() {
        return this.text != null;
    }

    public Boolean hasTextColor() {
        return this.textColor != null;
    }

    public Button setTexture(BufferedImage texture) {
        this.texture = texture;
        this.hoverTexture = texture;
        return this;
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