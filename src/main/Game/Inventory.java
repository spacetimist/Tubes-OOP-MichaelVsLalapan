package main.Game;


import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;
import main.Game.Plants.*;

import javax.swing.*;
import java.awt.*;


public class Inventory {
    WindowPanel wp;
    JDialog dialog = new JDialog((Frame) null, "Input Variables", true);
    public Inventory(WindowPanel wp) {
        this.wp = wp;
    }

    public void set() {
        wp.Inventory.add(new Cactus(wp));
        wp.Inventory.add(new Jalapeno(wp));
        wp.Inventory.add(new Lilypad(wp));
        wp.Inventory.add(new PeaShooter(wp));
        wp.Inventory.add(new Repeater(wp));
        wp.Inventory.add(new SnowPea(wp));
        wp.Inventory.add(new Squash(wp));
        wp.Inventory.add(new Sunflower(wp));
        wp.Inventory.add(new Tallnut(wp));
        wp.Inventory.add(new Wallnut(wp));
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

    public void swapPosition(int index1, int index2) {
        index1 -= 1;
        index2 -= 1;

        if(wp.gameState == wp.deckState) {
            // Pastikan kedua indeks berada dalam rentang yang benar
            if (index1 >= 0 && index1 < wp.Deck.size() && index2 >= 0 && index2 < wp.Deck.size()) {
                // Lakukan pertukaran posisi
                Plant temp = wp.Deck.get(index1);
                wp.Deck.set(index1, wp.Deck.get(index2));
                wp.Deck.set(index2, temp);
            } else {
                JOptionPane.showMessageDialog(dialog, "Index must be between 1 and " + (wp.Deck.size()));
            }
        }else if(wp.gameState == wp.inventoryState) {
            // Pastikan kedua indeks berada dalam rentang yang benar
            if (index1 >= 0 && index1 < wp.Inventory.size() && index2 >= 0 && index2 < wp.Inventory.size()) {
                // Lakukan pertukaran posisi
                Plant temp = wp.Inventory.get(index1);
                wp.Inventory.set(index1, wp.Inventory.get(index2));
                wp.Inventory.set(index2, temp);
            } else {
                JOptionPane.showMessageDialog(dialog, "Index must be between 1 and " + (wp.Inventory.size()));
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
