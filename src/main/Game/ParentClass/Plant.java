package main.Game.ParentClass;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Plant extends Character {
    String imgPath;
    WindowPanel wp;
    KeyHandler kh;
    public final int screenX, screenY;
    public Plant(WindowPanel wp, KeyHandler kh) {
        this.wp = wp;
        this.kh = kh;

        screenX = wp.screenWidth/2 - (wp.tileSize/2);
        screenY = wp.screenHeight/2 - (wp.tileSize/2);

        // make solid area smaller than tilesize (60*60)
        solidArea = new Rectangle(10, 20, 48, 48);
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 60;
        y = 60;
    }
    public void getPlantImage(String imgPath) {
        try {
            img = ImageIO.read(new File(imgPath));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        // placing the plant
        if(kh.upPressed == false) {
            y -= 60;
            kh.upPressed = true;
        }else if(!kh.downPressed) {
            y += 60;
            kh.downPressed = true;
        }else if(!kh.rightPressed) {
            x += 60;
            kh.rightPressed = true;
        }else if(!kh.leftPressed) {
            x -= 60;
            kh.leftPressed = true;
        }

        collisionOn = false;
        wp.collision.checkTile(this);
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = img;
        g2.drawImage(image, x, y, wp.tileSize, wp.tileSize, null);
    }
}
