package model;


import controller.KeyHandler;

public abstract class PlayerCurrentState {
    PlayerState currentState;
    Player player;
    KeyHandler keyHandler;
    public void SetState(PlayerState playerState){
        currentState = playerState;
        currentState.handle();
    }


    public void update(KeyHandler keyHandler) {
        currentState.handle();
    }


    public PlayerState changeState(){
        if(keyHandler.keyPressed()) {
            currentState = new Move();
        }
        else {
            currentState = new Fight();
        }

        return currentState;
    }
}
