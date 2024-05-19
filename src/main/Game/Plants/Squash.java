package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Squash extends Plant {
    public Squash(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);
        getPlantImage("src/main/Resources/Plants/squash.png");
        name = "Squash";
        description = "Tanaman spesial yang dapat melakukan instant-kill.";
        cost = 50;
        health = 100;
        attack_damage = 5000;
        attack_speed = 0;
        range = 1;
        cooldown = 20;
    }
}
