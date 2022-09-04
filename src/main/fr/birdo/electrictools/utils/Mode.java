package main.fr.birdo.electrictools.utils;

import java.awt.*;

public enum Mode {

    LIGHT_MODE(new Color(156, 156, 156), new Color(245, 245, 245)),
    DARK_MODE(new Color(100, 100, 100), new Color(66, 66, 66));

    final Color top_bar;
    final Color background;

    Mode(Color top_bar, Color background) {
        this.top_bar = top_bar;
        this.background = background;
    }

    public Color getTopBarColor() {
        return this.top_bar;
    }

    public Color getBackgroundColor() {
        return this.background;
    }
}