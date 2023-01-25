package main.fr.birdo.electrictools.utils;

import java.awt.*;

public class ScrollingMenuButton extends Button {

    private final String text;
    private final Image icon;

    public ScrollingMenuButton(int index, String text, Image icon) {
        super(index, 0, 0, 0, 0);
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return this.text;
    }

    public Image getIcon() {
        return this.icon;
    }
}
