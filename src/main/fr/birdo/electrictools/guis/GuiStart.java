package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import java.awt.*;

public class GuiStart extends Gui {

    public GuiStart() {
        super("gui_start", Translation.getTranslation("gui_start.title"), 800, 500);
        setContentPane(this);
        setToolbar(new ToolBar(this, 30));
        //New switchboard button
        addButton(new Button(0, 118, 313, 70, 70));
        //New project button
        addButton(new Button(1, 155, 140, 90, 90));
        //New diagram button
        addButton(new Button(2, 238, 313, 70, 70));
        //Open button
        addButton(new Button(3, 565, 313, 70, 70));
    }

    public void addComponent(Graphics2D g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), (int) this.getFrame().getSize().getHeight());
        //Top Bar
        getToolBar().drawToolbar();
        //Buttons
        for (Button button : this.getButtons()) {
            if (button.getId() >= 0 && button.getId() <= 3)
                if (button.isHover()) {
                    g.setColor(Color.BLACK);
                    g.fillRoundRect(button.getPosX() - 1, button.getPosY() - 1, button.getSizeX() + 2, button.getSizeY() + 2, 15, 15);
                }
            switch (button.getId()) {
                case 0:
                    g.setColor(Color.decode("#BDD143"));
                    break;
                case 1:
                    g.setColor(Color.decode("#7A1E72"));
                    break;
                case 2:
                    g.setColor(Color.decode("#009CB9"));
                    break;
                case 3:
                    g.setColor(Color.decode("#005CA5"));
                    break;
            }
            if (button.getId() >= 0 && button.getId() <= 3)
                g.fillRoundRect(button.getPosX(), button.getPosY(), button.getSizeX(), button.getSizeY(), 15, 15);
        }
        //Texts
        //new
        g.setColor(Color.BLACK);
        g.setFont(new Font(null, Font.PLAIN, 24));
        String text0 = Translation.getTranslation("gui_start.new");
        g.drawString(text0, 200 - ((int) GuiUtilities.getTextSize(g, text0).getWidth() / 2), 63);
        //recents
        String text1 = Translation.getTranslation("gui_start.recents");
        g.drawString(text1, 600 - ((int) GuiUtilities.getTextSize(g, text1).getWidth() / 2), 63);
        //new projects
        g.setFont(new Font(null, Font.PLAIN, 16));
        String text2 = Translation.getTranslation("gui_start.new_project");
        g.drawString(text2, 200 - ((int) GuiUtilities.getTextSize(g, text2).getWidth() / 2), 238);
        //new switchboard
        g.setFont(new Font(null, Font.PLAIN, 15));
        String text3 = Translation.getTranslation("gui_start.new_switchboard");
        g.drawString(text3, 153 - ((int) GuiUtilities.getTextSize(g, text3).getWidth() / 2), 397);
        //new diagram
        String text4 = Translation.getTranslation("gui_start.new_diagram");
        g.drawString(text4, 273 - ((int) GuiUtilities.getTextSize(g, text4).getWidth() / 2), 397);
        //open
        String text5 = Translation.getTranslation("gui_start.open");
        g.drawString(text5, 600 - ((int) GuiUtilities.getTextSize(g, text5).getWidth() / 2), 393);
        //Middle bar
        g.setColor(Color.decode("#D9D9D9"));
        g.fillRect(399, 45, 3, 435);
    }

    public void buttonClicked(Button button, int mouseButton, int clickCount) {
        switch (button.getId()) {
            case 0:
                GuiUtilities.closeGui(this);
                try {
                    Thread.sleep(1000 / 5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                GuiUtilities.openGui(Guis.switchboardGui);
                break;
        }
    }
}