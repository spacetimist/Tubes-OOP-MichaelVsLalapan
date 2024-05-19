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

    public void set() {
        // 10 zombie yang dispawn

        int j;
        int i;
        wp.ZombieList.add(generateRandomZombie()); // Menghasilkan zombie secara acak
        for (Zombie zombie : wp.ZombieList) {
            j = 0;
            i = 0;

            while (i < 6) {
                int laneIndex;
                if (random.nextInt(3) == 0) {
                    if (zombie.is_aquatic) {
                        if (i != 2 && i != 3) {
                            while (zombie.is_aquatic) {
                                zombie = generateRandomZombie();
                            }
                        }
                        zombie.setDefaultValues(lane[i]);
                        wp.Batch[j] = zombie;
                    } else {
                        if (i == 2 || i == 3) {
                            while (!zombie.is_aquatic) {
                                zombie = generateRandomZombie();
                            }
                        }
                        zombie.setDefaultValues(lane[i]);
                        wp.Batch[j] = zombie;
                    }
                    j++;
                    if (j == i) {
                        j = 0;
//                        this.set();
                    }
                }
                i++;
                System.out.println(i);
                System.out.println(j);
            }
            // Memilih jalur secara acak prob 0.3


            // spawn generated zombie into randomly picked lane

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
        for(int i=0; i<wp.Batch.length; i++) {
            if(wp.Batch[i] != null) {
                wp.Batch[i].update();
            }
        }
//        try {
//            Thread.sleep(1000); // Menunda eksekusi selama 1000 milidetik (1 detik)
//        } catch (InterruptedException e) {
//            // Tangani eksepsi jika terjadi
//            e.printStackTrace();
//        }
    }

}