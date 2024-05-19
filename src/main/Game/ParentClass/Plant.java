package main.Game.ParentClass;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Plant extends Character {
    WindowPanel wp;
    KeyHandler kh;
    // attributes
    public int cost, range, cooldown;
    public int x2, y2;
    public int x3, y3;
    public Plant(WindowPanel wp, KeyHandler kh) {
        this.wp = wp;
        this.kh = kh;

//        setDefaultValues(x, y);
    }

    public void setDefaultValues(int x2, int y2) {
        this.x2 = x2;
        this.y2 = y2;
    }
    public void getPlantImage(String imgPath) {
        try {
            img = ImageIO.read(new File(imgPath));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = img;
        g2.drawImage(image, x, y, wp.tileSize, wp.tileSize, null);
    }
}
