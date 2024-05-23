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
    public long lastPlantedTime;
    public Rectangle attackArea;
    public int attackAreaDefaultX, attackAreaDefaultY;
    public long lastAttackTime;

    public Plant(WindowPanel wp, KeyHandler kh) {
        this.wp = wp;
        this.kh = kh;
        collision = true;

        solidArea = new Rectangle(0, 0, 60, 60);

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        lastPlantedTime = 0;



        setDefaultValues(1, 1);
    }

    public void setDefaultValues(int x, int y) {
        this.x = x*60;
        this.y = y*60;
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
        g2.drawImage(image, x, y, null);
    }

    public void update() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastAttackTime >= attack_speed*1000) {
            attack();
            lastAttackTime = currentTime;
        }
    }

    public void attack() {
        for (Zombie z : wp.ZombieList) {
            if (health > 0) {
                if (range == -1) {
                    if (z.y + 30 == y) {
                        z.health -= attack_damage;
                        System.out.printf("%s's health: %d\n", z.name, z.health);
                        if (z.health <= 0) {
                            wp.ZombieList.remove(z);
                            break;
                        }
                    }
                } else if (range == 1) {
                    if (z.x == this.x+60 && z.y+30 == this.y) {
                        // Remove zombie when it is in the tile just before the plant
                        wp.ZombieList.remove(z);
                        System.out.printf("%s was instantly killed by %s\n", z.name, this.name);
                        break;
                    }
                }
            }
        }
    }
}
