package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;

public class Sunflower extends Plant {
    private long lastSunGenerationTime;
    WindowPanel wp;
    public Sunflower(WindowPanel wp, KeyHandler kh) {
        super(wp, kh);
        this.wp = wp;
        getPlantImage("src/main/Resources/Plants/sunflower.png");
        name = "Sunflower";
        description = "Tanaman spesial yang dapat menghasilkan sun.";
        cost = 50;
        health = 100;
        attack_damage = 0;
        attack_speed = 0;
        range = 0;
        cooldown = 10;
        lastSunGenerationTime = 0;
    }
    public void update() {
        long currentTime = System.currentTimeMillis();

        if(wp.isMorning) {
            if (currentTime - lastSunGenerationTime >= 3000) { // 3000 milliseconds = 3 seconds
                wp.sun.totalSun += 25; // Generate sun points
                lastSunGenerationTime = currentTime; // Update the last generation time
                System.out.println("Sunflower generated 25 sun.");
            }
        }
    }
}
