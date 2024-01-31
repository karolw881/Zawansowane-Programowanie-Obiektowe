import java.awt.*;
import java.util.Random;

class Enemy2 extends Rectangle {
    private int speed;

    public Enemy2(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 30;
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
