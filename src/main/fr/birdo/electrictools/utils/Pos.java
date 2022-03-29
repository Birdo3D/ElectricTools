package main.fr.birdo.electrictools.utils;

public class Pos {

    private final ComponentGeneric component;
    private final int x;
    private final int y;

    public Pos(ComponentGeneric component, int x, int y){
        this.component = component;
        this.x = x;
        this.y = y;
    }

    public ComponentGeneric getComponent(){
        return this.component;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
