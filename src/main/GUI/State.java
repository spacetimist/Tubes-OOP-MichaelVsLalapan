package main.GUI;

import main.Game.Map.Map;

import java.awt.*;
import java.text.DecimalFormat;

public class State {
    WindowPanel wp;
    public int cursorY;
    public int cursorX;
    public int Col = 0;
    public int Row = 0 ;
    public int inventoryX;
    public int inventoryY;
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

        }
        if(wp.gameState == wp.inventoryState) {
            drawInventory();
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

        for(int i=0; i<10; i++) {
            g2.drawImage(wp.Inventory[i].img, inventoryX, inventoryY, wp.tileSize, wp.tileSize, null);
            wp.Inventory[i].x = inventoryX;
            wp.Inventory[i].y = inventoryY;

            if(inventoryX == 7*wp.tileSize) {
                inventoryY += wp.tileSize;
                inventoryX = 2*wp.tileSize;
            }
            inventoryX += wp.tileSize;
        }

        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
        g2.drawString(text2, x1, y1);

        inventoryX = 3*wp.tileSize;
        inventoryY = 2*wp.tileSize;

        drawCursor(inventoryX, inventoryY);

    }

    public void drawDeck(Graphics2D g2) {
        this.g2 = g2;
        for(int j=1; j<=9; j++){
            wp.map.coordinate[j][7] = 5;
        }
        int col = 0;
        int x = 2*wp.tileSize;
        int y = 7*wp.tileSize;

        while(col < 7) {
//            g2.drawImage(wp.map.area.tile[5].img, x, y, wp.tileSize, wp.tileSize, null);
            wp.map.area.draw(g2, x, y, 5);
            col++;
            x += wp.tileSize;

        }
        drawDeckContent();
    }

    public void drawDeckContent() {
        for(int i=0; i<6; i++) {
            if(wp.Deck[i] != null) {
                g2.drawImage(wp.Deck[i].img, (i+2)*wp.tileSize, 7*wp.tileSize, null);
//                System.out.println(wp.Deck[i].name);
            }
        }
    }
    public void drawCursor(int startX, int startY) {
        cursorX = startX + (wp.tileSize * Col);
        cursorY = startY + (wp.tileSize * Row);

        g2.setColor(Color.WHITE);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, wp.tileSize, wp.tileSize, 10, 10);
    }

    public void update() {

    }
    public int centerX(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = wp.screenWidth/2 - length/2;
        return x;
    }
}
