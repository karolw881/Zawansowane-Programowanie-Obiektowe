import java.awt.*;

class Bullet extends Rectangle {

    private static final long serialVersionUID = 1L;

    public Bullet(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public void move() {
        x += 5;
    }
}