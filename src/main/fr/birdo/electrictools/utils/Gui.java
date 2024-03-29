package main.fr.birdo.electrictools.utils;

import main.fr.birdo.electrictools.events.GuiEvent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Gui extends JPanel {

    private JFrame frame;
    private JPanel contentPane;
    private final String label;
    private final String title;
    private final int sizeX;
    private final int sizeY;
    private int posX = -1;
    private int posY = -1;
    private List<Button> buttons = new ArrayList<>();
    private boolean isMaximized;
    private boolean isDragged = false;
    private boolean isMovable = true;
    private ToolBar toolBar;

    public Gui(String label, String title, int sizeX, int sizeY) {
        this.label = label;
        this.title = title;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public Gui setPosition(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        return this;
    }

    public void setFrame() {
        this.frame = new JFrame();
        if (this.posX == -1 || this.posY == -1) {
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            this.posX = (screenSize.width - this.sizeX) / 2;
            this.posY = (screenSize.height - this.sizeY) / 2;
        }
        this.frame.setLocation(this.posX, this.posY);
        this.frame.setSize(this.getSizeX(), this.getSizeY());
        this.frame.setTitle(this.getTitle());
        this.frame.addMouseListener(new GuiEvent());
        this.frame.addMouseMotionListener(new GuiEvent());
        this.frame.addMouseWheelListener(new GuiEvent());
        this.frame.setIconImage(ResourceLoader.getImage("logo.png"));
        this.frame.setUndecorated(true);
        this.frame.setBackground(new Color(0, 0, 0, 0));
        this.frame.setContentPane(this.contentPane);
        this.frame.setVisible(true);
    }

    public String getLabel() {
        return this.label;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSizeX() {
        return this.sizeX;
    }

    public int getSizeY() {
        return this.sizeY;
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    public Gui setContentPane(JPanel contentPane) {
        this.contentPane = contentPane;
        return this;
    }

    public JPanel getContentPane() {
        return this.contentPane;
    }

    public Gui addButton(Button button) {
        this.buttons.add(button);
        if(button instanceof ToolbarButton)
            for (Button button1 : ((ToolbarButton) button).getButtonInMenu())
                this.addButton(button1);
        return this;
    }

    public Gui setToolbar(ToolBar toolBar) {
        this.toolBar = toolBar;
        return this;
    }

    public java.util.List<Button> getButtons() {
        return this.buttons;
    }

    public void buttonClicked(Button button, int mouseButton, int clickCount) {
    }

    public void maximizeGui(boolean isMaximized) {
        this.isMaximized = isMaximized;
    }

    public void setDragged(boolean isDragged) {
        this.isDragged = isDragged;
    }

    public Gui setMovable(boolean isMovable) {
        this.isMovable = isMovable;
        return this;
    }

    public boolean isMaximized() {
        return this.isMaximized;
    }

    public boolean isDragged() {
        return this.isDragged;
    }

    public boolean isMovable() {
        return this.isMovable;
    }

    public ToolBar getToolBar() {
        return this.toolBar;
    }
}