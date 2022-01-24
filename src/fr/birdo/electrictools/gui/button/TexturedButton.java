package fr.birdo.electrictools.gui.button;

import fr.birdo.electrictools.ElectricTools;

import java.awt.image.BufferedImage;

public class TexturedButton extends Button {

    private final BufferedImage texture;
    private BufferedImage hoverTexture;
    private boolean isHover;

    public TexturedButton(int index, BufferedImage texture, int posX, int posY, int sizeX, int sizeY) {
        super(index, posX, posY, sizeX, sizeY);
        this.texture = texture;
    }

    public BufferedImage getTexture() {
        return this.texture;
    }

    public BufferedImage getHoverTexture() {
        return this.hoverTexture;
    }

    public TexturedButton setHoverTexture(BufferedImage texture) {
        this.hoverTexture = texture;
        return this;
    }

    public TexturedButton setHover(boolean hover) {
        this.isHover = hover;
        return this;
    }

    public boolean isHover() {
        return this.isHover;
    }
}