package view;

import model.Game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class UI {
    //display text messages
    BufferedImage image;
    Game game;
    Font arial;

    public UI(Game game) throws IOException {
        this.game = game;
        arial = new Font("Arial", Font.PLAIN,40);
        image = ImageIO.read(new FileInputStream("src/main/resources/Images/treasure5G.png"));
    }

    public void draw(Graphics2D graphics2D) throws IOException {
        graphics2D.setFont(arial);
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawImage(image,game.tileSize+5, game.tileSize/2, game.tileSize, game.tileSize, null);
        graphics2D.drawString(" x "+ game.player.character.potion,90,70);
        graphics2D.drawImage(ImageIO.read(new FileInputStream("src/main/resources/Images/Weapon.png")),game.tileSize+5, game.tileSize+30 , game.tileSize, game.tileSize, null);
        graphics2D.drawString(" x "+ game.player.character.weapon,90,120);
        graphics2D.drawImage(ImageIO.read(new FileInputStream("src/main/resources/Images/R.png")),game.tileSize+5, game.tileSize+90 , game.tileSize, game.tileSize, null);
        graphics2D.drawString(" x "+ game.player.character.vitality,90,170);

    }
}
