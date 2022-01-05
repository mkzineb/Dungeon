package view.Tiles;
import model.Game;
import model.Player;

import java.util.Arrays;

public class Collision {
    Game game;
    public Collision(Game game){
        this.game = game;
    }

    public void characterCollision(Player player){
        //the inside square of the player coordination (col/row)
        int characterLeftX = player.mapX + player.rectangle.x;
        int characterRightX = player.mapX + player.rectangle.x + player.rectangle.width;
        int characterUpY = player.mapY + player.rectangle.y;
        int characterDownY = player.mapY + player.rectangle.y + player.rectangle.height;

        int rightCol = characterRightX/game.tileSize;
        int downRow = characterDownY/game.tileSize;
        int leftCol = characterLeftX/game.tileSize;
        int upRow = characterUpY/game.tileSize;


        int tile1, tile2; // only checking two tiles in each direction

        switch(player.character.direction){
            case "up":
                upRow = (characterUpY - player.speed)/ game.tileSize; //to find out what view.Tiles is stepping in
                tile1 = game.tileManager.mapTile[leftCol][upRow];
                tile2 = game.tileManager.mapTile[rightCol][upRow];
                if (game.tileManager.Tiles[tile1].collision || game.tileManager.Tiles[tile2].collision) {
                    player.collision = true;
                }
                break;
            case "down":
                downRow = (characterDownY - player.speed)/ game.tileSize; //to find out what view.Tiles is stepping in
                tile1 = game.tileManager.mapTile[leftCol][downRow];
                tile2 = game.tileManager.mapTile[rightCol][downRow];
                if (game.tileManager.Tiles[tile1].collision || game.tileManager.Tiles[tile2].collision) {
                    player.collision = true;
                }
                break;
            case "left":
                leftCol = (characterLeftX - player.speed)/ game.tileSize; //to find out what view.Tiles is stepping in
                tile1 = game.tileManager.mapTile[leftCol][upRow];
                tile2 = game.tileManager.mapTile[leftCol][downRow];
                if (game.tileManager.Tiles[tile1].collision || game.tileManager.Tiles[tile2].collision ) {
                    player.collision = true;
                }
                break;
            case "right":
                rightCol = (characterRightX - player.speed)/ game.tileSize; //to find out what view.Tiles is stepping in
                tile1 = game.tileManager.mapTile[rightCol][upRow];
                tile2 = game.tileManager.mapTile[rightCol][downRow];
                if (game.tileManager.Tiles[tile1].collision  || game.tileManager.Tiles[tile2].collision ) {
                    player.collision = true;
                }
                break;
        }
    }
    public int checkObject(Player character, boolean player){
        int index = 232;
        for(int i=0; i< game.treasures.length; i++){
            if(game.treasures[i] != null){
                //get character solid area position (x,y)
                character.rectangle.x = character.mapX + character.rectangle.x;
                character.rectangle.y = character.mapY + character.rectangle.y;
                //get the onject solid area position (x,y)
                game.treasures[i].rectangle.x = game.treasures[i].mapX + game.treasures[i].rectangle.x;
                game.treasures[i].rectangle.y = game.treasures[i].mapY + game.treasures[i].rectangle.y;
                switch (character.character.direction){
                    case "up":
                        character.rectangle.y -= character.speed;
                        if(character.rectangle.intersects(game.treasures[i].rectangle)){
                            if(game.treasures[i].collision){
                                character.collision = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        character.rectangle.y += character.speed;
                        if(character.rectangle.intersects(game.treasures[i].rectangle)){
                            if(game.treasures[i].collision){
                                character.collision = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        character.rectangle.x -= character.speed;
                        if(character.rectangle.intersects(game.treasures[i].rectangle)){
                            if(game.treasures[i].collision){
                                character.collision = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        character.rectangle.x += character.speed;
                        if(character.rectangle.intersects(game.treasures[i].rectangle)){
                            if(game.treasures[i].collision){
                                character.collision = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                }
            }
            character.rectangle.x=character.areaX;
            character.rectangle.y=character.areaY;
            if(game.treasures[i] != null){
            game.treasures[i].rectangle.x = game.treasures[i].areaX;
            game.treasures[i].rectangle.y = game.treasures[i].areaY;
        }}
        return index;
    }
}
