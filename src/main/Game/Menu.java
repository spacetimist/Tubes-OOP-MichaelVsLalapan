package main.Game;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Character;

import java.awt.*;
import java.util.List;

public class Menu<T extends Character> {
    private List<T> characterList;
    WindowPanel wp;
    Graphics2D g2;
    public Menu(WindowPanel wp, List<T> characterList) {
        this.wp = wp;
        this.characterList = characterList;
    }

    public void drawList(Graphics2D g2) {
        this.g2 = g2;
        int x = 60;
        int y = 60;
        for (T character : characterList) {
            g2.drawString(character.name, x, y);
            y += 20;
        }
    }
}
