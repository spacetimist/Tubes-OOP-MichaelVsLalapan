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
    public int speed;
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
        speed = 1;
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
        int plantIndex = wp.collision.checkPlant(this, true);
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = img;
        g2.drawImage(image, x, y, wp.tileSize, (wp.tileSize)+30, null);
    }

//    public void attacking() {
//        for(Plant plant:wp.PlantList) {
//            for(int i=0; i<9; i++) {
//                if(wp.map.hasPlant[i][y]) {
//                    System.out.println(wp.map.hasPlant[i][y]);
//                    if(plant.range != -1) {
//                        if(x == plant.x + plant.range) {
//                        }
//                    }else{
//                        this.health -= plant.attack_damage;
//                    }
//                }
//                if(wp.map.hasPlant[x][y]) {
//                    collision = true;
//                    speed = 0;
//                    plant.health -= this.attack_damage;
//                }
//            }
//
//        }
//        for(Zombie z: wp.ZombieList) {
//            if(z.health == 0){
//                wp.ZombieList.remove(z);
//            }
//        }
//    }

    @Override
    public void speedDecrease() {
        wp.fps--;
    }

    @Override
    public void speedIncrease() {
        wp.fps++;
    }
}
