package view.Objects;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Weapon extends Treasure {

    public Weapon(){   try {
        image = ImageIO.read(new FileInputStream("src/main/resources/Images/treasure1.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
        collision = true;
        name = "weapon";
    }
}
