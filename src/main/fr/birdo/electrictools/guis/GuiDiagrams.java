package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.components.Components;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import java.awt.*;
import java.util.*;
import java.util.List;

public class GuiDiagrams extends GuiGeneric {

    private final Map<Integer, Button> buttonMap = new HashMap<>();
    private final Map<Integer, Button> buttonMapSave = new HashMap<>();
    private static int xMousePos;
    private static int yMousePos;
    private static boolean electrical = true;
    private static int zoomValue = 0;
    public static List<Pos> componentsOnGrid = new ArrayList<>();
    public static ComponentGeneric cursor = null;
    private static boolean clicked;

    public GuiDiagrams() {
        //Buttons Panel 1 (Mode selector)
        buttonMap.put(0, new main.fr.birdo.electrictools.utils.Button(0, "Schémas", 102, 12, 198, 27).setTexture(ElectricTools.getResource("btn.png")).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        buttonMap.put(-1, new main.fr.birdo.electrictools.utils.Button(-1, "Test", 373, 12, 198, 27).setTexture(ElectricTools.getResource("btn.png")).setHoverTexture(ElectricTools.getResource("btn.hover.png")));
        //Buttons Panel 2
        buttonMap.put(1, new main.fr.birdo.electrictools.utils.Button(1, "-", 31, 69, 90, 54).setTexture(ElectricTools.getResource("b.png")).setHoverTexture(ElectricTools.getResource("b.hover.png")).setTextColor(Color.BLUE));
        buttonMap.put(2, new main.fr.birdo.electrictools.utils.Button(2, "+", 178, 69, 90, 54).setTexture(ElectricTools.getResource("b.png")).setHoverTexture(ElectricTools.getResource("b.hover.png")).setTextColor(Color.BLUE));
        //Components List
        int k = 0;
        int j = 0;
        for (Components.Category category : Components.Category.values()) {
            buttonMap.put(j + 3, new main.fr.birdo.electrictools.utils.Button(j + 3, category.getName() + " :", 20, 170, Text.getLength(category.getName() + " :"), 10).setTextColor(Color.ORANGE).setPosModifier(0, ((k + j) * 20)).setTextCenter(false).setResizable(false));
            j++;
            for (ComponentGeneric componentGeneric : Components.getComponents()) {
                if (componentGeneric.getCategory() == category) {
                    buttonMap.put(k + 101, new main.fr.birdo.electrictools.utils.Button(k + 101, "- " + componentGeneric.getName(), 40, 170, Text.getLength("- " + componentGeneric.getName()), 10).setTextColor(Color.PINK).setPosModifier(0, ((k + 1) * 20)).setTextCenter(false).setResizable(false));
                    k++;
                }
            }
        }
        buttonMapSave.putAll(buttonMap);
    }

    public static void drawScreen(Graphics graphics) {
        //Cursor
        if (cursor != null)
            graphics.drawImage(cursor.getTexture(), xMousePos - cursor.getTexture().getWidth() / 2 - 8, yMousePos - cursor.getTexture().getHeight() / 2 - 31, null);
        //Grid
        int rectSize = AdaptativeScreen.get(Gui.width + Gui.height, Gui.frame.getWidth() + Gui.frame.getHeight(), 20 + zoomValue);
        graphics.setColor(Color.GRAY);
        for (int i = 0; i < AdaptativeScreen.getHeight(25); i++) {//Horizontal 25
            graphics.drawLine(AdaptativeScreen.getWidth(270), AdaptativeScreen.getHeight(154) + (i * rectSize), AdaptativeScreen.getWidth(1218), AdaptativeScreen.getHeight(154) + (i * rectSize));
        }
        for (int i = 0; i < AdaptativeScreen.getWidth(48); i++) {//Vertical 48
            graphics.drawLine(AdaptativeScreen.getWidth(278) + (i * rectSize), AdaptativeScreen.getHeight(146), AdaptativeScreen.getWidth(278) + (i * rectSize), AdaptativeScreen.getHeight(682));
        }
        System.out.println(zoomValue);
        //Elements
        for (Pos pos : componentsOnGrid)
            graphics.drawImage(pos.getComponent().getTexture(), getGridX(pos.getX()), getGridY(pos.getY()), getX(pos.getComponent().getTexture().getWidth()), getY(pos.getComponent().getTexture().getHeight()), null);
    }

    public static void setGridZoomValue(float zoomIn) {
        if (zoomIn >= 0 && zoomIn <= 40)
            zoomValue = Math.round(zoomIn);
    }

    public static void setCursor(int x, int y) {
        xMousePos = x;
        yMousePos = y;
    }

    public static void setClicked(boolean b) {
        clicked = b;
    }

    public static float getGridZoomValue() {
        return zoomValue;
    }

    public static boolean isGrid(int x, int y) {
        return (x >= AdaptativeScreen.getWidth(270)) && (x <= AdaptativeScreen.getWidth(1218)) && (y >= AdaptativeScreen.getHeight(146)) && (y <= AdaptativeScreen.getHeight(682));
    }

    public static void setComponentOnCursor(ComponentGeneric component) {
        cursor = component;
    }

    public java.util.List<Button> getButtons() {
        return new ArrayList<>(buttonMap.values());
    }

    public static int getPerCent() {
        return Math.round((float) zoomValue / 40 * 100);
    }

    public static int getX(int x) {
        return x * getPerCent() / 100;
    }

    public static int getY(int y) {
        return y * getPerCent() / 100;
    }

    public static int setGridX(int x) {
        return (x - 270) / (zoomValue + 20);
    }

    public static int getGridX(int x) {
        return x * (zoomValue + 20) + 270;
    }

    public static int setGridY(int y) {
        return (y - 146) / (zoomValue + 20);
    }

    public static int getGridY(int y) {
        return y * (zoomValue + 20) + 146;
    }

    public static void drawLine(Graphics graphics, int posX, int posY, int length, int thickness, boolean horizontal) {
        if (horizontal)
            graphics.fillRect(posX, posY, length, thickness);
        else
            graphics.fillRect(posX, posY, thickness, length);
    }

    public void onButtonClicked(int buttonIndex, int mouseButton, int clickCount) {
        switch (buttonIndex) {
            case -1://Button GuiTest
                Gui.test = !Gui.test;
                //Gui.setMode(Gui.Mode.TEST);
                for (Button button : Objects.requireNonNull(Gui.getGui()).getButtons())
                    button.setHover(button.getId() == 0);
                break;
            case 1://Button Zoom -
                setGridZoomValue(getGridZoomValue() - 4);
                break;
            case 2://Button Zoom +
                setGridZoomValue(getGridZoomValue() + 4);
                break;
            case 3:
                if (mouseButton == 1 && clickCount == 2)
                    if (electrical) {
                        buttonMap.remove(101);
                        buttonMap.remove(102);
                        electrical = false;
                    } else {
                        buttonMap.put(101, buttonMapSave.get(101));
                        buttonMap.put(102, buttonMapSave.get(102));
                        electrical = true;
                    }
                break;
            case 101://Buttons Components > 100
                setComponentOnCursor(Components.getComponents().get(1));
                break;
        }
    }
}