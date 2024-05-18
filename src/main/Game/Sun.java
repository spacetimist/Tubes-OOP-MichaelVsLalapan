package main.Game;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;
import main.Game.Plants.*;

public class Sun {
    WindowPanel wp;
    KeyHandler kh;

    public Sun(WindowPanel wp) {
        this.wp = wp;
    }

    public int totalSun = 50;

    public int getTotalSun() {
        return totalSun;
    }

    public void generateSun(int sun){
        totalSun += sun;
    }
}