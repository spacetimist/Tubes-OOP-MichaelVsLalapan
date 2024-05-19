package main.Game;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;
import main.Game.Plants.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sun {
    WindowPanel wp;
    public BufferedImage img;

    public Sun(WindowPanel wp) {
        this.wp = wp;
        try {
            img = ImageIO.read(new File("src/main/Resources/Tiles/sun.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int totalSun = 50;

    public int getTotalSun() {
        return totalSun;
    }

    public void generateSun(){
        totalSun += 25;
    }

}