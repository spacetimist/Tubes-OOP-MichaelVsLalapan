package main.Game;

import main.GUI.KeyHandler;
import main.GUI.WindowPanel;
import main.Game.ParentClass.Plant;
import main.Game.Plants.*;

public class Planting {
    WindowPanel wp;
    KeyHandler kh;
    public Planting(WindowPanel wp) {
        this.wp = wp;
    }

    public int planted = 0;

    public void selectTile() {
        int sun = 100;
        for(Plant plant : wp.Deck) {
            if(plant.x == wp.state.cursorX && plant.y == wp.state.cursorY) {
//                System.out.print(wp.Deck.size());
                wp.PlantList.add(plant);
                System.out.println(wp.PlantList.size());
                System.out.println("pass selectTile");
                break;
            }
        }
    }
//    public void plantHere(Plant plant) {
//        plant = new
//    }
}
