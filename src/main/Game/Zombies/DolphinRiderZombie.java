package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class DolphinRiderZombie extends Zombie {
    public DolphinRiderZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/dolphinrider.png");
        is_aquatic = true;
        name = "Dolphin Rider Zombie";
        description = "Zombie yang hanya dapat berjalan di area pool dengan mengendarai lumba-lumba.";
        health = 175;
        attack_damage = 100;
        attack_speed = 1;
    }
}
