package main.Game;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.Plants.*;

public class Inventory {
    WindowPanel wp;
    KeyHandler kh;
    public Inventory(WindowPanel wp) {
        this.wp = wp;
    }

    public void set() {
        wp.PlantList[0] = new Cactus(wp, kh);
        wp.PlantList[1] = new Jalapeno(wp, kh);
        wp.PlantList[2] = new Lilypad(wp, kh);
        wp.PlantList[3] = new PeaShooter(wp, kh);
        wp.PlantList[4] = new Repeater(wp, kh);
        wp.PlantList[5] = new SnowPea(wp, kh);
        wp.PlantList[6] = new Squash(wp, kh);
        wp.PlantList[7] = new Sunflower(wp, kh);
        wp.PlantList[8] = new Tallnut(wp, kh);
        wp.PlantList[9] = new Wallnut(wp, kh);
    }
}
