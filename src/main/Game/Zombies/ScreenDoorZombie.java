package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class ScreenDoorZombie extends Zombie {
    public ScreenDoorZombie(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);
        getZombieImage("src/main/Resources/Zombies/screendoor.png");
    }
}
