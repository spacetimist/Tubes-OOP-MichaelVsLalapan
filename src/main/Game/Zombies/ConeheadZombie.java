package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class ConeheadZombie extends Zombie {
    public ConeheadZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/conehead.png");
        name = "Conehead Zombie";
        description = "Zombie yang menggunakan atribut traffic cone di kepala dan memiliki ekstra health.";
        health = 250;
        attack_damage = 100;
        attack_speed = 1;
    }
}
