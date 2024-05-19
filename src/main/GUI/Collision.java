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

