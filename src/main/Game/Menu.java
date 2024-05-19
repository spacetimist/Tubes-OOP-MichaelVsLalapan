package main.Game;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Character;

import java.awt.*;
import java.util.List;

public class Menu<T extends Character> {
    private List<T> characterList;
    WindowPanel wp;
    Graphics2D g2;
    T character;
    public Menu(WindowPanel wp, List<T> characterList) {
        this.wp = wp;
        this.characterList = characterList;
    }

    public void drawList(Graphics2D g2) {
        this.g2 = g2;
        int x = 50;
        int y = 30;
        for (T character : characterList) {
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            g2.drawString(character.name, x, y);
            y += 20;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10F));
            g2.drawString(character.description, x, y);
            y += 25;
        }
    }

    public int centerX(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = wp.screenWidth/2 - length/2;
        return x;
    }
}
