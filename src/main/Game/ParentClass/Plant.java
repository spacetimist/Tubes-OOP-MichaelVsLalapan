package main.Game.ParentClass;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.Plants.SnowPea;
import main.Game.Zombies.BalloonZombie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Plant extends Character {
    WindowPanel wp;
    // attributes
    public int cost, range, cooldown;
    public long lastPlantedTime;
    public long lastAttackTime;

    public Plant(WindowPanel wp) {
        this.wp = wp;
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
                        if (z instanceof BalloonZombie && !((BalloonZombie) z).balloonPopped) {
                            // Ignore attack if it's a BalloonZombie and the balloon hasn't popped
                            continue;
                        }

                        if (!(z instanceof BalloonZombie) || z.balloonPopped) {
                            z.health -= attack_damage;
                            System.out.printf("%s's health: %d\n", z.name, z.health);
                            if (this instanceof SnowPea) {
                                z.speedDecrease();
                            }
                            if (z.health <= 0) {
                                wp.ZombieList.remove(z);
                                break;
                            }
                        }
                    }
                } else if (range == 1) {
                    if (z.x == this.x + 60 && z.y + 30 == this.y) {
                        if (!(z instanceof BalloonZombie) || z.balloonPopped) {
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
}
