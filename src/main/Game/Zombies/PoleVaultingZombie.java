package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class PoleVaultingZombie extends Zombie {
    public PoleVaultingZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/polevaulting.png");
        name = "Pole Vaulting Zombie";
        health = 175;
        attack_damage = 100;
        attack_speed = 1;
    }
}
