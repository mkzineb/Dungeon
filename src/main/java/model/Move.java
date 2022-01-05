package model;

import controller.KeyHandler;

import java.awt.event.KeyEvent;

public class Move implements PlayerState {
    KeyHandler keyHandler = new KeyHandler();
    Player player;

    @Override
    public void handle() {
        if(keyHandler.down && keyHandler.left && keyHandler.up && keyHandler.right){
            player.update();
        }
    }
}
