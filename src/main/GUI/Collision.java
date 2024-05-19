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
//    public void collisionZ(Zombie z) {
//        int zLeftX = z.x + z.solidArea.x;
//        int zBottomY = z.y + z.solidArea.y + z.solidArea.height;
//
//        int zLeft = zLeftX/wp.tileSize;
//        int zBottom = zBottomY/wp.tileSize;
//
//        int tile = 0;
//
//        zLeft = (int) ((zLeftX - z.speed)/wp.tileSize);
//        tile = wp.map.coordinate[zLeft][zBottom];
//        if(wp.map.area.tile[tile].collision){
//            if(!z.collision) {
//                z.collision = true;
//            }
//        }
//        if (tile == 2) {
//            System.out.println("You Lose");
//        }
//
//    }

    public int checkPlant(Zombie c, boolean isZombie) {
        int index = 999;
        int i = 0;
        for(Plant plant: wp.PlantList) {
            if(plant != null) {
//                System.out.println(wp.PlantList.size());
                c.solidArea.x = c.x + c.solidArea.x;
                c.solidArea.y = c.y + c.solidArea.y;
                plant.solidArea.x = plant.x + plant.solidArea.x;
                plant.solidArea.y = plant.y + plant.solidArea.y;

                c.solidArea.x -= c.speed; // gerak ke kiri
                if(c.solidArea.intersects(plant.solidArea)) {
                    index = i;
                    break;
                }
                c.solidArea.x = c.solidAreaDefaultX;
                c.solidArea.y = c.solidAreaDefaultY;
                plant.solidArea.x = plant.solidAreaDefaultX;
                plant.solidArea.y = plant.solidAreaDefaultY;
                i++;
            }
        }

    return index;
    }
}

