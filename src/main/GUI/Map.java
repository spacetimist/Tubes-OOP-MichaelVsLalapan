package main.GUI;
import main.Game.Plants.Cactus;
import main.Game.ParentClass.Plant;
import java.awt.*;
import java.security.Key;

import javax.swing.JPanel;

public class Map extends JPanel implements Runnable {
    final int originalTileSize = 16;

    // scaling
    final int scale = 3; // 16*3 = 48
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16; // horizontally
    final int maxScreenRow = 12; // vertically
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    KeyHandler keyH = new KeyHandler();

    int fps = 60;

    Thread gameThread;
    // initialize plants
    Cactus cactus = new Cactus(this, keyH, "src\\main\\Resources\\cactus.png");
    // Plant plant = new Plant(this, keyH);
    public Map() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/fps;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null) {
            // System.out.println("The loop is running");
            update();
            repaint();
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime /= 1000000;
                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void update() {
        cactus.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        cactus.draw(g2);
        g2.dispose();
    }
}
