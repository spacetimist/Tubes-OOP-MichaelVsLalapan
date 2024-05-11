package main.Game.ParentClass;

import main.GUI.KeyHandler;
import main.GUI.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plant extends Character {
    String imgPath;
    Map map;
    KeyHandler kh;
    public Plant(Map map, KeyHandler kh, String imgPath) {
        this.map = map;
        this.kh = kh;
        this.imgPath = imgPath;
        setDefaultValues();
        getPlantImage(imgPath);
    }

    public void setDefaultValues() {
        x = 100;
        y = 100;
        speed = 4;
    }
    public void getPlantImage(String imgPath) {
        try {
            img = ImageIO.read(new File(imgPath));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if(kh.upPressed) {
            y -= speed;
        }else if(kh.downPressed) {
            y += speed;
        }else if(kh.rightPressed) {
            x += speed;
        }else if(kh.leftPressed) {
            x -= speed;
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = img;
        g2.drawImage(image, x, y, map.tileSize, map.tileSize, null);
    }
}
