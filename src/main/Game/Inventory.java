package main.Game;


import main.GUI.KeyHandler;
import main.GUI.State;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;
import main.Game.Plants.*;

import java.security.Key;


public class Inventory {
    WindowPanel wp;
    KeyHandler kh;
    State state;

    public Inventory(WindowPanel wp) {
        this.wp = wp;
    }

    public void set() {
        wp.Inventory[0] = new Cactus(wp, kh);
        wp.Inventory[1] = new Jalapeno(wp, kh);
        wp.Inventory[2] = new Lilypad(wp, kh);
        wp.Inventory[3] = new PeaShooter(wp, kh);
        wp.Inventory[4] = new Repeater(wp, kh);
        wp.Inventory[5] = new SnowPea(wp, kh);
        wp.Inventory[6] = new Squash(wp, kh);
        wp.Inventory[7] = new Sunflower(wp, kh);
        wp.Inventory[8] = new Tallnut(wp, kh);
        wp.Inventory[9] = new Wallnut(wp, kh);

    }
    Plant picked;
    public void deck() {
        picked = getPlant(wp.state.cursorX, wp.state.cursorY);
        int i = 0;
        while(wp.Deck[i] != null && i < 6) {
            i++;
        }
        if (wp.Deck[i] == null) {
            wp.Deck[i] = picked;
        }
        wp.Deck[i].x = (i+2)*wp.tileSize;
        wp.Deck[i].y = 7*wp.tileSize;
    }

    public Plant getPlant(int x, int y) {
        int i;
        for(i=0; i<10; i++) {
            if(wp.Inventory[i].x == x && wp.Inventory[i].y == y) {
                break;
            }
        }
//        System.out.println(i);
        return wp.Inventory[i];
    }
}
