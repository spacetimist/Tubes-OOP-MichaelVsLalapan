package main.Game;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Character;
import main.Game.ParentClass.Plant;
import main.Game.ParentClass.Zombie;

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

    public void drawListPlant(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
        String text = "PLANTS LIST";
        int x = centerX(text);
        int y = 30;
        g2.drawString(text, x, y);
        y += 30;
        for (T character : characterList) {
            Plant plant = (Plant) character;
            x = 50;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            g2.drawString(character.name, x, y);
            y += 20;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10F));
            g2.drawString("Description: " + character.description, x, y);
            y += 20;
            g2.drawString("Cost: " + plant.cost, x, y);
            y += 20;
            g2.drawString("Health: " + character.health, x, y);
            y += 20;
            g2.drawString("Attack Damage: " + character.attack_damage, x, y);
            y += 20;
            g2.drawString("Attack Speed: " + character.attack_speed, x, y);
            y += 20;
            g2.drawString("Range: " + plant.range, x, y);
            y += 20;
            g2.drawString("Cooldown: " + plant.cooldown, x, y);
            y += 40;
        }
    }

    public void drawListZombie(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
        String text = "ZOMBIES LIST";
        int x = centerX(text);
        int y = 30;
        g2.drawString(text, x, y);
        y += 30;
        for (T character : characterList) {
            Zombie zombie = (Zombie) character;
            x = 50;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            g2.drawString(character.name, x, y);
            y += 20;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10F));
            g2.drawString("Description: " + character.description, x, y);
            y += 20;
            g2.drawString("Health: " + character.health, x, y);
            y += 20;
            g2.drawString("Attack damage: " + character.attack_damage, x, y);
            y += 20;
            g2.drawString("Attack Speed: " + character.attack_speed, x, y);
            y += 20;
            g2.drawString("Aquatic: " + zombie.is_aquatic, x, y);
            y += 40;
        }
    }
    public int centerX(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = wp.screenWidth/2 - length/2;
        return x;
    }
}
