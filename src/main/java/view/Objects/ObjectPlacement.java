package view.Objects;

import model.Game;

public class ObjectPlacement {
    Game game;

    public ObjectPlacement(Game game) {
        this.game = game;
    }

    public void placeObject(){
        game.treasures[0] = new Potion();
        game.treasures[0].mapX = 4 * game.tileSize;
        game.treasures[0].mapY = 6 * game.tileSize;


        game.treasures[1] = new Potion();
        game.treasures[1].mapX = 10 * game.tileSize;
        game.treasures[1].mapY = 31
                * game.tileSize;

        game.treasures[2] = new Potion();
        game.treasures[2].mapX = 9 * game.tileSize;
        game.treasures[2].mapY = 34 * game.tileSize;

        game.treasures[3] = new Weapon();
        game.treasures[3].mapX = 3 * game.tileSize;
        game.treasures[3].mapY = 6 * game.tileSize;

        game.treasures[4] = new Potion();
        game.treasures[4].mapX = 15 * game.tileSize;
        game.treasures[4].mapY = 9 * game.tileSize;

        game.treasures[5] = new Weapon();
        game.treasures[5].mapX = 19 * game.tileSize;
        game.treasures[5].mapY = 39 * game.tileSize;

    }





}
