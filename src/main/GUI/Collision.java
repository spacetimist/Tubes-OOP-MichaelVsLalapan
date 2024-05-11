package main.GUI;

import main.Game.ParentClass.Character;

public class Collision {
    WindowPanel wp;
    public Collision(WindowPanel wp) {
        this.wp = wp;
    }
    public void checkTile(Character c) {
        int characterLeftX = c.x + c.solidArea.x;
        int characterRightX = c.x + c.solidArea.x + c.solidArea.width;
        int characterTopY = c.y + c.solidArea.y;
        int characterBottomY = c.y + c.solidArea.y + c.solidArea.height;

        int characterLeftCol = characterLeftX/wp.tileSize;
        int characterRightCol = characterRightX/wp.tileSize;
        int characterTopRow = characterTopY/wp.tileSize;
        int characterBottomRow = characterBottomY/wp.tileSize;

    }
}
