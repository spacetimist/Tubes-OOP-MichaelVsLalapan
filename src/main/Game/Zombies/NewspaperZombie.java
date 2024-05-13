package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class NewspaperZombie extends Zombie {
    public NewspaperZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/newspaper.png");
    }
}
