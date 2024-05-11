package main.Game.Map.Area;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Area;

import java.awt.*;

public class BaseArea extends Area {
    WindowPanel wp;
    Graphics2D g2;

    public BaseArea(WindowPanel wp) {
        super(wp);
        getTileImage("src/main/Resources/Tiles/BaseTile.png");
    }

    public void draw(Graphics2D g2) {
        // tileSize is 60
        // 0,0 itu pojok kiri atas
        for(int i=0; i<6; i++) {
            draw(g2, 0, (1+i)*60);
        }
    }
}
