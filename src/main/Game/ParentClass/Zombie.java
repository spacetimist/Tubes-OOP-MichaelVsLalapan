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
    public int speed = 1;
    WindowPanel wp;

    // attributes
    public boolean is_aquatic = false;

    public Zombie(WindowPanel wp) {
        this.wp = wp;

        // make solid area smaller than tilesize (60*60)
        solidArea = new Rectangle(20, 20, 48, 48);
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

    int index;
    public void update() {
        x -= speed; // gerak ke kiri
        direction = "left";
        collision = false;

        if (x == 30) {
            speed = 0;
        }

        int index = wp.collision.checkPlant(this, true);
        attack(index);
    }

    public void attack(int index) {
        this.index = index;
        index = wp.collision.checkPlant(this, true);
        if(index != 999) {
            Plant plant = wp.PlantList.get(index);
            while(plant != null) {
                this.speed = 0;
                if(health > 0) {
                    while(plant.health > 0) {
                        plant.health -= attack_damage;
                        try {
                            Thread.sleep(attack_speed*1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.printf("%s's health: %d\n", plant.name, plant.health);
                    }
                    if(plant.health <= 0) {
                        wp.PlantList.remove(index);
                        break;
                    }
                }else{
                    wp.ZombieList.remove(this);
                }

            }
            this.speed = 1;

        }
    }

    public void attacked(int i) {
        
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
