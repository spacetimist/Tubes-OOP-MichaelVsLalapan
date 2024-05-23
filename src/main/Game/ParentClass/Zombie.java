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
    public double speed = 1;
    public double originalSpeed;
    WindowPanel wp;

    // attributes
    public boolean is_aquatic = false;
    public long lastAttackTime;

    public Zombie(WindowPanel wp) {
        this.wp = wp;

        // make solid area smaller than tilesize (60*60)
        solidArea = new Rectangle(20, 40, 48, 48);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues(1);
    }

    public void setDefaultValues(int y) {
        x = 10*wp.tileSize;
        this.y = y*(wp.tileSize)-30; // - 30 biar lebih tinggi
    }
    public void getZombieImage(String imgPath) {
        try {
            img = ImageIO.read(new File(imgPath));
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    int index, rangeIndex;
    public void update() {
        if (speed > 0) {
            x -= speed; // Move left only if speed > 0
        }
        direction = "left";
        collision = false;

        if (x == 30 || collision) {
            speed = 0;
        }

        long currentTime = System.currentTimeMillis();
        int index = wp.collision.checkPlant(this, true);
        if (index != 999 && currentTime - lastAttackTime >= attack_speed * 1000) {
            if (speed > 0) {
                originalSpeed = speed; // Save current speed
                speed = 0; // Stop the zombie
            }
            attack(index);
            lastAttackTime = currentTime;
        }else if (index == 999 && speed == 0) {
            speed = originalSpeed; // Resume movement if no plant to attack
        }
    }

    public void attack(int index) {
        Plant plant = wp.PlantList.get(index);
        if (plant != null && health > 0) {
            plant.health -= attack_damage;
            System.out.printf("%s's health: %d\n", plant.name, plant.health);
            if (plant.health <= 0) {
                wp.PlantList.remove(index);
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = img;
        g2.drawImage(image, x, y, wp.tileSize, (wp.tileSize)+30, null);
    }

    @Override
    public void speedDecrease() {

    }

    @Override
    public void speedIncrease() {
        speed = 2;
    }
}
