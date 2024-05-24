package main.Game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import main.GUI.WindowPanel;
import main.Game.ParentClass.Zombie;
import main.Game.Zombies.*;

import javax.swing.*;

public class ZombieSpawn extends Thread {
    WindowPanel wp;
    Random random;
    int[] lane = {1, 2, 3, 4, 5, 6};

    public ZombieSpawn(WindowPanel wp) {
        this.wp = wp;
        random = new Random();
    }

    public void spawnBatch() {
        if(wp.ZombieList.size() < 7 && (wp.state.playTime % 200) >= 20 && (wp. state.playTime % 200) <= 160) {
            int j = 0;
            for (int i = 0; i < 6; i++) {
                // Cek apakah zombie sesuai dengan lane
                if (random.nextInt(3) == 0) {
                    Zombie zombie = generateRandomZombie();
                    if (!zombie.is_aquatic && (i == 2 || i == 3)) {
                        while(!zombie.is_aquatic) {
                            zombie = generateRandomZombie();
                        }
                    } else if (zombie.is_aquatic && (i != 2 && i != 3)) {
                        while(zombie.is_aquatic) {
                            zombie = generateRandomZombie();
                        }
                    }
                    zombie.setDefaultValues(lane[i]);
                    wp.Batch[j] = zombie;
                    wp.ZombieList.add(zombie); // Tambahkan zombie baru ke list
                    j++;
                }
            }
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
    @Override
    public void run() {
        while (true) {
            spawnBatch();
            try {
                Thread.sleep(3000); // Menunda eksekusi selama 1000 milidetik (1 detik)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}