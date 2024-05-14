package main.Game.Zombies;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class ScreenDoorZombie extends Zombie {
    public ScreenDoorZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/screendoor.png");
        name = "Screen Door Zombie";
        health = 375;
        attack_damage = 150;
        attack_speed = 1;
    }
}
