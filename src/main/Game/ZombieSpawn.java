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
    int[] lane = {1, 2, 3, 4, 5, 6};

    public ZombieSpawn(WindowPanel wp) {
        this.wp = wp;
        random = new Random();
    }

    public void set() {
        // 10 zombie yang dispawn
        int i = 0;
        while (i < 10) {
            int laneIndex;

            laneIndex = selectLaneIndex(); // Memilih jalur secara acak prob 0.3

            // spawn generated zombie into randomly picked lane
            if(laneIndex != 999) {
                wp.ZombieList[i] = generateRandomZombie(); // Menghasilkan zombie secara acak
                if (wp.ZombieList[i].is_aquatic) {
                    if(laneIndex != 2 && laneIndex != 3) {
                        while(wp.ZombieList[i].is_aquatic) {
                            wp.ZombieList[i] = generateRandomZombie();
                        }
                    }
                    wp.ZombieList[i].setDefaultValues(lane[laneIndex]);
                } else {
                    if(laneIndex == 2 || laneIndex == 3) {
                        while(!wp.ZombieList[i].is_aquatic) {
                            wp.ZombieList[i] = generateRandomZombie();
                        }
                    }
                    wp.ZombieList[i].setDefaultValues(lane[laneIndex]);
                }
            }
            System.out.println(laneIndex);
            i++;
        }
    }

    private int selectLaneIndex() {
        int j;
        for(j=0; j<6; j++) {
            if (random.nextInt(3) == 0) { // probability 0.3
                return j;
            }
        }
        return 999;
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
                for(int i=0; i<wp.ZombieList.length; i++) {
                    if(wp.ZombieList[i] != null) {
                        wp.ZombieList[i].update();
                    }
                }
                // Memanggil metode set() setiap detik
            }
        });
        timer.start(); // Memulai timer
    }

}
