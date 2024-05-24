package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Lilypad extends Plant {
    public Lilypad(WindowPanel wp) {
        super(wp);
        getPlantImage("src/main/Resources/Plants/lilypad.png");
        name = "Lilypad";
        description = "Tanaman spesial yang menjadi media tanam untuk tanaman lain.";
        cost = 25;
        health = 100;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 10;
    }
}
