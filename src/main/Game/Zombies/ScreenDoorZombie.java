package main.Game.Zombies;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class ScreenDoorZombie extends Zombie {
    public ScreenDoorZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/screendoor.png");
        name = "Screen Door Zombie";
        description = "Zombie yang masuk dengan memegang pintu kasa yang membuat healthnya lebih tinggi.";
        health = 375;
        attack_damage = 150;
        attack_speed = 1;
    }
}
