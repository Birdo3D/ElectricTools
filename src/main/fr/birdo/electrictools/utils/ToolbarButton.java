package main.fr.birdo.electrictools.utils;

import java.util.ArrayList;
import java.util.List;

public class ToolbarButton extends Button {

    private final String text;
    private final int position;
    private boolean isClicked;
    private List<ScrollingMenuButton> scrollingButtons = new ArrayList();

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

    public void addScrollingButton(ScrollingMenuButton button){
        this.scrollingButtons.add(button);
    }

    public List<ScrollingMenuButton> getButtonInMenu(){
        return this.scrollingButtons;
    }
}
