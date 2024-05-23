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
        if (wp.xValue >= 1 && wp.xValue <= 9 && wp.yValue >= 1 && wp.yValue <= 6) {
            boolean tileHasPlant = wp.map.hasPlant[wp.xValue][wp.yValue];
            boolean tileHasLilypad = wp.map.hasLilypad[wp.xValue][wp.yValue];
            boolean isPool = wp.yValue == 3 || wp.yValue == 4;

            // Check if the cursor is on the remove plant button
            if (wp.state.cursorX == 8 * wp.tileSize && wp.state.cursorY == 7 * wp.tileSize) {
                if (tileHasPlant) {
                    for (Plant plant : wp.PlantList) {
                        if (plant.x == wp.xValue * wp.tileSize && plant.y == wp.yValue * wp.tileSize) {
                            wp.PlantList.remove(plant);
                            wp.map.hasPlant[wp.xValue][wp.yValue] = false;
                            break;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(dialog, "There's no plant in that area.");
                }
                return; // Exit the method after attempting to remove a plant
            }

            for (Plant plant : wp.Deck) {
                if (plant.x == wp.state.cursorX && plant.y == wp.state.cursorY) {
                    long currentTime = System.currentTimeMillis();
                    long timeSinceLastPlant = (currentTime - plant.lastPlantedTime) / 1000; // in seconds

                    if (timeSinceLastPlant < plant.cooldown) {
                        JOptionPane.showMessageDialog(dialog, "You must wait " + (plant.cooldown) + " seconds to plant another " + plant.name);
                    } else {
                        if (wp.sun.totalSun < plant.cost) {
                            JOptionPane.showMessageDialog(dialog, "Not enough sun! " + plant.name + " costs " + plant.cost);
                        } else {
                            Plant newPlant = createNewPlantInstance(plant);
                            if (newPlant != null) {
                                boolean planted = false;
                                if (isPool) {
                                    if (newPlant instanceof Lilypad) {
                                        if (!tileHasLilypad) {
                                            plantInTile(newPlant, currentTime);
                                            wp.map.hasLilypad[wp.xValue][wp.yValue] = true;
//                                            planted = true;
                                        } else {
                                            JOptionPane.showMessageDialog(dialog, "There's already a Lilypad here.");
                                        }
                                    } else if (tileHasLilypad && !tileHasPlant) {
                                        plantInTile(newPlant, currentTime);
                                        planted = true;
                                    } else if (!tileHasLilypad) {
                                        JOptionPane.showMessageDialog(dialog, "You have to put a Lilypad first.");
                                    } else if (tileHasLilypad && tileHasPlant) {
                                        JOptionPane.showMessageDialog(dialog, "This area already has a plant.");
                                    }
                                } else {
                                    System.out.println(tileHasPlant);
                                    if (newPlant instanceof Lilypad) {
                                        JOptionPane.showMessageDialog(dialog, "Lilypad can only be planted in the pool area.");
                                    } else if (!tileHasPlant) {
                                        plantInTile(newPlant, currentTime);
                                        planted = true;
                                    } else {
                                        JOptionPane.showMessageDialog(dialog, "This area already has a plant.");
                                    }
                                }
                                if(planted) {
                                    plant.lastPlantedTime = currentTime; // Update the cooldown time for the plant type in the deck
                                    wp.map.hasPlant[wp.xValue][wp.yValue] = true;
                                }
                            }
                            break;
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(dialog, "The x must be between 1-9 and y between 1-6.");
        }
    }

    private Plant createNewPlantInstance(Plant plant) {
        if (plant instanceof Cactus) return new Cactus(wp, kh);
        if (plant instanceof Jalapeno) return new Jalapeno(wp, kh);
        if (plant instanceof Lilypad) return new Lilypad(wp, kh);
        if (plant instanceof PeaShooter) return new PeaShooter(wp, kh);
        if (plant instanceof Repeater) return new Repeater(wp, kh);
        if (plant instanceof SnowPea) return new SnowPea(wp, kh);
        if (plant instanceof Squash) return new Squash(wp, kh);
        if (plant instanceof Sunflower) return new Sunflower(wp, kh);
        if (plant instanceof Tallnut) return new Tallnut(wp, kh);
        if (plant instanceof Wallnut) return new Wallnut(wp, kh);
        return null;
    }

    private void plantInTile(Plant newPlant, long currentTime) {
        wp.PlantList.add(newPlant);
        newPlant.setDefaultValues(wp.xValue, wp.yValue);
        wp.sun.totalSun -= newPlant.cost;
        newPlant.lastPlantedTime = currentTime;
    }



}
