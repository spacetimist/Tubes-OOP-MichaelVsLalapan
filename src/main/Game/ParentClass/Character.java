package main.Game.ParentClass;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Character {
    public int x, y;
    public BufferedImage img;
    public String direction;
    public boolean collision;
    public Rectangle solidArea;

    public int solidAreaDefaultX, solidAreaDefaultY;

    public String name, description;
    public int health, attack_damage, attack_speed;
}
