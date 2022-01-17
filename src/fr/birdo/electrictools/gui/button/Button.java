package fr.birdo.electrictools.gui.button;

public class Button {

    private final int index;
    private final int posX;
    private final int posY;
    private final int sizeX;
    private final int sizeY;

    public Button(int index, int posX, int posY, int sizeX, int sizeY) {
        this.index = index;
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public int getId(){
        return this.index;
    }

    public int getPosX(){
        return this.posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public int getSizeX(){
        return this.sizeX;
    }

    public int getSizeY(){
        return this.sizeY;
    }
}