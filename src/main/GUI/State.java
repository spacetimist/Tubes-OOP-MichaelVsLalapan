package main.GUI;


import main.Game.ParentClass.*;

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
    public int deckX;
    public int deckY;

    public int command = 0;
    public int menuScreenState = 0;
    Font f1,f2;
    Graphics2D g2;
    int messageCounter = 0;
    public boolean win = false;
    public boolean lose = false;

    public double playTime = 0;
    DecimalFormat dFormat = new DecimalFormat("#0.00");

    public State(WindowPanel wp) {
        this.wp = wp;
        f1 = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
        f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 80);
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(f1);
        g2.setColor(Color.WHITE);

        if(wp.gameState == wp.finished) {
            String text = "";
            int textLength, x, y;
            g2.setFont(f2);
            if(win) {
                g2.setColor(Color.YELLOW);
                text = "You Win!";
            }
            if(lose) {
                g2.setColor(Color.RED);
                text = "Game Over";
            }
            textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
            x = wp.screenWidth/2 - textLength/2;
            y = wp.screenWidth/2 - wp.tileSize;
            drawPlant(g2);
            playTime();
            g2.drawString(text, x, y);
        }

        if(wp.gameState == wp.playState) {
            drawDeck();
            deckX = 2*wp.tileSize;
            deckY = 7*wp.tileSize;
            drawCursor(deckX, deckY);
            drawPlant(g2);
            drawSun();
            playTime();
            exitCondition();
        }
        if(wp.gameState == wp.plantingState) {
            drawDeck();
            deckX = 2*wp.tileSize;
            deckY = 7*wp.tileSize;
            drawCursor(deckX, deckY);
//            movePlant();
            drawPlant(g2);
            drawSun();
            playTime();
            exitCondition();
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

    public void drawPlant(Graphics2D g2) {
        this.g2 = g2;
        for(Plant plant : wp.PlantList) {

            plant.draw(g2);

        }
    }

    public void drawSun() {
        String text = String.valueOf(wp.sun.totalSun);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 25F));
        int x = 60;
        int y = 7*60;
        g2.drawString(text, x, y + 40);
        g2.drawImage(wp.sun.img, 0, y, null);
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

        else if(menuScreenState == 1) {
            g2.setColor(Color.WHITE);
            String text = "HELP";
            int x = centerX(text);
            int y = 40;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 30F));
            g2.drawString(text, x, y);
            x = 110;
            y += 30;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));
            g2.setColor(Color.YELLOW);
            g2.drawString("Roro Jonggrang diserang oleh pasukan jin yang menjadi zombie.", x, y);
            x = 130;
            y += 20;
            g2.drawString("Bandung Bondowoso ingin menyelamatkan istri tercintanya.", x, y);
            x = 65;
            y += 20;
            g2.drawString("Ia memiliki benih tanaman berkemampuan khusus tetapi bingung mencari strategi.", x, y);
            x = 135;
            y += 20;
            g2.setColor(Color.RED);
            g2.drawString("Bantulah Bandung Bondowoso untuk menyusun strategi!!", x, y);

            g2.setColor(Color.WHITE);
            x = 250;
            y += 40;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            g2.drawString("Aturan permainan", x, y);
            x = 80;
            y += 20;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));
            g2.drawString("1. Start game", x, y);
            y += 20;
            g2.drawString("2. Pilih dan masukkan tanaman dari inventory ke deck", x, y);
            y += 20;
            g2.drawString("3. Deck harus terisi penuh dengan 6 plant", x, y);
            y += 20;
            g2.drawString("4. Press 'S' dan permainan dimulai", x, y);
            y += 20;
            g2.drawString("5. Tanam tanaman yang ada di deck ke dalam map dengan cara 'ENTER'", x, y);
            y += 20;
            g2.drawString("6. Terus menanam hingga zombie mati dan permainan selesai", x, y);

            x = 280;
            y += 40;
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 15F));
            g2.drawString("Command", x, y);
            x = 80;
            y += 20;
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));
            g2.drawString("1. 'ESC' untuk keluar dari menu help, plants list dan zombies list", x, y);
            y += 20;
            g2.drawString("2. 'I' untuk pindah dari deck ke inventory", x, y);
            y += 20;
            g2.drawString("3. 'D' untuk pindah dari inventory ke deck", x, y);
            y += 20;
            g2.drawString("4. 'SPACE' untuk memilih tanaman dari inventory", x, y);
            y += 20;
            g2.drawString("5. 'ENTER' untuk mengembalikan tanaman ke inventory", x, y);
            y += 20;
            g2.drawString("6. 'SHIFT' untuk swap posisi plant di deck maupun inventory", x, y);
        }

        else if(menuScreenState == 2) {
            g2.setColor(Color.WHITE);
            wp.plantMenu.drawListPlant(g2);
        }
        else if(menuScreenState == 3) {
            g2.setColor(Color.WHITE);
            wp.zombieMenu.drawListZombie(g2);
        }
    }

    public void playTime() {
        if(wp.gameState == wp.finished) {
            playTime += 0;
        }else {
            playTime += (double) 1/wp.fps;
            String text = "Time: " + dFormat.format(playTime);
            g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 15F));
            int x = 550;
            int y = 7*60;
            g2.drawString(text, x, y + 40);
        }
    }
    public int centerX(String text) {
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = wp.screenWidth/2 - length/2;
        return x;
    }

    public void exitCondition() {
        if(wp.ZombieList.size() == 0 && playTime > 20) {
            win = true;
            wp.gameState = wp.finished;
        }
    }
}
