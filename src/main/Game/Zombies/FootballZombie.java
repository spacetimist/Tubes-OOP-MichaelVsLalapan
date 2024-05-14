package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class FootballZombie extends Zombie {
    public FootballZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/football.png");
        name = "Football Zombie";
        health = 375;
        attack_damage = 200;
        attack_speed = 1;
    }
}
