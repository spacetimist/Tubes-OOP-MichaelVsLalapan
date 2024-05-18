package main.GUI;

import main.Game.Inventory;
import main.Game.Map.Map;
import main.Game.ParentClass.Plant;
import main.Game.ParentClass.Zombie;
import main.Game.Planting;
import main.Game.Plants.*;
import main.Game.ZombieSpawn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class WindowPanel extends JPanel implements Runnable {
    final int originalTileSize = 20;

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
    public Plant PlantList[] = new Plant[72]; // jumlah semua tile yg bisa ditanamin plus 18 lilypad
    public Zombie ZombieList[] = new Zombie[10];
    // deck and inventory
    public ArrayList<Plant> Deck = new ArrayList<>(6);
    public ArrayList<Plant> Inventory = new ArrayList<>(10);
    // batch
    public Zombie Batch[] = new Zombie[6];

    // instantiate setter
    Planting planting = new Planting(this);

    ZombieSpawn zSpawn = new ZombieSpawn(this);
    Inventory inv = new Inventory(this);

    // game state
    public int gameState;
    public final int playState = 1;
    public final int inventoryState = 2;
    public final int deckState = 3;
    public final int pickingMap = 4;

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
        inv.set();
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
    }
    public State state = new State(this);
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(gameState == inventoryState) {
            state.draw(g2);
        }
        if(gameState == deckState) {
            state.draw(g2);
        }
        if(gameState == playState) {
            map.draw(g2);

            for(int i=0; i<Batch.length; i++) {
                if(Batch[i] != null) {
                    Batch[i].draw(g2);
                }
            }
            state.draw(g2);

        }
        g2.dispose();
    }
}