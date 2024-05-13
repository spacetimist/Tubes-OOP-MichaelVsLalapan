package main.GUI;

import main.Game.Map.Map;
import main.Game.ParentClass.Plant;
import main.Game.ParentClass.Zombie;
import main.Game.Inventory;
import main.Game.ZombieSpawn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class WindowPanel extends JPanel implements Runnable {
    final int originalTileSize = 20;
    private long lastSpawnTime = System.currentTimeMillis();

    // scaling
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 11; // horizontally
    final int maxScreenRow = 8; // vertically
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public int fps = 12;
    Map map = new Map(this);
    KeyHandler kh = new KeyHandler();
    Thread gameThread;

    // instantiate collision
    public Collision collision = new Collision(this);

    // instantiate plant list, zombie list
    public Plant PlantList[] = new Plant[10];
    public Zombie ZombieList[] = new Zombie[10];
    // deck
    public Plant Deck[] = new Plant[6];

    // instantiate setter
    Inventory inventory = new Inventory(this);
    ZombieSpawn zSpawn = new ZombieSpawn(this);
    int i;

    public WindowPanel() {
        i = 0;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void setUp() {
        zSpawn.set();
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
        zSpawn.startSpawnTimer(i);
        i++;

//        for(int i=0; i<ZombieList.length; i++) {
//            if(ZombieList[i] != null) {
//                ZombieList[i].update();
//            }
//        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        map.draw(g2);

        for(int i=0; i<ZombieList.length; i++) {
            if(ZombieList[i] != null) {
                ZombieList[i].draw(g2);
            }
        }
        g2.dispose();
    }
}
