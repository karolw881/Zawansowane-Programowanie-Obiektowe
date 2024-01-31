import java.awt.*;
import java.util.Random;

public class Collectible extends Rectangle {
    private int speed;

    public Collectible(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 4;
    }

    public void move() {
        x -= speed;
        if (x + width < 0) {
            respawn();
        }
    }

    public void respawn() {
        x = 1200;
        y = new Random().nextInt(501);
    }

}
