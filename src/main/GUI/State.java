package main.GUI;

import main.Game.Map.Map;
import main.Game.ParentClass.*;
import main.Game.ParentClass.Zombie;
import main.Game.Plants.Cactus;
import main.Game.Menu;

import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;

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

    public int command = 0;
    public int menuScreenState = 0;
    Font f1;
    public boolean messageOn = false;
    Graphics2D g2;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;



    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public State(WindowPanel wp) {
        this.wp = wp;
        f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(f1);
        g2.setColor(Color.WHITE);

        if(wp.gameState == wp.playState) {
            drawDeck();
            deckX = 2*wp.tileSize;
            deckY = 7*wp.tileSize;
            drawCursor(deckX, deckY);
//            movePlant();
            drawPlant(g2);
        }
        if(wp.gameState == wp.plantingState) {
            plantX = wp.tileSize;
            plantY = wp.tileSize;
            movePlant();
            drawPlant(g2);
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
        if(wp.gameState == wp.menuState) {
            drawMenu();
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

    public void drawCursor2(int startX, int startY) {
        cursorX = startX + (wp.tileSize * plantCol);
        cursorY = startY + (wp.tileSize * plantRow);

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
//        while(cursorX/60 <= 6 && wp.map.hasPlant[cursorX/60][cursorY/60]) {
//            while(cursorY/60 <= 9 && wp.map.hasPlant[cursorX/60][cursorY/60]) {
//                cursorX += wp.tileSize;
//                break;
//            }
//            cursorY += wp.tileSize;
//            break;
//        }
        g2.drawRoundRect(cursorX, cursorY, wp.tileSize, wp.tileSize, 10, 10);

    }

    public int plantCol = 0;
    public int plantRow = 0 ;

    public void movePlant() {
        plantMapX = 1;
        plantMapY = 1;
        if(wp.PlantList.size() != 0) {
            Plant plant = wp.PlantList.get(wp.PlantList.size() - 1);
            plantX = plantMapX*wp.tileSize + (wp.tileSize * plantCol);
            plantY = plantMapY*wp.tileSize + (wp.tileSize * plantRow);
            plant.setDefaultValues(plantX, plantY);

//            if(!wp.map.hasPlant[plant.x/60][plant.y/60]) {
//            wp.map.hasPlant[plant.x/60][plant.y/60] = true;
//
//            }
//            else {
//                if(plantCol < 8) {
//                    plantCol++;
//                }else{
//                    if(plantRow < 5) {
//                        plantRow++;
//                        plantCol = 0;
//                    }
//                }
//            }
        }

    }

    public void drawPlant(Graphics2D g2) {
        this.g2 = g2;
        for(Plant plant : wp.PlantList) {
//            plant.x3 = plant.x2;
//            plant.y3 = plant.y2;
            int fixedPlantX = plant.x;
            int fixedPlantY = plant.y;
//            plant.x = fixedPlantX;
//            plant.y = fixedPlantY;
//            plant.draw(g2);

            g2.drawImage(plant.img, fixedPlantX, fixedPlantY, null);

            wp.map.hasPlant[fixedPlantX / 60][fixedPlantY / 60] = true;
        }
    }

    public void drawMenu() {
        if(menuScreenState == 0) {
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 56F));
            String text = "Michael Vs. Lalapan";
            int x = centerX(text);
            int y = 120;
            g2.setColor(Color.WHITE);
            g2.drawString(text, x, y);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 20F));
            text = "START";
            x = centerX(text);
            y += 90;
            g2.drawString(text, x, y);
            if(command == 0) {
                g2.drawString(">", x-30, y);
            }

            text = "HELP";
            x = centerX(text);
            y += 30;
            g2.drawString(text, x, y);
            if(command == 1) {
                g2.drawString(">", x-30, y);
            }

            text = "PLANTS LIST";
            x = centerX(text);
            y += 30;
            g2.drawString(text, x, y);
            if(command == 2) {
                g2.drawString(">", x-30, y);
            }

            text = "ZOMBIES LIST";
            x = centerX(text);
            y += 30;
            g2.drawString(text, x, y);
            if(command == 3) {
                g2.drawString(">", x-30, y);
            }

            text = "EXIT";
            x = centerX(text);
            y += 30;
            g2.drawString(text, x, y);
            if(command == 4) {
                g2.drawString(">", x-30, y);
            }
        }
        else if(menuScreenState == 2) {
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 14F));
            wp.plantMenu.drawList(g2);
        }
        else if(menuScreenState == 3) {
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 14F));
            wp.zombieMenu.drawList(g2);
        }
    }
    public int centerX(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = wp.screenWidth/2 - length/2;
        return x;
    }
}
