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
    public boolean is_decked = false;
    public Plant(WindowPanel wp, KeyHandler kh) {
        this.wp = wp;
        this.kh = kh;

        setDefaultValues();
    }

    public void setDefaultValues() {
        x = wp.tileSize;
        y = wp.tileSize;
    }
    public void getPlantImage(String imgPath) {
        try {
            img = ImageIO.read(new File(imgPath));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        if(kh.upPressed || kh.downPressed || kh.leftPressed || kh.rightPressed) {
            if (kh.upPressed) {
                direction = "up";
            } else if (kh.downPressed) {
                direction = "down";
            } else if (kh.rightPressed) {
                direction = "right";
            } else if (kh.leftPressed) {
                direction = "left";
            }
            collision = false;
            wp.collision.collisionP(this);

            if(!collision) {
                switch(direction) {
                    case "up":
                        y -= wp.tileSize;
                        kh.upPressed = false;
                        break;
                    case "down":
                        y += wp.tileSize;
                        kh.downPressed = false;
                        break;
                    case "right":
                        x += wp.tileSize;
                        kh.rightPressed = false;
                        break;
                    case "left":
                        x -= wp.tileSize;
                        kh.leftPressed = false;
                        break;
                }
            }
        }
    }
    public void draw(Graphics2D g2){
        BufferedImage image = img;
        g2.drawImage(image, x, y, wp.tileSize, wp.tileSize, null);
    }
}
