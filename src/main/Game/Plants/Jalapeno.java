package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Jalapeno extends Plant {
    public Jalapeno(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);
        getPlantImage("src/main/Resources/Plants/jalapeno.png");
        name = "Jalapeno";
        cost = 125;
        health = 250;
        attack_damage = 5000;
        attack_speed = 0;
        range = -1;
        cooldown = 35;
    }
}
