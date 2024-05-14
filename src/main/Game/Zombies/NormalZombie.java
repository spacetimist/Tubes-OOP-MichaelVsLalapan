package main.Game.Zombies;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class NormalZombie extends Zombie {
    public NormalZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/normal.png");
        name = "Normal Zombie";
        health = 125;
        attack_damage = 100;
        attack_speed = 1;
    }
}
