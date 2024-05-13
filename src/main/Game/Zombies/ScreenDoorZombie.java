package main.Game.Zombies;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class ScreenDoorZombie extends Zombie {
    public ScreenDoorZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/screendoor.png");
    }
}
