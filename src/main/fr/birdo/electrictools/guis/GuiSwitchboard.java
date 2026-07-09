package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.items.Breaker;
import main.fr.birdo.electrictools.items.CircuitType;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class GuiSwitchboard extends Gui {

    private Breaker[] breakers;

    public GuiSwitchboard() {
        super("gui_switchboard", "Untitled" + " - " + Translation.getTranslation("gui_switchboard.title"), 800, 400);
        setContentPane(this);
        ToolbarButton toolbarButton0 = new ToolbarButton(0, Translation.getTranslation(this.getLabel() + ".tb_button.file"), 0);
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9010, Translation.getTranslation(this.getLabel() + ".scrolling_button.new"), ResourceLoader.getImage("logo.png")));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9011, Translation.getTranslation(this.getLabel() + ".scrolling_button.open"), ResourceLoader.getImage("logo.png")));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9012, Translation.getTranslation(this.getLabel() + ".scrolling_button.close"), ResourceLoader.getImage("logo.png")));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9013, Translation.getTranslation(this.getLabel() + ".scrolling_button.save"), null));
        toolbarButton0.addScrollingButton(new ScrollingMenuButton(9014, Translation.getTranslation(this.getLabel() + ".scrolling_button.save_as"), null));
        addButton(toolbarButton0);
        addButton(new ToolbarButton(1, Translation.getTranslation(this.getLabel() + ".tb_button.edit"), 1));
        addButton(new ToolbarButton(2, Translation.getTranslation(this.getLabel() + ".tb_button.view"), 2));
        addButton(new ToolbarButton(3, Translation.getTranslation(this.getLabel() + ".tb_button.navigate"), 3));
        addButton(new ToolbarButton(4, Translation.getTranslation(this.getLabel() + ".tb_button.code"), 4));
        setToolbar(new ToolBar(this, 30));
    }

    public void addComponent(Graphics2D g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), (int) this.getFrame().getSize().getHeight());
        //Second Toolbar
        g.setColor(Color.decode("#C4C4C4"));
        g.fillRect(0, this.getToolBar().getSize(), this.getWidth(), 80);
        //Top Bar
        getToolBar().drawToolbar();
        //font board
        g.setColor(Color.decode("#ECECEC"));
        g.fillRoundRect(40, this.getToolBar().getSize() + 120, this.getWidth() - 80, this.getHeight() - this.getToolBar().getSize() - 160, 10, 10);
        //board
        g.setColor(Color.decode("#525252"));
        g.fillRoundRect(76, this.getToolBar().getSize() + 153, this.getWidth() - 142, 343, 10, 10);
        //circuits breakers
        for (int i = 0; i < 10; i++) {
            drawCircuitBreaker(g, 86 + 91 * i, this.getToolBar().getSize() + 259);
            drawCircuitIcon(g, 86 + 91 * i, this.getToolBar().getSize() + 165, CircuitType.SOCKET);
            drawTag(g, 86 + 91 * i, this.getToolBar().getSize() + 504, String.valueOf(i));
        }
        drawNewBreaker(g, this.getWidth() - 157, this.getToolBar().getSize() + 259);
    }

    public void buttonClicked(Button button, int mouseButton, int clickCount) {
        switch (button.getId()) {
            case 9012:
                GuiUtilities.closeGui(this);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                GuiUtilities.openGui(Guis.startGui);
                break;
        }
    }

    public void drawCircuitBreaker(Graphics g, int posX, int posY) {
        //background
        g.setColor(Color.decode("#E5E5E5"));
        g.fillRoundRect(posX, posY, 81, 225, 10, 10);

        //screws
        g.setColor(Color.decode("#B0B0B0"));
        g.fillOval(posX + 15, posY + 8, 18, 18); //left top hand corner
        g.fillOval(posX + 46, posY + 8, 18, 18); //right top hand corner
        g.fillOval(posX + 15, posY + 202, 18, 18); //left bottom hand corner
        g.fillOval(posX + 46, posY + 202, 18, 18); //right bottom hand corner
        g.setColor(Color.decode("#393939"));
        //left top hand corner
        g.fillRect(posX + 18, posY + 15, 12, 4);
        g.fillRect(posX + 22, posY + 11, 4, 12);
        //right top hand corner
        g.fillRect(posX + 49, posY + 15, 12, 4);
        g.fillRect(posX + 53, posY + 11, 4, 12);
        //left bottom hand corner
        g.fillRect(posX + 18, posY + 209, 12, 4);
        g.fillRect(posX + 22, posY + 205, 4, 12);
        //right bottom hand corner
        g.fillRect(posX + 49, posY + 209, 12, 4);
        g.fillRect(posX + 53, posY + 205, 4, 12);

        //switch
        g.setColor(Color.decode("#000000"));
        g.fillRect(posX + 25, posY + 59, 31, 38);
        g.setColor(Color.decode("#292929"));
        g.fillRoundRect(posX + 11, posY + 97, 59, 13, 2, 2);
        g.setColor(Color.decode("#28D24E"));
        g.fillRect(posX + 25, posY + 68, 31, 13);
    }

    public void drawNewBreaker(Graphics g, int posX, int posY) {
        //background
        g.setColor(Color.decode("#E5E5E5"));
        g.fillRoundRect(posX, posY, 81, 225, 10, 10);

        //add button
        g.setColor(Color.decode("#8D8D8D"));
        g.fillOval(posX + 15, posY + 87, 51, 51);
        //Cross
        g.setColor(Color.decode("#393939"));
        g.fillRect(posX + 25, posY + 110, 31, 7);
        g.fillRect(posX + 37, posY + 97, 7, 31);
    }

    public void drawCircuitIcon(Graphics g, int posX, int posY, CircuitType circuitType) {
        //border
        g.setColor(Color.decode("#C7C7C7"));
        g.fillRoundRect(posX, posY, 81, 81, 10, 10);

        //background
        g.setColor(Color.decode("#FFFFFF"));
        g.fillRoundRect(posX + 3, posY + 3, 75, 75, 10, 10);

        //icon
        if (circuitType != CircuitType.EMPTY) {
            g.drawImage(circuitType.getIcon(), posX + 16, posY + 16, 49, 49, null);
        }
    }

    public void drawTag(Graphics g, int posX, int posY, String tag) {
        //border
        g.setColor(Color.decode("#000000"));
        g.fillRoundRect(posX, posY, 81, 226, 5, 5);

        //background
        g.setColor(Color.decode("#FFFFFF"));
        g.fillRoundRect(posX + 1, posY + 1, 79, 224, 5, 5);

        //tag
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.decode("#000000"));
        Font font = new Font(null, Font.PLAIN, 10);
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.rotate(Math.toRadians(-90), 0, 0);
        Font rotatedFont = font.deriveFont(affineTransform);
        g2.setFont(rotatedFont);
        g2.drawString("Breaker " + tag, posX + 40, posY + 113);
        g2.dispose();
    }
}