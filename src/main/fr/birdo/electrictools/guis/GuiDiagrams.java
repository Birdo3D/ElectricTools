package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.components.Components;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GuiDiagrams extends GuiGeneric {

    private static final List<main.fr.birdo.electrictools.utils.Button> buttons = new ArrayList<>();
    private static int zoomValue = 0;

    public GuiDiagrams() {
        //Buttons Panel 1 (Mode selector)
        buttons.add(new main.fr.birdo.electrictools.utils.Button(0, "Schémas", 102, 12, 198, 27).setTexture(ElectricTools.getResource("btn.png")).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        buttons.add(new main.fr.birdo.electrictools.utils.Button(-1, "Test", 373, 12, 198, 27).setTexture(ElectricTools.getResource("btn.png")).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        //Buttons Panel 2
        buttons.add(new main.fr.birdo.electrictools.utils.Button(1, "-", 31, 69, 90, 54).setTexture(ElectricTools.getResource("b.png")).setHoverTexture(ElectricTools.getResource("b.hover.png")).setTextColor(Color.BLUE));
        buttons.add(new main.fr.birdo.electrictools.utils.Button(2, "+", 178, 69, 90, 54).setTexture(ElectricTools.getResource("b.png")).setHoverTexture(ElectricTools.getResource("b.hover.png")).setTextColor(Color.BLUE));
        //Components List
        int k = 0;
        int j = 0;
        for (Components.Category category : Components.Category.values()) {
            buttons.add(new main.fr.birdo.electrictools.utils.Button(k + j + 4, category.getName() + " :", 20, 170, Text.getLength(category.getName() + " :"), 10).setTextColor(Color.ORANGE).setPosModifier(0, ((k + j) * 20)).setTextCenter(false).setResizable(false));
            j++;
            for (ComponentGeneric componentGeneric : Components.getComponents()) {
                if (componentGeneric.getCategory() == category) {
                    buttons.add(new main.fr.birdo.electrictools.utils.Button(k + j + 4, "- " + componentGeneric.getName(), 40, 170, Text.getLength("- " + componentGeneric.getName()), 10).setTextColor(Color.PINK).setPosModifier(0, ((k + 1) * 20)).setTextCenter(false).setResizable(false));
                    k++;
                }
            }
        }
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
        System.out.println(buttonIndex);
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