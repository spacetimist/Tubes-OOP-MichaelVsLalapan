package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class FootballZombie extends Zombie {
    public FootballZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombiesfootball.png");
    }
}
