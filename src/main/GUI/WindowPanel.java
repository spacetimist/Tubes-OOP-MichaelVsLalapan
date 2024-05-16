package main.GUI;

import main.Game.Map.Map;
import main.Game.ParentClass.Plant;
import main.Game.ParentClass.Zombie;
import main.Game.Inventory;
import main.Game.Plants.*;
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
    KeyHandler kh = new KeyHandler(this);
    Thread gameThread;

    // instantiate collision
    public Collision collision = new Collision(this);

    // instantiate plant list, zombie list
    public Plant PlantList[] = new Plant[10];
    public Zombie ZombieList[] = new Zombie[10];
    // deck
    public Plant Deck[] = new Plant[6];
    // batch
    public Zombie Batch[] = new Zombie[6];

    // instantiate setter
    Inventory inventory = new Inventory(this);

    ZombieSpawn zSpawn = new ZombieSpawn(this);
    Tallnut peas = new Tallnut(this, kh);
    Wallnut w = new Wallnut(this, kh);


    // game state
    public int gameState;
    public final int playState = 1;
    public final int inventoryState = 2;

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
        gameState = inventoryState; // initial state
        zSpawn.set();
        inventory.set();
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
        if(gameState == inventoryState) {

        }
        if(gameState == playState) {
            zSpawn.run();
        }
            w.update();
            peas.update();
    }
    State state = new State(this);
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(gameState == inventoryState) {
            state.draw(g2);
            state.drawDeck(g2);
        }
        if(gameState == playState) {
            state.drawDeck(g2);
            map.draw(g2);
            w.draw(g2);
            peas.draw(g2);

            for(int i=0; i<Batch.length; i++) {
                if(Batch[i] != null) {
                    Batch[i].draw(g2);
                }
            }

        }
        g2.dispose();
    }
}