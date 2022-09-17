package main.fr.birdo.electrictools.utils;

public class ToolbarButton extends Button {

    private final String text;
    private final int position;
    private boolean isClicked;

    public ToolbarButton(int index, String text, int position) {
        super(index, 0, 0, 0, 0);
        this.position = position;
        this.text = text;
    }

    public int getPosition() {
        return this.position;
    }

    public String getText() {
        return this.text;
    }

    public void setClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    public boolean isClicked() {
        return this.isClicked;
    }
}
