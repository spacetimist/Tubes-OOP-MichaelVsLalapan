package main.GUI;

import main.Game.Map.Map;
import main.Game.ParentClass.Plant;

import java.awt.*;
import java.text.DecimalFormat;

public class State {
    WindowPanel wp;
    public int cursorY;
    public int cursorX;
    public int plantX;
    public int plantY;
    public int Col = 0;
    public int Row = 0 ;
    public int inventoryX;
    public int inventoryY;
    public int plantMapX;
    public int plantMapY;
    public int deckX;
    public int deckY;
    Font arial;
    public boolean messageOn = false;
    Graphics2D g2;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public State(WindowPanel wp) {
        this.wp = wp;
        arial = new Font("Arial", Font.PLAIN, 40);
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial);
        g2.setColor(Color.WHITE);

        if(wp.gameState == wp.playState) {
            drawDeck();
            deckX = 2*wp.tileSize;
            deckY = 7*wp.tileSize;
            plantX = wp.tileSize;
            plantY = wp.tileSize;
            drawPlant();
            drawCursor(deckX, deckY);
        }
        if(wp.gameState == wp.plantingState) {
//            wp.planting.selectTile();
        }
        if(wp.gameState == wp.inventoryState) {
            drawInventory();
            drawDeck();
            inventoryX = 3*wp.tileSize;
            inventoryY = 2*wp.tileSize;

            drawCursor(inventoryX, inventoryY);
        }
        if(wp.gameState == wp.deckState) {
            drawInventory();
            drawDeck();
            deckX = 2*wp.tileSize;
            deckY = 7*wp.tileSize;
            drawCursor(deckX, deckY);
        }
    }

    public void drawInventory() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 40F));
        String text = "Inventory";
        String text2 = "Press 'S' to Start";
        int x = centerX(text);
        int y = wp.tileSize;
        int x1 = wp.tileSize;
        int y1 = 6*wp.tileSize;

        inventoryX = 3*wp.tileSize;
        inventoryY = 2*wp.tileSize;

        for (Plant plant : wp.Inventory) {
            g2.drawImage(plant.img, inventoryX, inventoryY, wp.tileSize, wp.tileSize, null);
            plant.x = inventoryX;
            plant.y = inventoryY;

            if(inventoryX == 7*wp.tileSize) {
                inventoryY += wp.tileSize;
                inventoryX = 2*wp.tileSize;
            }
            inventoryX += wp.tileSize;
        }

        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
        g2.drawString(text2, x1, y1);

    }

    public void drawDeck() {
        for(int j=1; j<=9; j++){
            wp.map.coordinate[j][7] = 5;
        }
        int col = 0;
        deckX = 2*wp.tileSize;
        deckY = 7*wp.tileSize;

        while(col < 6) {
//            g2.drawImage(wp.map.area.tile[5].img, x, y, wp.tileSize, wp.tileSize, null);
            wp.map.area.draw(g2, deckX, deckY, 5);
            col++;
            deckX += wp.tileSize;

        }
        wp.map.area.draw(g2, deckX, deckY, 6); // draw shovel
        drawDeckContent();
    }

    public void drawDeckContent() {
        int i = 0;
        for (Plant plant : wp.Deck) {
            g2.drawImage(plant.img, (i+2)*wp.tileSize, 7*wp.tileSize, null);
            plant.x = (i+2)*wp.tileSize;
            plant.y = 7*wp.tileSize;
            i++;
        }
    }
    public void drawCursor(int startX, int startY) {
        cursorX = startX + (wp.tileSize * Col);
        cursorY = startY + (wp.tileSize * Row);

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
//        if(!wp.map.hasPlant[cursorX][cursorY]) {
//
//        }
            g2.drawRoundRect(cursorX, cursorY, wp.tileSize, wp.tileSize, 10, 10);

    }

//    public void drawCursor2(int startX, int startY) {
//        cursorX = startX + (wp.tileSize * plantCol);
//        cursorY = startY + (wp.tileSize * plantRow);
//
//        g2.setColor(Color.WHITE);
//        g2.setStroke(new BasicStroke(3));
////        if(!wp.map.hasPlant[cursorX][cursorY]) {
////
////        }
//        g2.drawRoundRect(cursorX, cursorY, wp.tileSize, wp.tileSize, 10, 10);
//
//    }

    public int plantCol = 0;
    public int plantRow = -1 ;

    public void drawPlant() {

//        wp.map.hasPlant[x][y] = true;
        plantMapX = 1;
        plantMapY = 1;

//        while(plantMapY <= 6 && wp.map.hasPlant[plantMapX][plantMapY]) {
//            while(plantMapX <= 9 && wp.map.hasPlant[plantMapX][plantMapY]) {
//                plantMapX++;
//                break;
//            }
//            plantMapY++;
//            break;
//        }

        plantX = plantMapX*wp.tileSize + (wp.tileSize * plantCol);
        plantY = plantMapY*wp.tileSize + (wp.tileSize * plantRow);
        System.out.println(plantCol);
        System.out.println(plantRow);
        if(wp.PlantList.size() != 0) {
            Plant plant = wp.PlantList.get(wp.PlantList.size() - 1);
            g2.drawImage(plant.img, plantX, plantY, null);

        }

    }
    public int centerX(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = wp.screenWidth/2 - length/2;
        return x;
    }
}
