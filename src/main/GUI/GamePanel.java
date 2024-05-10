package main.GUI;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
    final int originalTileSize = 16;

    // scaling
    final int scale = 3; // 16*3 = 48
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16; // horizontally
    final int maxScreenRow = 12; // vertically
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }
}
