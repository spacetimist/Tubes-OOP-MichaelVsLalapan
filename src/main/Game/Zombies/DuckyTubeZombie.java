package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class DuckyTubeZombie extends Zombie {
    public DuckyTubeZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/duckytube.png");
        is_aquatic = true;
    }
}
