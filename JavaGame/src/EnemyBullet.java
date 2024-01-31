import java.awt.*;

public class EnemyBullet extends Rectangle {

    private final int speed;

    public EnemyBullet(int x, int y, int width, int height, int speed) {
        super(x, y, width, height);
        this.speed = speed;
    }

    public void move() {
        x -= speed + 20;
    }
}
