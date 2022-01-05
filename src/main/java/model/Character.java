package model;

import java.awt.image.BufferedImage;

public class Character {
    public int vitality;
    public int power;
    public String direction;
    public int potion = 0;
    public int weapon = 0;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;

    public Character(int vitality, int power) {
        this.vitality = vitality;
        this.power = power;
    }
    public int tCount = 0;
    public int Num = 1;

    public boolean isAlive() {
        return vitality%2==1;
    }
}
