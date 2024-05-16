package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Wallnut extends Plant {
    public Wallnut(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);
        getPlantImage("src/main/Resources/Plants/wallnut.png");
        name = "Wall nut";
        cost = 50;
        health = 1000;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 20;
    }
}
