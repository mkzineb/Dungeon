package controller;

import model.Player;
import model.PlayerCurrentState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean up, down, left, right, space;
    @Override
    public void keyTyped(KeyEvent e) {
    }
    PlayerCurrentState playerCurrentState;

    @Override
    public void keyPressed(KeyEvent e) {
        int code= e.getKeyCode();
        if(code == KeyEvent.VK_Z) {

            up = true;
        }
        if(code == KeyEvent.VK_S) {
            down = true;
        }
        if(code == KeyEvent.VK_Q) {
            left = true;
        }
        if(code == KeyEvent.VK_D) {
            right = true;
        }
        if(code == KeyEvent.VK_SPACE){
            space = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_Z) {

            up = false;
        }
        if(code == KeyEvent.VK_S) {
            down = false;
        }
        if(code == KeyEvent.VK_Q) {
            left = false;
        }
        if(code == KeyEvent.VK_D) {
            right = false;
        }
        if(code == KeyEvent.VK_SPACE) {
            space = false;
        }
    }

    public boolean keyPressed() {
        return true;
    }
}
