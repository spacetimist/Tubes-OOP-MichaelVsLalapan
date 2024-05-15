package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Sunflower extends Plant {
    public Sunflower(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);
        getPlantImage("src/main/Resources/Plants/sunflower.png");
        name = "Sunflower";
        cost = 50;
        health = 100;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 10;
    }
}
