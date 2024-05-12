package main.Game.Map;

import main.GUI.WindowPanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Area {
    public Tile[] tile;
    WindowPanel wp;
    String imgPath;
    public Area(WindowPanel wp) {
        this.wp = wp;
        tile = new Tile[10];
        getTileImage();
    }
    public void getTileImage() {
        try{
            tile[0] = new Tile();
            tile[1] = new Tile();
            tile[2] = new Tile();
            tile[3] = new Tile();
            tile[4] = new Tile();
            tile[0].img = ImageIO.read(new File("src/main/Resources/Tiles/grassTile.png"));
            tile[1].img = ImageIO.read(new File("src/main/Resources/Tiles/poolTile.png"));
            tile[2].img = ImageIO.read(new File("src/main/Resources/Tiles/BaseTile.png"));
            tile[2].collision = true;
            tile[3].img = ImageIO.read(new File("src/main/Resources/Tiles/spawnTile.png"));
            tile[4].img = ImageIO.read(new File("src/main/Resources/Tiles/morningBottom.png"));
            tile[4].collision = true;
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2, int x, int y, int tileNum) {
        g2.drawImage(tile[tileNum].img, x, y, wp.tileSize, wp.tileSize, null);
    }
}