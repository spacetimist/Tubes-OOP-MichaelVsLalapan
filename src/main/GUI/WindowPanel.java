package main.GUI;

import main.Game.Map.Map;
import main.Game.Plants.Cactus;
import main.Game.Zombies.NormalZombie;

import java.awt.*;

import javax.swing.JPanel;

public class WindowPanel extends JPanel implements Runnable {
    final int originalTileSize = 20;

    // scaling
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 11; // horizontally
    final int maxScreenRow = 8; // vertically
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    int fps = 60;
    Map map = new Map(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    // initialize plants
    Cactus cactus = new Cactus(this, keyH);
    NormalZombie normal = new NormalZombie(this, keyH);
    public Collision collision = new Collision(this);
    public WindowPanel() {
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
        normal.update();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        map.draw(g2);
        cactus.draw(g2);
        normal.draw(g2);
        g2.dispose();
    }
}
