package main.Game;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.Plants.Cactus;
import main.Game.Plants.SnowPea;

public class Inventory {
    WindowPanel wp;
    KeyHandler kh;
    public Inventory(WindowPanel wp) {
        this.wp = wp;
    }

    public void set() {
        wp.PlantList[0] = new Cactus(wp, kh);
//        wp.PlantList[1] = new SnowPea(wp, kh);
//        wp.PlantList[2] = new Cactus(wp, kh);
//        wp.PlantList[3] = new Cactus(wp, kh);
//        wp.PlantList[4] = new Cactus(wp, kh);
//        wp.PlantList[5] = new Cactus(wp, kh);
//        wp.PlantList[6] = new Cactus(wp, kh);
//        wp.PlantList[7] = new Cactus(wp, kh);
//        wp.PlantList[8] = new Cactus(wp, kh);
//        wp.PlantList[9] = new Cactus(wp, kh);
    }
}
