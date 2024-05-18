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
    public Inventory(WindowPanel wp) {
        this.wp = wp;
    }

    public void set() {
        wp.Inventory.add(new Cactus(wp, kh));
        wp.Inventory.add(new Jalapeno(wp, kh));
        wp.Inventory.add(new Lilypad(wp, kh));
        wp.Inventory.add(new PeaShooter(wp, kh));
        wp.Inventory.add(new Repeater(wp, kh));
        wp.Inventory.add(new SnowPea(wp, kh));
        wp.Inventory.add(new Squash(wp, kh));
        wp.Inventory.add(new Sunflower(wp, kh));
        wp.Inventory.add(new Tallnut(wp, kh));
        wp.Inventory.add(new Wallnut(wp, kh));
    }
    public void deck() {
        for(Plant plant : wp.Inventory) {
            if(plant.x == wp.state.cursorX && plant.y == wp.state.cursorY) {
//                System.out.print(wp.Deck.size());
                if(wp.Deck.size() < 6) {
                    wp.Deck.add(plant);
                    wp.Inventory.remove(plant);
                    break;
                }
            }
        }
    }

    public void removeFromDeck() {
        for(Plant plant : wp.Deck) {
//            System.out.print(wp.Deck.size());
            if(plant.x == wp.state.cursorX && plant.y == wp.state.cursorY) {
                wp.Inventory.add(plant);
                wp.Deck.remove(plant);
                System.out.print(wp.Deck.size());
                break;
            }
        }
    }
}
