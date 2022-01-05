package model;

import controller.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Monster  {
    private int vitality;
    private int power;
    int mapX, mapY;
    public final int screenX;
    public final int screenY;
    public int speed;
    public Rectangle rectangle;
    public boolean collision = false;
    TypeOfMonsters monster;
    Character character;
    Game game;


    public Monster(int vitality, int power, TypeOfMonsters monster, Game game, KeyHandler key) {
        character = new Character(vitality,power);
        this.vitality = vitality;
        this.power = power;
        screenX = game.screenWidth/2 - (game.tileSize/2);
        screenY = game.screenHeight/2 - (game.tileSize/2);
        //collision
        rectangle = new Rectangle();
        this.monster = monster;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues(){
        mapX = game.tileSize * 8;
        mapY = game.tileSize * 6;
        speed = 4;
        character.direction="down";
    }

    public void getPlayerImage(){
        try {
            character.up1 = ImageIO.read(new FileInputStream("src/main/resources/Images/ifrit1.png"));
            character.up2 = ImageIO.read(new FileInputStream("src/main/resources/Images/ifrit2.png"));
            character.down1 = ImageIO.read(new FileInputStream("src/main/resources/Images/ifrit3.png"));
            character.down2 = ImageIO.read(new FileInputStream("src/main/resources/Images/ifrit4.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }




}
