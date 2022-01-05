package view.Tiles;
import model.Game;
import view.Tiles.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {
    public Game game;

    public Tile[]Tiles;

    public int mapTile[][];

    public TileManager(Game game) {
        this.game = game;
        Tiles = new Tile[20];
        mapTile = new int[game.maxDungeonCol][game.maxDungeonRow];//store
        getTileImage();
        loadmap();
    }
    public void getTileImage(){
        try{
            Tiles[0]= new Tile();
            Tiles[0].image= ImageIO.read(new FileInputStream("src/main/resources/Images/Tile.png"));
            Tiles[1]= new Tile();
            Tiles[1].image= ImageIO.read(new FileInputStream("src/main/resources/Images/Corner1.png"));
            Tiles[1].collision = true ;
            Tiles[2]= new Tile();
            Tiles[2].image= ImageIO.read(new FileInputStream("src/main/resources/Images/Corner2.png"));
            Tiles[2].collision = true ;
            Tiles[3]= new Tile();
            Tiles[3].image= ImageIO.read(new FileInputStream("src/main/resources/Images/Corner3.png"));
            Tiles[3].collision = true ;
            Tiles[4]= new Tile();
            Tiles[4].image= ImageIO.read(new FileInputStream("src/main/resources/Images/Corner4.png"));
            Tiles[4].collision = true ;
            Tiles[5]= new Tile();
            Tiles[5].image= ImageIO.read(new FileInputStream("src/main/resources/Images/Wall.png"));
            Tiles[5].collision = true ;
            Tiles[6]= new Tile();
            Tiles[6].image= ImageIO.read(new FileInputStream("src/main/resources/Images/WallUp.png"));
            Tiles[6].collision = true ;
            Tiles[7]= new Tile();
            Tiles[7].image= ImageIO.read(new FileInputStream("src/main/resources/Images/WallDown.png"));
            Tiles[7].collision = true ;
            Tiles[8]= new Tile();
            Tiles[8].image= ImageIO.read(new FileInputStream("src/main/resources/Images/WallLeft.png"));
            Tiles[8].collision = true ;
            Tiles[9]= new Tile();
            Tiles[9].image= ImageIO.read(new FileInputStream("src/main/resources/Images/WallRight.png"));
            Tiles[10]= new Tile();
            Tiles[10].image= ImageIO.read(new FileInputStream("src/main/resources/Images/WallLeftEnd.png"));
            Tiles[10].collision = true ;
            Tiles[11]= new Tile();
            Tiles[11].image= ImageIO.read(new FileInputStream("src/main/resources/Images/WallRightEnd.png"));
            Tiles[12]= new Tile();
            Tiles[12].image= ImageIO.read(new FileInputStream("src/main/resources/Images/TwoSideCorner.png"));
            Tiles[12].collision = true ;
            Tiles[13]= new Tile();
            Tiles[13].image= ImageIO.read(new FileInputStream("src/main/resources/Images/TwoSideCorner1.png"));
            Tiles[13].collision = true ;
            Tiles[14]= new Tile();
            Tiles[14].image= ImageIO.read(new FileInputStream("src/main/resources/Images/TwoSideCorner2.png"));
            Tiles[14].collision = true ;
            Tiles[15]= new Tile();
            Tiles[15].image= ImageIO.read(new FileInputStream("src/main/resources/Images/Vide.jpg"));
            Tiles[16]= new Tile();
            Tiles[16].image= ImageIO.read(new FileInputStream("src/main/resources/Images/TwoSideCorner - Copie.png"));
            Tiles[16].collision = true ;
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadmap(){
        try{
            InputStream inputStream = new FileInputStream("src/main/resources/map/DungeonMap.txt");
            BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
            int column=0;
            int row=0;
            while(column < game.maxDungeonCol && row< game.maxDungeonCol){
                String line = bufferedReader.readLine(); //read line by line
                while (column< game.maxDungeonCol){//get number from file
                    //get number by number
                    String  number[] = line.split(" ");
                    int num = Integer.parseInt(number[column]);
                    mapTile[column][row]= num;
                    column++;
                }
                if(column==game.maxDungeonCol){
                    column=0;
                    row++;
                }
            }
            bufferedReader.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D graphics2D){
        int dungeonCol=0;
        int dungeonRow =0;
         while (dungeonCol < game.maxDungeonCol && dungeonRow < game.maxDungeonRow){
            int tilenum = mapTile[dungeonCol][dungeonRow];
            int worldX = dungeonCol * game.tileSize;
            int worldY = dungeonRow * game.tileSize;
            int screenX = worldX - game.player.mapX +game.player.screenX;
            int screenY = worldY - game.player.mapY +game.player.screenY;
            if(worldX + game.tileSize > game.player.mapX - game.player.screenX && worldX - game.tileSize < game.player.mapX + game.player.screenX && worldY + game.tileSize > game.player.mapY - game.player.screenY && worldY - game.tileSize < game.player.mapY + game.player.screenY){
            graphics2D.drawImage(Tiles[tilenum].image, screenX,screenY,game.tileSize, game.tileSize, null);}
            dungeonCol++;

            if(dungeonCol == game.maxDungeonCol){
                dungeonCol=0;
                dungeonRow++;
            }
        }
    }
}
