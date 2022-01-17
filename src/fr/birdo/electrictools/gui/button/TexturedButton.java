package fr.birdo.electrictools.gui.button;

import java.awt.image.BufferedImage;

public class TexturedButton extends Button {

    private final BufferedImage texture;

    public TexturedButton(int index, BufferedImage texture, int posX, int posY, int sizeX, int sizeY) {
        super(index, posX, posY, sizeX, sizeY);
        this.texture = texture;
    }

    public BufferedImage getTexture(){
        return this.texture;
    }
}