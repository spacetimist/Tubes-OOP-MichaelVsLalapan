package main.Game.Zombies;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;

public class NewspaperZombie extends Zombie {
    public NewspaperZombie(WindowPanel wp) {
        super(wp);
        getZombieImage("src/main/Resources/Zombies/newspaper.png");
        name = "Newspaper Zombie";
        description = "Zombie yang muncul sambil membaca koran dan kecepatan bertambah ketika koran hancur.";
        health = 375;
        attack_damage = 200;
        attack_speed = 1;
    }

    public void loseNewspaper(){
        if (!newspaperLost) { // Pastikan metode ini hanya dipanggil sekali
            speedIncrease();
            getZombieImage("src/main/Resources/Zombies/nonewspaper.png");
            newspaperLost = true; // Update status koran
        }
    }
}
