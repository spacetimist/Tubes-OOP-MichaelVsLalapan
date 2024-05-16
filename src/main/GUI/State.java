package main.GUI;

import main.Game.Map.Map;

import java.awt.*;
import java.text.DecimalFormat;

public class State {
    WindowPanel wp;
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

        int col = 2*wp.tileSize;
        int row = 2*wp.tileSize;
        for(int i=0; i<10; i++) {
            col += wp.tileSize;
            g2.drawImage(wp.PlantList[i].img, col, row, wp.tileSize, wp.tileSize, null);

            if(col == 7*wp.tileSize) {
                row += wp.tileSize;
                col = 2*wp.tileSize;
            }
        }

        g2.drawString(text, x, y);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 20F));
        g2.drawString(text2, x1, y1);
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
    }
    public int centerX(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = wp.screenWidth/2 - length/2;
        return x;
    }
}
