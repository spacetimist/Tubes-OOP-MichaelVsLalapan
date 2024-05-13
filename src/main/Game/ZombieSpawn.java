package main.Game;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.Plants.Cactus;
import main.Game.Zombies.NewspaperZombie;
import main.Game.Zombies.NormalZombie;

public class ZombieSpawn {
    WindowPanel wp;
    KeyHandler kh;
    public ZombieSpawn(WindowPanel wp) {
        this.wp = wp;
    }

    public void set() {
        wp.ZombieList[0] = new NormalZombie(wp);
        wp.ZombieList[1] = new NewspaperZombie(wp);
    }
}
