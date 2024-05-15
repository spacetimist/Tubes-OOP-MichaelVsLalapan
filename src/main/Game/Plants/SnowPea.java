package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class SnowPea extends Plant {
    public SnowPea(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);
        getPlantImage("src/main/Resources/Plants/snowpea.png");
        name = "Snow pea";
        cost = 175;
        health = 100;
        attack_damage = 25;
        attack_speed = 4;
        range = -1;
        cooldown = 10;
    }
}
