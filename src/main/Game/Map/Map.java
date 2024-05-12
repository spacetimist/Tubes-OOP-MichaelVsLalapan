package main.Game.Map;

import main.GUI.WindowPanel;

import java.awt.*;

public class Map {
    WindowPanel wp;
    public Area area;
    public int coordinate[][];
    public Map(WindowPanel wp) {
        this.wp = wp;
        coordinate = new int[11][8];
        area = new Area(wp);

        // MORNING SKY
//        for(int j=0; j<=10; j++){
//            coordinate[j][0] = 5;
//        }
        for(int j=0; j<=10; j++){
            coordinate[j][0] = 4;
        }

        // COMMON AREA -> tile = 0
        for(int i=1; i<=2; i++) {
            for(int j=1; j<=9; j++){
                coordinate[j][i] = 0;
            }
        }
        for(int i=5; i<=6; i++) {
            for(int j=1; j<=9; j++){
                coordinate[j][i] = 0;
            }
        }

        // POOL AREA -> tile = 1
        for(int i=3; i<=4; i++) {
            for(int j=1; j<=9; j++){
                coordinate[j][i] = 1;
            }
        }

        // BASE AREA -> tile = 2
        for(int i=1; i<=6; i++){
            coordinate[0][i] = 2;
        }

        // ZOMBIE SPAWN AREA -> tile = 3
        for(int i=1; i<=6; i++){
            coordinate[10][i] = 3;
        }
    }
    public void draw(Graphics2D g2) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while(col < 11 && row < 7) {
            area.draw(g2, x, y, coordinate[col][row]);
            col++;
            x += wp.tileSize;

            if(col == 11) {
                col = 0;
                x = 0;
                row++;
                y += wp.tileSize;
            }

        }

    }
}