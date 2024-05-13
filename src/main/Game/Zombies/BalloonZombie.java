package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class BalloonZombie extends Zombie {
    public BalloonZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/balloon.png");
    }
}
