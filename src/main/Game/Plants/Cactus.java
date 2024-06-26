package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Cactus extends Plant {
    public Cactus(WindowPanel wp) {
        super(wp);
        getPlantImage("src/main/Resources/Plants/cactus.png");
        name = "Cactus";
        description = "Tanaman yang dapat memecahkan balon di punggung balloon zombie.";
        cost = 175;
        health = 500;
        attack_damage = 100;
        attack_speed = 2;
        range = -1;
        cooldown = 5;
    }
}
