import java.awt.*;

class Enemy extends Rectangle {
    private int speed;

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
        speed = 10; // Adjust the speed as needed
    }

    public void move() {
        x -= speed;
        if (x + width < 0) {
            respawn(); // Reset the enemy to the right side when it goes off the screen
        }
    }

    public void respawn() {
        x = 1200; // Set initial X position for respawn
        y = 300; // Set Y position randomly
    }
}
