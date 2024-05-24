package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class SnowPea extends Plant {
    public SnowPea(WindowPanel wp) {
        super(wp);
        getPlantImage("src/main/Resources/Plants/snowpea.png");
        name = "Snow pea";
        description = "Tanaman spesial yang memiliki kemampuan slowing.";
        cost = 175;
        health = 100;
        attack_damage = 25;
        attack_speed = 4;
        range = -1;
        cooldown = 10;
    }
}
