package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Cactus extends Plant {
    public Cactus(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);
        getPlantImage("src/main/Resources/Plants/cactus.png");
    }
}
