package main.Game.ParentClass;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.Interface.SpeedChange;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Zombie extends Character implements SpeedChange {
    String imgPath;
    public double speed;
    WindowPanel wp;
    KeyHandler kh;
    public final int screenX, screenY;
    public Zombie(WindowPanel wp, KeyHandler kh) {
        this.wp = wp;
        this.kh = kh;

        screenX = wp.screenWidth/2 - (wp.tileSize/2);
        screenY = wp.screenHeight/2 - (wp.tileSize/2);

        // make solid area smaller than tilesize (60*60)
        solidArea = new Rectangle(10, 20, 48, 48);
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 10*60;
        y = 1*60-30;
        speed = 0.5;
    }
    public void getZombieImage(String imgPath) {
        try {
            img = ImageIO.read(new File(imgPath));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void update() {
        x -= speed; // move left

        collisionOn = false;
        wp.collision.checkTile(this);
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = img;
        g2.drawImage(image, x, y, wp.tileSize, (wp.tileSize)+30, null);
    }

    @Override
    public void speedDecrease() {
        speed--;
    }

    @Override
    public void speedIncrease() {
        speed++;
    }
}
