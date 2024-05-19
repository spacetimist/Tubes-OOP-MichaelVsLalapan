package main.GUI;

import main.Game.*;
import main.Game.Map.Map;
import main.Game.Menu;
import main.Game.ParentClass.Plant;
import main.Game.ParentClass.Zombie;
import main.Game.Plants.*;
import main.Game.Zombies.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
    public Map map = new Map(this);
    KeyHandler kh = new KeyHandler(this);
    Thread gameThread;

    // instantiate collision
    public Collision collision = new Collision(this);

    // instantiate plant list, zombie list
    public ArrayList<Plant> PlantList = new ArrayList<>();
    public ArrayList<Zombie> ZombieList = new ArrayList<>();
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
    public final int plantingState = 4;
    public final int menuState = 5;

    //LIST OF ALL CHARACTERS
    public List<Plant> plantList = new ArrayList<>();
    public List<Zombie> zombieList = new ArrayList<>();
    Menu<Plant> plantMenu = new Menu<>(this, plantList);
    Menu<Zombie> zombieMenu = new Menu<>(this, zombieList);
    int i;

    public WindowPanel() {
        i = 0;
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(kh);
        this.setFocusable(true);
        initializeCharacters();
    }

    public void initializeCharacters() {
        plantList.add(new Cactus(this, kh));
        plantList.add(new Jalapeno(this, kh));
        plantList.add(new Lilypad(this, kh));
        plantList.add(new PeaShooter(this, kh));
        plantList.add(new Repeater(this, kh));
        plantList.add(new SnowPea(this, kh));
        plantList.add(new Squash(this, kh));
        plantList.add(new Sunflower(this, kh));
        plantList.add(new Tallnut(this, kh));
        plantList.add(new Wallnut(this, kh));

        zombieList.add(new BalloonZombie((this)));
        zombieList.add(new BucketheadZombie((this)));
        zombieList.add(new ConeheadZombie((this)));
        zombieList.add(new DolphinRiderZombie((this)));
        zombieList.add(new DuckyTubeZombie((this)));
        zombieList.add(new FootballZombie((this)));
        zombieList.add(new NewspaperZombie((this)));
        zombieList.add(new NormalZombie((this)));
        zombieList.add(new PoleVaultingZombie((this)));
        zombieList.add(new ScreenDoorZombie((this)));
    }

    public void setUp() {
        gameState = menuState; // initial state
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
        if(gameState == playState || gameState == plantingState) {
            zSpawn.run();
        }
    }
    public State state = new State(this);
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        if(gameState == menuState) {
            state.draw(g2);
        }
        if(gameState == inventoryState) {
            state.draw(g2);
        }
        if(gameState == deckState) {
            state.draw(g2);
        }
        if(gameState == playState || gameState == plantingState) {
            map.draw(g2);

            for(int i=0; i<Batch.length; i++) {
                if(Batch[i] != null) {
                    Batch[i].draw(g2);
                }
            }
            state.draw(g2);
            state.drawPlant(g2);

        }
        g2.dispose();
    }
}