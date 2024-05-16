package main.GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    WindowPanel wp;

    public KeyHandler(WindowPanel wp) {
        this.wp = wp;
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(wp.gameState == wp.inventoryState) {
            if(code == KeyEvent.VK_S) {
                wp.gameState = wp.playState;
            }
        }
        if(wp.gameState == wp.playState) {
            if(code == KeyEvent.VK_UP && !upPressed) {
                upPressed = true;
            }
            if(code == KeyEvent.VK_LEFT && !leftPressed) {
                leftPressed = true;
            }
            if(code == KeyEvent.VK_DOWN && !downPressed) {
                downPressed = true;
            }
            if(code == KeyEvent.VK_RIGHT && !rightPressed) {
                rightPressed = true;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if(code == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if(code == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if(code == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }
}