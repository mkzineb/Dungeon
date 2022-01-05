package view.Objects;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Potion extends Treasure {

    public Potion() {
        try {
            image = ImageIO.read(new FileInputStream("src/main/resources/Images/treasure2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        name = "potion";
    }

}