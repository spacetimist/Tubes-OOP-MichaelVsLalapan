package main.Game.ParentClass;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Character {
    public int x, y;
    public int speed;
    public BufferedImage img;
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
