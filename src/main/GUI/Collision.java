package main.GUI;

import main.Game.Map.Map;
import main.Game.ParentClass.Plant;
import main.Game.ParentClass.Zombie;
import main.Game.ParentClass.Character;

public class Collision {
    WindowPanel wp;
    public Collision(WindowPanel wp) {
        this.wp = wp;
    }
    public void collisionZ(Zombie z) {
        int zLeftX = z.x + z.solidArea.x;
        int zBottomY = z.y + z.solidArea.y + z.solidArea.height;

        int zLeft = zLeftX/wp.tileSize;
        int zBottom = zBottomY/wp.tileSize;

        int tile = 0;

        if(z.direction == "left") {
            zLeft = (int) ((zLeftX - z.speed)/wp.tileSize);
            tile = wp.map.coordinate[zLeft][zBottom];
            if(wp.map.area.tile[tile].collision){
                if(!z.collision) {
                    z.collision = true;
                }
            }
        }
        if (tile == 2) {
            System.out.println("You Lose");
        }

    }

    public int checkPlant(Zombie c, boolean isZombie) {
        int index = 999;
        for(Plant plant: wp.PlantList) {
            if(plant != null) {
                c.solidArea.x = c.x + c.solidArea.x;
                c.solidArea.y = c.y + c.solidArea.y;
                plant.solidArea.x = plant.x + plant.solidArea.x;
                plant.solidArea.y = plant.y + plant.solidArea.y;

                c.solidArea.x -= c.speed;
                if(c.solidArea.intersects(plant.solidArea)) {
                    c.speed = 0;
                }
                c.solidArea.x = c.solidAreaDefaultX;
                c.solidArea.y = c.solidAreaDefaultY;
                plant.solidArea.x = plant.solidAreaDefaultX;
                plant.solidArea.y = plant.solidAreaDefaultY;
            }

        }

        return index;
    }
}

