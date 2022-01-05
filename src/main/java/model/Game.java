package model;
import view.Objects.ObjectPlacement;
import view.Objects.Potion;
import view.Objects.Treasure;
import view.Tiles.Collision;
import view.Tiles.TileManager;
import controller.KeyHandler;
import view.UI;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class Game extends JPanel implements Runnable {
    public final int OriginalTileSize= 16;
    public final int scale = 3;
    public final int tileSize = OriginalTileSize*scale; //48 x 48
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize*maxScreenCol;
    public final int screenHeight = tileSize*maxScreenRow;

    public TileManager tileManager = new TileManager(this);
    int FPS = 60;
    KeyHandler keyHandler = new KeyHandler();
    public Collision collision = new Collision(this);
    private PlayerCurrentState state;
    public Player player = new Player(10,100,state,this,keyHandler);
    public ObjectPlacement objectPlacement = new ObjectPlacement(this);
    //Dungeon settings
    public final int maxDungeonCol = 20;
    public final int maxDungeonRow = 20;
    //public final int dungeonWidth = tileSize*maxDungeonCol;
    //public final int dungeonHeight = tileSize*maxDungeonRow;
    //display 10
    public Treasure treasures[] = new Treasure[10];

    public UI ui = new UI(this);

    public  Game() throws IOException {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    Thread gameThread;

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void set(){
        objectPlacement.placeObject();
    }
    @Override
    /*public void run() {
        double drawInt = 1000000000/FPS; //0,01666 seconds
        double nextDraw = System.nanoTime() +drawInt;

       while(gameThread != null){
            update();
            repaint();
            double remainingTime = nextDraw - System.nanoTime();
            remainingTime = remainingTime / 1000000;
           try {
               if(remainingTime <0 ){
                    remainingTime=0;
               }
               Thread.sleep((long)remainingTime);
               nextDraw+=drawInt;
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }*/
    public void run() {
        double drawInt = 1000000000/FPS; //0,01666 seconds
        double delta = 0;
        double lastTime = System.nanoTime();
        double currentTime;

        while(gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInt;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }
    public void update(){
        player.update();
    }

    public void paintComponent(Graphics graphic){
        super.paintComponent(graphic);

        tileManager.draw((Graphics2D) graphic);
        for(int i = 0; i < treasures.length;i++){
            if(treasures[i] != null){
                treasures[i].draw((Graphics2D) graphic,this);
            }
        }
        player.draw((Graphics2D) graphic);
        try {
            ui.draw((Graphics2D)graphic);
        } catch (IOException e) {
            e.printStackTrace();
        }
        graphic.dispose();
    }
}
