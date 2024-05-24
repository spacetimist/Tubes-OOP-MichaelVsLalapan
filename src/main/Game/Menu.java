package main.Game;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Character;
import main.Game.ParentClass.Plant;
import main.Game.ParentClass.Zombie;

import java.awt.*;
import javax.swing.*;
import java.util.List;

public class Menu<T extends Character>{
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
        int x = wp.state.centerX(text);
        int y = 40;
        g2.drawString(text, x, y);
        y += 30;

        for (T character : characterList) {
            Plant plant = (Plant) character;
            x = 110;
            int boxWidth = 450;
            int boxHeight = 40;

            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRect(x - 10, y - 15, boxWidth, boxHeight);
            g2.setColor(Color.BLACK);
            g2.drawRect(x - 10, y - 15, boxWidth, boxHeight);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            g2.drawString(character.name, x, y);
            y += 10;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10F));
            g2.drawString(character.description, x, y);
            y += 10;
            g2.drawString("Cost: " + plant.cost + ", Health: " + character.health + ", Attack Damage: " + character.attack_damage + ", Attack Speed: " + character.attack_speed + ", Range: " + plant.range + ", Cooldown: " + plant.cooldown, x, y);
//            y += 20;
//            g2.drawString("Health: " + character.health, x, y);
//            y += 20;
//            g2.drawString("Attack Damage: " + character.attack_damage, x, y);
//            y += 20;
//            g2.drawString("Attack Speed: " + character.attack_speed, x, y);
//            y += 20;
//            g2.drawString("Range: " + plant.range, x, y);
//            y += 20;
//            g2.drawString("Cooldown: " + plant.cooldown, x, y);
            y += 20;
        }
    }

    public void drawListZombie(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
        String text = "ZOMBIES LIST";
        int x = wp.state.centerX(text);
        int y = 40;
        g2.drawString(text, x, y);
        y += 30;

        for (T character : characterList) {
            Zombie zombie = (Zombie) character;
            x = 110;
            int boxWidth = 450;
            int boxHeight = 40;

            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRect(x - 10, y - 15, boxWidth, boxHeight);
            g2.setColor(Color.BLACK);
            g2.drawRect(x - 10, y - 15, boxWidth, boxHeight);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            g2.drawString(character.name, x, y);
            y += 10;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 10F));
            g2.drawString(character.description, x, y);
            y += 10;
            g2.drawString("Health: " + character.health + ", Attack Damage: " + character.attack_damage + ", Attack Speed: " + character.attack_speed + ", Aquatic: " + zombie.is_aquatic, x, y);
//            y += 20;
//            g2.drawString("Attack damage: " + character.attack_damage, x, y);
//            y += 20;
//            g2.drawString("Attack Speed: " + character.attack_speed, x, y);
//            y += 20;
//            g2.drawString("Aquatic: " + zombie.is_aquatic, x, y);
            y += 20;
        }
    }
}