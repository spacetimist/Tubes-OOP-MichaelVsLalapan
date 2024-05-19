package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class DuckyTubeZombie extends Zombie {
    public DuckyTubeZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/duckytube.png");
        is_aquatic = true;
        name = "Ducky Tube Zombie";
        description = "Normal zombie yang menggunakan pelampung bebek.";
        health = 100;
        attack_damage = 100;
        attack_speed = 1;
    }
}
