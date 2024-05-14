package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class PeaShooter extends Plant {
    public PeaShooter(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);

        name = "Peashooter";
        cost = 100;
        health = 100;
        attack_damage = 25;
        attack_speed = 4;
        range = -1;
        cooldown = 10;
    }
}
