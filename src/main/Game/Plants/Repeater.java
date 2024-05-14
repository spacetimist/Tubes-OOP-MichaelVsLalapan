package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Repeater extends Plant {
    public Repeater(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);

        name = "Repeater";
        cost = 200;
        health = 300;
        attack_damage = 50;
        attack_speed = 4;
        range = -1;
        cooldown = 20;
    }
}
