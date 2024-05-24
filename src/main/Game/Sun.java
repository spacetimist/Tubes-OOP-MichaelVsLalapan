package main.Game;

import main.GUI.WindowPanel;
import java.util.Random;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sun implements Runnable {
    WindowPanel wp;
    public BufferedImage img;
    private final Random random = new Random();
    private Thread sunThread;
    private volatile boolean running = true;

    public Sun(WindowPanel wp) {
        this.wp = wp;
        try {
            img = ImageIO.read(new File("src/main/Resources/Tiles/sun.png"));
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int totalSun = 50;

    public void generateSun(){
        totalSun += 25;

    }

    public void startGeneratingSun() {
        if (sunThread == null || !sunThread.isAlive()) {
            sunThread = new Thread(this);
            running = true;
            sunThread.start();
        }
    }

    public void stopGeneratingSun() {
        running = false;
        if (sunThread != null) {
            try {
                sunThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (running) {
            if(wp.state.playTime <= 100) {
                try {
                    int delay = 5000 + random.nextInt(5001); // menghasilkan delay antara 5000 ms (5 detik) dan 10000 ms (10 detik)
                    Thread.sleep(delay);
                    generateSun();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}