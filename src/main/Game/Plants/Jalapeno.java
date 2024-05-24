package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Jalapeno extends Plant {
    public Jalapeno(WindowPanel wp) {
        super(wp);
        getPlantImage("src/main/Resources/Plants/jalapeno.png");
        name = "Jalapeno";
        description = "Tanaman yang akan menghabisi semua zombie yang ada di barisan tersebut.";
        cost = 125;
        health = 250;
        attack_damage = 5000;
        attack_speed = 0;
        range = -1;
        cooldown = 35;
    }
}
