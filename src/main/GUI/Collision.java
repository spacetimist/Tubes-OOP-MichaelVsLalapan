package main.GUI;

import main.Game.Map.Map;
import main.Game.ParentClass.Plant;
import main.Game.ParentClass.Zombie;

public class Collision {
    WindowPanel wp;
    public Collision(WindowPanel wp) {
        this.wp = wp;
    }
    public void collisionZ(Zombie z) {
        int zLeftX = z.x + z.solidArea.x;
        int zRightX = z.x + z.solidArea.x + z.solidArea.width;
        int zTopY = z.y + z.solidArea.y;
        int zBottomY = z.y + z.solidArea.y + z.solidArea.height;

        int zLeft = zLeftX/wp.tileSize;
        int zBottom = zBottomY/wp.tileSize;

        int tile;

        if(z.direction == "left") {
            zLeft = (int) ((zLeftX - z.speed)/wp.tileSize);
            tile = wp.map.coordinate[zLeft][zBottom];
//            System.out.println("tile: " + tile);
//            System.out.println(zLeft);
//            System.out.println(zBottom);
            if(wp.map.area.tile[tile].collision){
                if(!z.collision) {
                    z.collision = true;
                }
            }
        }
    }
    public void collisionP(Plant p) {
        int pX = p.x/wp.tileSize;
        int pY = p.y/wp.tileSize;
        int pLeftX = p.x;
        int pRightX = p.x + wp.tileSize-1;
        int pTopY = p.y;
        int pBottomY = p.y + wp.tileSize-1;

        int pLeft = pLeftX/wp.tileSize;
        int pBottom = pBottomY/wp.tileSize;
        int pTop = pTopY/wp.tileSize;
        int pRight = pRightX/wp.tileSize;

        int tile;

        switch(p.direction) {

            case "up":
                pTop = (pTopY - wp.tileSize)/wp.tileSize;
                tile = wp.map.coordinate[pLeft][pTop];
                System.out.println("tile: " + tile);
                System.out.println(pLeft);
                System.out.println(pTop);
                if(wp.map.area.tile[tile].collision){
                    if(!p.collision) {
                        p.collision = true;
                    }
                } break;
            case "down":
                pBottom = (pBottomY + wp.tileSize)/wp.tileSize;
                tile = wp.map.coordinate[pLeft][pBottom];
                if(wp.map.area.tile[tile].collision){
                    if(!p.collision) {
                        p.collision = true;
                    }
                } break;
            case "left":
                pLeft = (pLeftX - wp.tileSize)/wp.tileSize;
                tile = wp.map.coordinate[pLeft][pBottom];
                if(wp.map.area.tile[tile].collision){
                    if(!p.collision) {
                        p.collision = true;
                    }
                } break;
            case "right":
                pRight = (pRightX + wp.tileSize)/wp.tileSize;
                tile = wp.map.coordinate[pRight][pBottom];
                if(wp.map.area.tile[tile].collision){
                    if(!p.collision) {
                        p.collision = true;
                    }
                } break;
        }


    }
}
//    public void checkTileZ(Zombie z) {
//        int zLeftX = z.x + z.solidArea.x;
//        int zRightX = z.x + z.solidArea.x + z.solidArea.width;
//        int zTopY = z.y + z.solidArea.y;
//        int zBottomY = z.y + z.solidArea.y + z.solidArea.height;
//
//        int zLeft = zLeftX/wp.tileSize;
//        int zBottom = zBottomY/wp.tileSize;
//
//        int tile;
//
//        if(z.direction == "left") {
//            zLeft = (zLeftX - wp.tileSize)/wp.tileSize;
//            tile = wp.map.coordinate[zLeft][zBottom];
//            if(tile == 2){
//                if(!z.collisionOn) {
//                    z.collisionOn = true;
//                }
//            }
//        }
//
//    }
//    public void checkTile(Plant p) {
//        int pLeftX = p.x + p.solidArea.x;
//        int pRightX = p.x + p.solidArea.x + p.solidArea.width;
//        int pTopY = p.y + p.solidArea.y;
//        int pBottomY = p.y + p.solidArea.y + p.solidArea.height;
//
//        int pLeft = pLeftX/wp.tileSize;
//        int pRight = pRightX/wp.tileSize;
//        int pTop = pTopY/wp.tileSize;
//        int pBottom = pBottomY/wp.tileSize;
//
//        int tile;
//
//        switch(p.direction) {
//            case "up":
//                pTop = (pTopY - wp.tileSize)/wp.tileSize;
//                tile = wp.map.coordinate[pLeft][pTop];
//                if(tile == 1){
//                    if(!p.collisionOn) {
//                        p.collisionOn = true;
//                    }
//                }
//            case "down":
//                pBottom = (pBottomY + wp.tileSize)/wp.tileSize;
//                tile = wp.map.coordinate[pLeft][pBottom];
//                if(tile == 1){
//                    if(!p.collisionOn) {
//                        p.collisionOn = true;
//                    }
//                }
//            case "left":
//                pLeft = (pLeftX - wp.tileSize)/wp.tileSize;
//                tile = wp.map.coordinate[pLeft][pBottom];
//                if(tile == 2){
//                    if(!p.collisionOn) {
//                        p.collisionOn = true;
//                    }
//                }
//            case "right":
//                pRight = (pRightX + wp.tileSize)/wp.tileSize;
//                tile = wp.map.coordinate[pRight][pBottom];
//                if(tile == 3){
//                    if(!p.collisionOn) {
//                        p.collisionOn = true;
//                    }
//                }
//        }
//    }

