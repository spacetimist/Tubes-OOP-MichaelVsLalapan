package main.Game;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;
import main.Game.Plants.*;

import javax.swing.*;
import java.awt.*;
import java.rmi.server.ServerNotActiveException;

public class Planting {
    WindowPanel wp;
    KeyHandler kh;
    JDialog dialog = new JDialog((Frame) null, "Invalid Input", true);
    public Planting(WindowPanel wp) {
        this.wp = wp;
    }

    public void selectTile() {
        if(wp.xValue >= 1 && wp.xValue <= 9 && wp.yValue >= 1 && wp.yValue <= 6) {
            for(Plant plant : wp.Deck) {
                if(plant.x == wp.state.cursorX && plant.y == wp.state.cursorY) {
//                System.out.print(wp.Deck.size());
                    Plant newPlant = null;
                    if (plant instanceof Cactus) {
                        newPlant = new Cactus(wp, kh);
                    }
                    if (plant instanceof Jalapeno) {
                        newPlant = new Jalapeno(wp, kh);
                    }
                    if (plant instanceof Lilypad) {
                        newPlant = new Lilypad(wp, kh);
                    }
                    if (plant instanceof PeaShooter) {
                        newPlant = new PeaShooter(wp, kh);
                    }
                    if (plant instanceof Repeater) {
                        newPlant = new Repeater(wp, kh);
                    }
                    if (plant instanceof SnowPea) {
                        newPlant = new SnowPea(wp, kh);
                    }
                    if (plant instanceof Squash) {
                        newPlant = new Squash(wp, kh);
                    }
                    if (plant instanceof Sunflower) {
                        newPlant = new Sunflower(wp, kh);
                    }
                    if (plant instanceof Tallnut) {
                        newPlant = new Tallnut(wp, kh);
                    }
                    if (plant instanceof Wallnut) {
                        newPlant = new Wallnut(wp, kh);
                    }

                    wp.PlantList.add(newPlant);
                    newPlant.setDefaultValues(wp.xValue, wp.yValue);
                    wp.map.hasPlant[wp.xValue][wp.yValue] = true;
//                System.out.println("pass selectTile");
                    break;
                }
            }
            if(wp.state.cursorX == 8*wp.tileSize && wp.state.cursorY == 7*wp.tileSize) {
                if(wp.map.hasPlant[wp.xValue][wp.yValue]) {
                    for(Plant plant:wp.PlantList) {
                        if(plant.x == wp.xValue*wp.tileSize && plant.y == wp.yValue*wp.tileSize) {
                            wp.PlantList.remove(plant);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(dialog, "There's no plant in that coordinate");
                }
            }
        }else{
            JOptionPane.showMessageDialog(dialog, "Please enter x between 1-9 and y between 1-6");
        }
    }
}
