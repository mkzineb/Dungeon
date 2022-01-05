package view.Objects;

import model.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Treasure {
    private int damage = 1;
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int mapX, mapY;
    //solid area
    public  Rectangle rectangle = new Rectangle(0,0,48,48);
    //solid default area
    public int areaX =0;
    public int areaY =0;

    public Treasure() {
    }

    public void draw(Graphics2D graphics2D, Game game){
        int screenX = mapX - game.player.mapX +game.player.screenX;
        int screenY = mapY - game.player.mapY +game.player.screenY;
        if        (mapX + game.tileSize > game.player.mapX - game.player.screenX
                && mapX - game.tileSize < game.player.mapX + game.player.screenX
                && mapY + game.tileSize > game.player.mapY - game.player.screenY
                && mapY - game.tileSize < game.player.mapY + game.player.screenY){
            graphics2D.drawImage(image, screenX,screenY,game.tileSize, game.tileSize, null);}
    }
}
