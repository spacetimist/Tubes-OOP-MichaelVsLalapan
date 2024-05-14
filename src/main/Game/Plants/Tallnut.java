package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Tallnut extends Plant {
    public Tallnut(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);

        name = "Tall nut";
        cost = 125;
        health = 2000;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 20;
    }
}
