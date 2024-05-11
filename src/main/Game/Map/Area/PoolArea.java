package main.Game.Map.Area;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Area;

import java.awt.*;

public class PoolArea extends Area {
    WindowPanel wp;
    Graphics2D g2;

    public PoolArea(WindowPanel wp) {
        super(wp);
        getTileImage("src/main/Resources/Tiles/poolTile.png");
    }

    public void draw(Graphics2D g2) {
        // tileSize is 60
        // 0,0 itu pojok kiri atas
        for(int i=0; i<9; i++) {
            draw(g2, (1+i)*60, 3*60);
        }
        for(int i=0; i<9; i++) {
            draw(g2, (1+i)*60, 4*60);
        }
    }
}
