package main.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;
import main.Game.Zombies.*;

import javax.swing.*;

public class ZombieSpawn {
    WindowPanel wp;
    Random random;
    int[] grassLane = {1, 2, 5, 6};
    int[] poolLane = {3, 4};
    public ZombieSpawn(WindowPanel wp) {
        this.wp = wp;
        random = new Random();
    }

    public void set() {
        // 10 zombie yang dispawn
        int i = 0;
        while (i < 10) {
                int laneIndex;

                // perbandingan jalur pool:grass adalah 1:2
                if (random.nextDouble() <= 0.3) {
                    laneIndex = selectLaneIndex(); // Memilih jalur secara acak
                    wp.ZombieList[i] = generateRandomZombie(); // Menghasilkan zombie secara acak

                    // spawn generated zombie into randomly picked lane
                    if (wp.ZombieList[i].is_aquatic) {
                        if(laneIndex < poolLane.length) {
                            wp.ZombieList[i].setDefaultValues(poolLane[laneIndex]);
                        } else {
                            while(wp.ZombieList[i].is_aquatic) {
                                wp.ZombieList[i] = generateRandomZombie();
                            }
                            wp.ZombieList[i].setDefaultValues(grassLane[laneIndex]);
                        }
                    } else {
                        wp.ZombieList[i].setDefaultValues(grassLane[laneIndex]);
                    }
                    i++;
            }
        }
    }

    private int selectLaneIndex() {
        if (random.nextInt(3) == 0) { // 1 dari 3 kemungkinan akan memilih jalur air
            return random.nextInt(poolLane.length);
        } else {
            return random.nextInt(grassLane.length);
        }
    }

    // generate random zombie
    private Zombie generateRandomZombie() {
        int zombieType = random.nextInt(10); // Anda punya 10 jenis zombie
        switch (zombieType) {
            case 0:
                return new NormalZombie(wp);
            case 1:
                return new BalloonZombie(wp);
            case 2:
                return new NewspaperZombie(wp);
            case 3:
                return new BucketheadZombie(wp);
            case 4:
                return new ConeheadZombie(wp);
            case 5:
                return new DolphinRiderZombie(wp);
            case 6:
                return new DuckyTubeZombie(wp);
            case 7:
                return new FootballZombie(wp);
            case 8:
                return new PoleVaultingZombie(wp);
            case 9:
                return new ScreenDoorZombie(wp);
        }
        return null;
    }

    public void startSpawnTimer(int i) {
        // Membuat objek Timer dengan interval 1000 milidetik (1 detik)
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wp.ZombieList[i].update();
                // Memanggil metode set() setiap detik
            }
        });
        timer.start(); // Memulai timer
    }

}
