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
        if(wp.gameState == wp.menuState) {
            if(wp.state.menuScreenState == 0) {
                if(code == KeyEvent.VK_UP) {
                    wp.state.command--;
                    if(wp.state.command < 0) {
                        wp.state.command = 4;
                    }
                }
                if(code == KeyEvent.VK_DOWN) {
                    wp.state.command++;
                    if(wp.state.command > 4) {
                        wp.state.command = 0;
                    }
                }
                if(code == KeyEvent.VK_ENTER) {
                    if(wp.state.command == 0) {
                        wp.gameState = wp.inventoryState;
                    }
                    if(wp.state.command == 1) {
                        wp.state.menuScreenState = 1;
                    }
                    if(wp.state.command == 2) {
                        wp.state.menuScreenState = 2;
                    }
                    if(wp.state.command == 3) {
                        wp.state.menuScreenState = 3;
                    }
                    if(wp.state.command == 4) {
                        System.exit(0);
                    }
                }
            } else {
                if(code == KeyEvent.VK_ESCAPE) {
                    wp.state.menuScreenState = 0;
                }
            }
        }
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
            if(code == KeyEvent.VK_SPACE) {
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
                wp.openInputDialog();
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