package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.components.Components;
import main.fr.birdo.electrictools.utils.AdaptativeScreen;
import main.fr.birdo.electrictools.utils.Button;
import main.fr.birdo.electrictools.utils.ComponentGeneric;
import main.fr.birdo.electrictools.utils.GuiGeneric;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuiDiagrams extends GuiGeneric {

    private final List<main.fr.birdo.electrictools.utils.Button> buttons = new ArrayList<>();
    private static int zoomValue = 0;

    public GuiDiagrams() {
        //Buttons Panel 1 (Mode selector)
        buttons.add(new main.fr.birdo.electrictools.utils.Button(0, ElectricTools.getResource("btn.png"), 102, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        buttons.add(new main.fr.birdo.electrictools.utils.Button(-1, ElectricTools.getResource("btn.png"), 373, 12, 198, 27).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        //Buttons Panel 2
        buttons.add(new main.fr.birdo.electrictools.utils.Button(1, ElectricTools.getResource("b.png"), 31, 69, 90, 54).setHoverTexture(ElectricTools.getResource("b.hover.png")));
        buttons.add(new main.fr.birdo.electrictools.utils.Button(2, ElectricTools.getResource("b.png"), 178, 69, 90, 54).setHoverTexture(ElectricTools.getResource("b.hover.png")));
    }

    public static void drawScreen(Graphics graphics) {
        //Grid
        int rectSize = AdaptativeScreen.get(Gui.width + Gui.height, Gui.frame.getWidth() + Gui.frame.getHeight(), 20 + zoomValue);
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < 25; i++) {//Horizontal
            graphics.drawLine(AdaptativeScreen.getWidth(270), AdaptativeScreen.getHeight(154) + (i * rectSize), AdaptativeScreen.getWidth(1218), AdaptativeScreen.getHeight(154) + (i * rectSize));
        }
        for (int i = 0; i < 48; i++) {//Vertical
            graphics.drawLine(AdaptativeScreen.getWidth(278) + (i * rectSize), AdaptativeScreen.getHeight(146), AdaptativeScreen.getWidth(278) + (i * rectSize), AdaptativeScreen.getHeight(682));
        }
        //Components List
        int i = 0;
        int j = 0;
        for (Components.Category category : Components.Category.values()) {
            graphics.setColor(Color.ORANGE);
            graphics.drawString(category.getName() + " :", AdaptativeScreen.getWidth(20), AdaptativeScreen.getHeight(170) + ((i + j) * 20));
            j++;
            for (ComponentGeneric componentGeneric : Components.getComponents()) {
                if (componentGeneric.getCategory() == category) {
                    graphics.setColor(Color.PINK);
                    graphics.drawString("- " + componentGeneric.getName(), AdaptativeScreen.getWidth(40), AdaptativeScreen.getHeight(170) + ((i + 1) * 20));
                    i++;
                }
            }
        }
    }

    public static void setGridZoomValue(int zoom) {
        if (zoom >= 0 && zoom <= 40)
            zoomValue = zoom;
    }

    public static Integer getGridZoomValue() {
        return zoomValue;
    }

    public static boolean isGrid(int x, int y) {
        return (x >= AdaptativeScreen.getWidth(270)) && (x <= AdaptativeScreen.getWidth(1218)) && (y >= AdaptativeScreen.getHeight(146)) && (y <= AdaptativeScreen.getHeight(682));
    }

    public static void addElementOnGrid(ComponentGeneric component, int x, int y) {
    }

    public java.util.List<Button> getButtons() {
        return this.buttons;
    }

    public void onButtonClicked(int buttonIndex) {
        switch (buttonIndex) {
            case -1:
                Gui.setMode(Gui.Mode.TEST);
                for (Button button : Objects.requireNonNull(Gui.getGui()).getButtons())
                    button.setHover(button.getId() == 0);
                break;
            case 1:
                setGridZoomValue(getGridZoomValue() - 4);
                break;
            case 2:
                setGridZoomValue(getGridZoomValue() + 4);
                break;
        }
    }
}