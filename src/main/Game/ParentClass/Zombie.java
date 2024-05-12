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
    KeyHandler kh;
    public int position;

    Map map;

    public Zombie(WindowPanel wp, KeyHandler kh) {
        this.wp = wp;
        this.kh = kh;

        // make solid area smaller than tilesize (60*60)
        solidArea = new Rectangle(10, 20, 48, 48);
        coordinate = new int[11][6];
        setDefaultValues();
    }

    public void setDefaultValues() {
        x = 10*wp.tileSize;
        y = 1*(wp.tileSize)-30;
        speed = 1;
        position = coordinate[x/wp.tileSize][y/wp.tileSize];

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
        position = coordinate[x/wp.tileSize][y/wp.tileSize];
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
