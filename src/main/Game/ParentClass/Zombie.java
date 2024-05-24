package main.Game.ParentClass;

import main.GUI.WindowPanel;
import main.Game.Interface.SpeedChange;
import main.Game.Plants.Cactus;
import main.Game.Zombies.BalloonZombie;
import main.Game.Zombies.DolphinRiderZombie;
import main.Game.Zombies.PoleVaultingZombie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Zombie extends Character implements SpeedChange {
    public double speed = 2;
    public double originalSpeed;
    WindowPanel wp;

    // attributes
    public boolean is_aquatic = false;
    public long lastAttackTime;
    private long lastSnowPeaHitTime;
    private boolean hasJumped;
    public boolean balloonPopped;

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

    public void update() {
        x -= speed;
        collision = false;

        if (x <= 30) {
            wp.state.lose = true;
            wp.gameState = wp.finished;
        }

        long currentTime = System.currentTimeMillis();
        int index = wp.collision.checkPlant(this, true);
        if (index != 999 && currentTime - lastAttackTime >= attack_speed * 1000) {
            if(!(this instanceof BalloonZombie)) {
                if (speed > 0) {
                    originalSpeed = speed; // Save current speed
                    speed = 0; // Stop the zombie
                }
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
            if ((this instanceof PoleVaultingZombie || this instanceof DolphinRiderZombie) && !this.hasJumped) {
                // Zombie melompati tanaman pertama yang ditemui dan menghancurkannya
                wp.map.hasPlant[plant.x / 60][plant.y / 60] = false;
                wp.PlantList.remove(index);
                this.x -= wp.tileSize;
                this.hasJumped = true;
                System.out.printf("%s jumped over and killed %s\n", this.name, plant.name);
            } else {
                // Zombie menyerang tanaman seperti biasa
                if (this instanceof BalloonZombie && !balloonPopped) {
                    if (plant instanceof Cactus) {
                        ((BalloonZombie) this).balloonPopped();
                        System.out.printf("%s's balloon was popped by %s\n", this.name, plant.name);
                    } else {
                        // Skip attacking if BalloonZombie and balloon hasn't popped
                        return;
                    }
                }

                plant.health -= attack_damage;
                System.out.printf("%s's health: %d\n", plant.name, plant.health);
                if (plant.health <= 0) {
                    wp.map.hasPlant[plant.x / 60][plant.y / 60] = false;
                    wp.PlantList.remove(index);
                }
            }
        }
    }



    public void draw(Graphics2D g2) {
        BufferedImage image = img;
            g2.drawImage(image, x, y, wp.tileSize, (wp.tileSize)+30, null);
    }

    @Override
    public void speedDecrease() {
        speed /= 2;

        // if hit by snowpea
        lastSnowPeaHitTime = System.currentTimeMillis();
        if(shouldResetSpeed()) {
            resetSpeed();
        }
    }

    @Override
    public void speedIncrease() {
        speed = 3;
    }

    public void resetSpeed() {
        this.speed = originalSpeed;
    }

    public boolean shouldResetSpeed() {
        return System.currentTimeMillis() - lastSnowPeaHitTime >= 3000;
    }
}
