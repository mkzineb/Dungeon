package model;
import controller.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends PlayerCurrentState {

    public int mapX, mapY;
    public final int screenX;//where we drax the player on the screen
    public final int screenY;
    public int speed;
    Game game;
    KeyHandler keyHandler;
    public Character character;
    private PlayerCurrentState playerState ;
    //collision
    public Rectangle rectangle = new Rectangle();
    public boolean collision = false;
    //object collision
    public int areaX;
    public int areaY;
    public Fight fight;

    public Player(int vitality, int power, PlayerCurrentState state, Game game, KeyHandler key) {
        character = new Character( vitality,  power);
        this.playerState=state;
        this.game = game;
        this.keyHandler=key;
        //afficher player au milieu
        screenX = game.screenWidth/2 - (game.tileSize/2) ;
        screenY = game.screenHeight/2 - (game.tileSize/2);
        //COLISION
        rectangle = new Rectangle(8,16,32,32);
        areaX = rectangle.x;
        areaY = rectangle.y;

        setDefaultValues();
        getPlayerImage();
    }

    public PlayerCurrentState getPlayerState() {
        return this.playerState;
    }

    public void update(){
            //first we only chack the direction if there's no collision then the player move
            if (keyHandler.up || keyHandler.down || keyHandler.right || keyHandler.left) {
                //playerState.changeState();
                if (keyHandler.up) {
                    character.direction = "up";
                } else if (keyHandler.down) {
                    character.direction = "down";
                } else if (keyHandler.left) {
                    character.direction = "left";
                } else if (keyHandler.right) {
                    character.direction = "right";
                } else if (keyHandler.space) {
                    character.direction = "space";
                }
                //map collision
                collision = false;
                game.collision.characterCollision(this);
                //object collision
                int index = game.collision.checkObject(this, true);
                pickTreasure(index);
                //if there is no collision, player moves
                if (collision == false) {
                    switch (character.direction) {
                        case "up":
                            mapY -= speed;
                            break;
                        case "down":
                            mapY += speed;
                            break;
                        case "left":
                            mapX -= speed;
                            break;
                        case "right":
                            mapX += speed;
                            break;
                        case "space":
                            fight.damage();
                            break;
                    }
                }
                character.tCount++;
                if (character.tCount > 10) {
                    if (character.Num == 1) {
                        character.Num = 2;
                    } else if (character.Num == 2) {
                        character.Num = 1;
                    }
                    character.tCount = 0;
                }
            }
    }

    public void draw(Graphics2D graphic){
         BufferedImage image = null;
         switch(character.direction){
             case "up" :
                 if(character.Num == 1){
                    image = character.up1;}
                 if(character.Num == 2){
                     image = character.up2;}
                 break;
             case "down" :
                 if(character.Num == 1){
                     image = character.down1;}
                 if(character.Num == 2){
                     image = character.down2;}
                 break;
             case "left" :
                 if(character.Num == 1){
                     image = character.left1;}
                 if(character.Num == 2){
                     image = character.left2;}
                 break;
             case "right" :
                 if(character.Num == 1){
                     image = character.right1;}
                 if(character.Num == 2){
                     image = character.right2;}
                 break;
             default:
                 break;
         }
         //different x y
         graphic.drawImage(image, screenX, screenY,game.tileSize, game.tileSize, null);

    }

     public void setDefaultValues(){
        mapX = game.tileSize * 8;
        mapY = game.tileSize * 6;
        speed = 4;
        character.direction="down";
     }

     public void getPlayerImage(){
        try {
            character.up1 = ImageIO.read(new FileInputStream("src/main/resources/Images/belf6.png"));
            character.up2 = ImageIO.read(new FileInputStream("src/main/resources/Images/belf5.png"));
            character.down1 = ImageIO.read(new FileInputStream("src/main/resources/Images/belf2.png"));
            character.down2 = ImageIO.read(new FileInputStream("src/main/resources/Images/belf1.png"));
            character.left1 = ImageIO.read(new FileInputStream("src/main/resources/Images/belf3.png"));
            character.left2 = ImageIO.read(new FileInputStream("src/main/resources/Images/belf8.png"));
            character.right1 = ImageIO.read(new FileInputStream("src/main/resources/Images/belf4.png"));
            character.right2 = ImageIO.read(new FileInputStream("src/main/resources/Images/belf7.png"));
        }
        catch(IOException e){
             e.printStackTrace();
        }
     }

     public void pickTreasure(int index){
        if(index!=232){
            String name = game.treasures[index].name;
            switch (name){
                case "potion":
                    character.potion++;
                    game.treasures[index]=null;
                    System.out.println("you picked a potion");
                    break;
                case "weapon":
                    character.weapon++;
                    game.treasures[index]=null;
                    System.out.println("you picked a weapon");
                    break;
            }
        }
     }

}
