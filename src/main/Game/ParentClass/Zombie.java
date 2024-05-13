package main.Game.ParentClass;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.Interface.SpeedChange;
import main.Game.Map.Map;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Zombie extends Character implements SpeedChange {
    public double speed;
    WindowPanel wp;
    public Rectangle solidArea;

    public Zombie(WindowPanel wp) {
        this.wp = wp;

        // make solid area smaller than tilesize (60*60)
        solidArea = new Rectangle(10, 20, 48, 48);
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 10*wp.tileSize;
        y = 1*(wp.tileSize)-30; // - 30 biar lebih tinggi
        speed = 1; // 60px / 5s -> fps 12
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
        direction = "left";
        collision = false;
        wp.collision.collisionZ(this);
        if (collision) {
            speed = 0;
        }
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = img;
        g2.drawImage(image, x, y, wp.tileSize, (wp.tileSize)+30, null);
    }

    @Override
    public void speedDecrease() {
        wp.fps--;
    }

    @Override
    public void speedIncrease() {
        wp.fps++;
    }
}
