package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Tallnut extends Plant {
    public Tallnut(WindowPanel wp) {
        super(wp);
        getPlantImage("src/main/Resources/Plants/tallnut.png");
        // biar lebih tinggi



        name = "Tall nut";
        description = "Tanaman yang menyerupai wallnut namun dengan tambahan health yang tinggi.";
        cost = 125;
        health = 2000;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 20;
    }
}
