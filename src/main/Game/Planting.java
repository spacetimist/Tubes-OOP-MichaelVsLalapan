package main.Game;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;
import main.Game.Plants.*;

import java.rmi.server.ServerNotActiveException;

public class Planting {
    WindowPanel wp;
    KeyHandler kh;
    public Planting(WindowPanel wp) {
        this.wp = wp;
    }

    public void selectTile() {
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
//                System.out.println("pass selectTile");
                break;
            }
        }
    }
}
