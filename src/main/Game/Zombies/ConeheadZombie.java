package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class ConeheadZombie extends Zombie {
    public ConeheadZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/conehead.png");
    }
}
