import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Jumper implements ActionListener, KeyListener {

    public static Jumper jumper;

    public final int WIDTH = 1200, HEIGHT = 600;

    public final int ENEMY_SIZE = 50;
    public Renderer renderer;

    public ArrayList<Rectangle> columns;
    public ArrayList<Bullet> bullets;
    public Rectangle player;

    // public ArrayList<Rectangle> columns;

    public int ticks, yMotion, score;

    public boolean gameOver, started;

    public Random rand;

    public Image groundImage, skyImage, playerImage;

    public Enemy enemy;

    Jumper() {
        JFrame jframe = new JFrame();
        Timer timer = new Timer(40, this);

        bullets = new ArrayList<>();
        renderer = new Renderer(this);
        rand = new Random();
        try {
            groundImage = ImageIO.read(new File("ziemia.jpg")); // Replace with the actual file path
            skyImage = ImageIO.read(new File("niebo.jpg")); // Replace with the actual file path
            playerImage = ImageIO.read(new File("Magik.png")); // Replace with the actual file path
        } catch (IOException e) {
            e.printStackTrace();
        }
        jframe.add(renderer);
        jframe.setTitle("Jumper");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
      //  jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.addKeyListener(this);
        player = new Rectangle(10, HEIGHT, 100, 100);
        enemy = new Enemy(WIDTH, 300, ENEMY_SIZE, ENEMY_SIZE);
        columns = new ArrayList<Rectangle>();
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        timer.start();
    }

    public void repaint(Graphics g) {
        // Draw the sky image
        g.drawImage(skyImage, 0, 0, WIDTH, 2 * HEIGHT / 3, null);

        // Draw the ground image
        g.drawImage(groundImage, 0, 2 * HEIGHT / 3, WIDTH, HEIGHT, null);

        // Draw the player using the loaded image
        g.drawImage(playerImage, player.x, player.y , player.width, player.height, null);

        // Draw the enemy
        g.setColor(Color.blue);
        g.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);


        // Draw bullets
        for (Bullet bullet : bullets) {
            g.setColor(Color.red);
            g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
        }



        for (Rectangle column : columns)
        {
            paintColumn(g, column);
        }
        if (gameOver)
        {
            g.drawString("Game Over!", 100, HEIGHT / 2 - 50);
        }
    }

    public static void main(String[] args) {

        LaunchPage page = new LaunchPage();


       // jumper = new Jumper();
    }


    public void paintColumn(Graphics g, Rectangle column)
    {
        g.setColor(Color.green.darker());
        g.fillRect(column.x, column.y , column.width, column.height);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ticks++;
        started = true;
        gameOver = false;
        int speed = 10;

        if (started && !gameOver) {
            // Apply gravity to yMotion
            yMotion += 1;

            // Update player position
            player.y += yMotion;

            // Check if the player hits the ground
            if (player.y + player.height > HEIGHT) {
                player.y = HEIGHT - player.height;
                yMotion = 0; // Stop falling
            }

            // Check if the player reaches the initial position after jumping
            if (player.y >= HEIGHT / 2 - 10) {
                player.y = HEIGHT / 2 - 10; // Set it to the initial position
                yMotion = 0; // Stop falling
            }

            // Check for collision with columns
            for (int i = 0; i < columns.size(); i++) {
                Rectangle column = columns.get(i);

                if (player.intersects(column)) {
                    // Player intersects with a column, set player's y position on the column
                    player.y = column.y - player.height;
                    yMotion = 0; // Stop falling
                }

                column.x -= speed;
            }
        }

        // Update enemy position
        enemy.move();

        // Check for collision between player and enemy
        if (player.intersects(enemy)) {
            gameOver = true;
            // Handle collision action (e.g., game over logic)
            System.out.println("Lose");
        }

        // Respawn enemy with random height
        if (enemy.getX() + enemy.getWidth() < 0) {
            int randHeight = rand.nextInt(HEIGHT - 100); // Adjust the range based on your preferences
            enemy.setLocation(WIDTH, randHeight);
        }

        // Update bullets position
        Iterator<Bullet> iterator = bullets.iterator();
        while (iterator.hasNext()) {
            Bullet bullet = iterator.next();
            bullet.move();

            // Remove bullets that go out of bounds
            if (bullet.x > WIDTH) {
                iterator.remove();
            }

            // Check for collision between bullet and enemy
            if (bullet.intersects(enemy)) {
                iterator.remove();
                // Handle bullet-enemy collision action (e.g., increase score)
                System.out.println("Hit!");
                enemy.setLocation(WIDTH, rand.nextInt(HEIGHT - 100)); // Respawn enemy at a random height
            }
        }

        renderer.repaint();
    }


    public void jump()
    {
        player.y -=250;

    }


    public void addColumn(boolean start) {
        int space = 300;
        int minWidth = 30;  // Minimalna szerokość kolumny
        int maxWidth = 150; // Maksymalna szerokość kolumny
        int width = rand.nextInt(maxWidth - minWidth + 1) + minWidth; // Losuj szerokość kolumny w zakresie [minWidth, maxWidth]
        int randDistance = rand.nextInt(400 , 2000); // Losowa odległość między kolumnami

        if (start) {
            columns.add(new Rectangle(WIDTH + columns.size() * (maxWidth + randDistance), HEIGHT - 200 - rand.nextInt(150, 400), 200, 30));
        }
    }

    public void shoot() {
        // Create a new bullet and add it to the bullets list
        Bullet bullet = new Bullet(player.x + player.width, player.y + player.height / 2, 10, 5);
        bullets.add(bullet);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_UP) {
            jump();
        }else if (key == KeyEvent.VK_Z) { // Press 'Z' to shoot
            shoot();
        }else  if(key == KeyEvent.VK_RIGHT){
            player.x +=10;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }
}


