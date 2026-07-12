package main.fr.birdo.electrictools.guis;

import main.fr.birdo.electrictools.ElectricTools;
import main.fr.birdo.electrictools.utils.*;
import main.fr.birdo.electrictools.utils.Button;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

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
        //Recent project 1
        //Open button
        addButton(new Button(4, 423, 122, 260, 53));
        //remove button
        addButton(new Button(6, 698, 133, 28, 28));
        //directory button
        addButton(new Button(7, 732, 133, 32, 28));
        //Recent project 2
        addButton(new Button(5, 423, 194, 260, 53));
        //remove button
        addButton(new Button(8, 698, 205, 28, 28));
        //directory button
        addButton(new Button(9, 732, 205, 32, 28));
    }

    public void addComponent(Graphics2D g) {
        //Background
        g.setColor(ElectricTools.mode.getBackgroundColor());
        g.fillRect(0, 0, (int) this.getFrame().getSize().getWidth(), (int) this.getFrame().getSize().getHeight());
        //Top Bar
        getToolBar().drawToolbar();
        //Buttons
        for (Button button : this.getButtons()) {
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
            if (button.getId() >= 0 && button.getId() <= 3) {
                if (button.isHover())
                    g.fillRoundRect(button.getPosX() - 1, button.getPosY() - 1, button.getSizeX() + 2, button.getSizeY() + 2, 30, 30);
                if (button.getId() >= 0 && button.getId() <= 3) {
                    g.setColor(new Color(g.getColor().getRed(), g.getColor().getGreen(), g.getColor().getBlue(), 191)); //set transparency to 75%
                    g.fillRoundRect(button.getPosX(), button.getPosY(), button.getSizeX(), button.getSizeY(), 30, 30);
                    g.drawImage(ResourceLoader.getImage("gui_start_button_" + button.getId() + ".png"), button.getPosX(), button.getPosY(), button.getSizeX(), button.getSizeY(), null);
                }
            }
        }
        //Texts
        //new
        g.setColor(Color.BLACK);
        g.setFont(new Font("Rubik", Font.PLAIN, 24));
        String text0 = Translation.getTranslation("gui_start.new");
        g.drawString(text0, 200 - ((int) GuiUtilities.getTextSize(g, text0).getWidth() / 2), 91);
        //recents
        String text1 = Translation.getTranslation("gui_start.recents");
        g.drawString(text1, 600 - ((int) GuiUtilities.getTextSize(g, text1).getWidth() / 2), 91);
        //new projects
        g.setFont(new Font("Rubik", Font.PLAIN, 16));
        String text2 = Translation.getTranslation("gui_start.new_project");
        g.drawString(text2, 200 - ((int) GuiUtilities.getTextSize(g, text2).getWidth() / 2), 257);
        //open
        g.setFont(new Font("Rubik", Font.PLAIN, 15));
        String text5 = Translation.getTranslation("gui_start.open");
        g.drawString(text5, 600 - ((int) GuiUtilities.getTextSize(g, text5).getWidth() / 2), 411);
        //new switchboard
        g.setColor(Color.decode("#424242"));
        g.drawString(text0, 153 - ((int) GuiUtilities.getTextSize(g, text0).getWidth() / 2), 411);
        String text3 = Translation.getTranslation("gui_start.switchboard");
        g.drawString(text3, 153 - ((int) GuiUtilities.getTextSize(g, text3).getWidth() / 2), 411 + (int) GuiUtilities.getTextSize(g, text3).getHeight());
        //new diagram
        g.drawString(text0, 273 - ((int) GuiUtilities.getTextSize(g, text0).getWidth() / 2), 411);
        String text4 = Translation.getTranslation("gui_start.diagram");
        g.drawString(text4, 273 - ((int) GuiUtilities.getTextSize(g, text4).getWidth() / 2), 411 + (int) GuiUtilities.getTextSize(g, text4).getHeight());
        //Middle bar
        g.setColor(Color.decode("#D9D9D9"));
        g.fillRect(399, 45, 3, 435);
        //Recents projects
        List<String> recents = UserVars.getRecentsPath();
        if (recents.isEmpty()) {
            g.setColor(Color.decode("#424242"));
            g.drawString(Translation.getTranslation("gui_start.no_recents"), 423, 122);
        } else {
            for (int i = 0; i < recents.size() && i < 2; i++) {
                drawRecentFile(g, 423, 122 + i * 72, recents.get(recents.size() - i - 1), 4 + i);
            }
        }
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
            case 6:
                UserVars.removeRecentProject(UserVars.getRecentsPath().size() - 1);
                break;
            case 7:
                try {
                    Desktop.getDesktop().open(new File(UserVars.getRecentsPath().get(UserVars.getRecentsPath().size() - 1)).getParentFile());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            case 8:
                UserVars.removeRecentProject(UserVars.getRecentsPath().size() - 2);
                break;
            case 9:
                try {
                    Desktop.getDesktop().open(new File(UserVars.getRecentsPath().get(UserVars.getRecentsPath().size() - 2)).getParentFile());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    private void drawRecentFile(Graphics2D g, int x, int y, String path, int buttonIndex) {
        for (int i = 0; i < this.getButtons().size(); i++) {
            if (this.getButtons().get(i).getId() == buttonIndex) {
                if (this.getButtons().get(i).isHover()) {
                    g.setColor(Color.decode("#9C9C9C"));
                    g.fillRoundRect(x - 1, y - 1, 355, 55, 16, 16);
                } else {
                    g.setColor(Color.decode("#D9D9D9"));
                    g.fillRoundRect(x, y, 353, 53, 16, 16);
                }
            }
        }
        //draw title
        String fileName = Paths.get(path).getFileName().toString();
        String name = fileName.substring(0, fileName.indexOf("."));
        g.setColor(Color.BLACK);
        g.setFont(new Font("Rubik", Font.PLAIN, 18));
        g.drawString(name, x + 13, y + 5 + (int) GuiUtilities.getTextSize(g, name).getHeight());
        //draw path
        g.setColor(Color.decode("#424242"));
        g.setFont(new Font("Rubik", Font.PLAIN, 14));
        g.drawString(path, x + 13, y + 29 + (int) GuiUtilities.getTextSize(g, path).getHeight());
        //delete and explorer buttons
        for (Button button : this.getButtons()) {
            if (button.getId() >= 6 && button.getId() <= 9 && button.isHover()) {
                g.setColor(Color.decode("#9C9C9C"));
                g.fillRoundRect(button.getPosX(), button.getPosY(), button.getSizeX(), button.getSizeY(), 4, 4);
            }
        }
        g.drawImage(ResourceLoader.getImage("gui_start_button_recents.png"), x, y, 353, 53, null);
    }
}