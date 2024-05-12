package main.Game.ParentClass;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Character {
    public int x, y;
    public BufferedImage img;
    public Rectangle solidArea;
    public String direction;
    public boolean collision;
    public int coordinate[][];
}
