package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Repeater extends Plant {
    public Repeater(WindowPanel wp) {
        super(wp);
        getPlantImage("src/main/Resources/Plants/repeater.png");
        name = "Repeater";
        description = "Tanaman dengan attack damage 2 kali lebih besar daripada peashooter.";
        cost = 200;
        health = 300;
        attack_damage = 50;
        attack_speed = 4;
        range = -1;
        cooldown = 20;
    }
}
