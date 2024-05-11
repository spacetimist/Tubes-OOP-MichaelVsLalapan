package main.Game.Plants;
import main.GUI.KeyHandler;
import main.GUI.Map;
import main.Game.ParentClass.Plant;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Cactus extends Plant {
    public Cactus(Map m, KeyHandler kh, String imgPath) {
        super(m, kh, imgPath);
    }
}
