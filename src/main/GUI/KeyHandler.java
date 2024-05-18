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
            if(code == KeyEvent.VK_UP) {
                if(wp.state.Row != 0) {
                    wp.state.Row--;
                }
            }
            if(code == KeyEvent.VK_LEFT) {
                if(wp.state.Col != 0) {
                    wp.state.Col--;
                }
            }
            if(code == KeyEvent.VK_DOWN) {
                if(wp.state.Row != 1) {
                    wp.state.Row++;
                }
            }
            if(code == KeyEvent.VK_RIGHT) {
                if(wp.state.Col != 4) {
                    wp.state.Col++;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
                wp.inv.deck();
            }
            if(code == KeyEvent.VK_D) {
                wp.gameState = wp.deckState;
            }
        }
        if(wp.gameState == wp.playState) {
            if(code == KeyEvent.VK_LEFT) {
                if(wp.state.Col != 0) {
                    wp.state.Col--;
                }
            }
            if(code == KeyEvent.VK_RIGHT) {
                if(wp.state.Col != 6) {
                    wp.state.Col++;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
                wp.gameState = wp.plantingState;
                wp.planting.selectTile();
            }

        }
        if(wp.gameState == wp.deckState) {
            if(code == KeyEvent.VK_S) {
                wp.gameState = wp.playState;
            }
            if(code == KeyEvent.VK_LEFT) {
                if(wp.state.Col != 0) {
                    wp.state.Col--;
                }
            }
            if(code == KeyEvent.VK_RIGHT) {
                if(wp.state.Col != 5) {
                    wp.state.Col++;
                }
            }
            if(code == KeyEvent.VK_ENTER) {
                wp.inv.removeFromDeck();
            }
            if(code == KeyEvent.VK_I) {
                wp.gameState = wp.inventoryState;
            }
        }
        if(wp.gameState == wp.plantingState) {
            if(code == KeyEvent.VK_SPACE) {
                wp.gameState = wp.playState;
            }
            if(code == KeyEvent.VK_W) {
                if(wp.state.plantRow != 0) {
                    wp.state.plantRow--;
                }
            }
            if(code == KeyEvent.VK_A) {
                if(wp.state.plantCol != 0) {
                    wp.state.plantCol--;
                }
            }
            if(code == KeyEvent.VK_S) {
                if(wp.state.plantRow != 5) {
                    wp.state.plantRow++;
                }
            }
            if(code == KeyEvent.VK_D) {
                if(wp.state.plantCol != 8) {
                    wp.state.plantCol++;
                }
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