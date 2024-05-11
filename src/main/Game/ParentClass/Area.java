package main.Game.ParentClass;

import main.GUI.WindowPanel;
import main.Game.Map.Area.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Area {
    Tile tile;
    WindowPanel wp;
    String imgPath;
    public Area(WindowPanel wp) {
        this.wp = wp;
        tile = new Tile();
    }
    public void getTileImage(String imgPath) {
        try{
            tile.img = ImageIO.read(new File(imgPath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2, int x, int y) {
        g2.drawImage(tile.img, x, y, wp.tileSize, wp.tileSize, null);
    }
}
