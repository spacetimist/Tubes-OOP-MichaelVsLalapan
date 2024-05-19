package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;


public class BucketheadZombie extends Zombie {
    public BucketheadZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/buckethead.png");
        name = "Buckethead Zombie";
        description = "Zombie yang menggunakan atribut ember di kepala dan memiliki ekstra health.";
        health = 300;
        attack_damage = 100;
        attack_speed = 1;
    }
}
