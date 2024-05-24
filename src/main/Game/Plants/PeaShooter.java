package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class PeaShooter extends Plant {
    public PeaShooter(WindowPanel wp) {
        super(wp);
        getPlantImage("src/main/Resources/Plants/peashooter.png");
        name = "Peashooter";
        description = "Tanaman yang dapat menembak zombie yang sebaris dengannya.";
        cost = 100;
        health = 100;
        attack_damage = 25;
        attack_speed = 4;
        range = -1;
        cooldown = 10;
    }
}
