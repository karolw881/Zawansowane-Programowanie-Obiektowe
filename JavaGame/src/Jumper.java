import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;


public class Jumper implements ActionListener, KeyListener {
    private final int WIDTH = 1200, HEIGHT = 600;
    private final int ENEMY_SIZE = 50 , ENEMY2_SIZE = 70 , POINT_SIZE = 30 ;
    private Renderer renderer;
    private ArrayList<Rectangle> columns;
    private ArrayList<Bullet> bullets;
    private int ticks, yMotion, score;
    private boolean gameOver, started;
    private Random rand;
    private Image groundImage, playerImage , evilImage , devilImage , collectibleImage;
    private Enemy enemy;
    private Enemy2 enemy2;
    private Player player;
    private Collectible collectible;
    private ArrayList<Image> backgrounds;
    private ArrayList<Integer> backgroundXCoordinates;
    private long lastShotTime;
    private ArrayList<EnemyBullet> enemyBullets;
    private ArrayList<Collectible> collecter;
    private int enemyBulletSpeed = 8;
    private long startTime;
    private long gameTimeInSeconds;


    Jumper() {
        JFrame jframe = new JFrame();
        Timer timer = new Timer(40, this);
        lastShotTime = System.currentTimeMillis();
        bullets = new ArrayList<>();
        renderer = new Renderer(this);
        rand = new Random();
        try {
            groundImage = ImageIO.read(new File("ziemia.jpg"));
            playerImage = ImageIO.read(new File("playerx.jpg"));
            evilImage = ImageIO.read(new File("evil.jpg"));
            devilImage = ImageIO.read(new File("devil.jpg"));
            collectibleImage = ImageIO.read(new File("dragon.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        jframe.add(renderer);
        jframe.setTitle("Jumper");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(WIDTH, HEIGHT);
        jframe.setResizable(false);
        jframe.setVisible(true);
        jframe.addKeyListener(this);
        player = new Player(10, HEIGHT , 60, 60);
        enemy = new Enemy(WIDTH, 300, ENEMY_SIZE, ENEMY_SIZE);
        enemy2 = new Enemy2(WIDTH, 120, ENEMY2_SIZE, ENEMY2_SIZE);
        collectible = new Collectible(WIDTH - 40 , 80, POINT_SIZE , POINT_SIZE );
        columns = new ArrayList<Rectangle>();
        enemyBullets = new ArrayList<>();
        collecter  = new ArrayList<>();
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        startTime = System.currentTimeMillis();
        initializeBackgrounds();
        timer.start();

    }

    public void repaint(Graphics g) {
        g.drawImage(groundImage, 0, 2 * HEIGHT / 3, WIDTH, HEIGHT, null);
        for (int i = 0; i < backgrounds.size(); i++) {
            g.drawImage(backgrounds.get(i), backgroundXCoordinates.get(i), 0, WIDTH, 2 * HEIGHT / 3, null);
        }


        g.drawImage(playerImage, player.x, player.y  , player.width, player.height, null);
        g.drawImage(evilImage, enemy.x, enemy.y, enemy.width, enemy.height, null);
        g.drawImage(devilImage, enemy2.x, enemy2.y, enemy2.width, enemy2.height, null);
        g.setColor(Color.white);
        g.drawString("Time: " + gameTimeInSeconds + "s", 10, 20);
        g.setColor(Color.white);
        g.drawString("Score: " + score, 10, 40);
        System.out.println(gameTimeInSeconds);

        for (Bullet bullet : bullets) {
            g.setColor(Color.red);
            g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
        }


        g.drawImage(collectibleImage,collectible.x, collectible.y, collectible.width, collectible.height, null);

        for (EnemyBullet enemyBullet : enemyBullets) {
            g.setColor(Color.blue);
            g.fillRect(enemyBullet.x, enemyBullet.y, enemyBullet.width, enemyBullet.height);
        }

        for (Rectangle column : columns)
        {
            paintColumn(g, column);
        }
        if (gameOver)
        {

        }
    }

    public static void main(String[] args) {new LaunchPage();}

    public void paintColumn(Graphics g, Rectangle column)
    {

        g.fillRect(column.x, column.y , column.width, column.height);
        g.drawImage(groundImage, column.x, column.y , column.width, column.height , null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        ticks++;
        started = true;
        gameTimeInSeconds = (System.currentTimeMillis() - startTime) / 1000;

        if (gameOver) {
            // Wyświetlenie komunikatu o końcu gry
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "Game Over!\nScore: " + score + "\nGame Time: " + gameTimeInSeconds + " seconds\nDo you want to play again?",
                    "Game Over",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                // Resetowanie gry
                startTime = System.currentTimeMillis();
                score = 0;
                resetGame();
            } else {
                // Zakończenie programu po naciśnięciu "No"
                System.exit(0);
            }
        } else {
            int speed = 10;

            if (started && !gameOver) {
                yMotion = 10;
                player.y += yMotion;
                if (player.y + player.height > HEIGHT) {
                    player.y = HEIGHT - player.height - 100;
                    yMotion = 0;
                }

                if (player.y < -100) gameOver = true;





                // Przesuń resztę elementów gry w lewo, gdy postać zbliży się do prawej krawędzi
                if (player.x + player.width > WIDTH / 2) {
                    player.x = WIDTH / 2 - player.width;
                    for (Rectangle column : columns) {
                        column.x -= speed;
                    }
                    enemy.x -= speed;
                }

                if (player.intersects(collectible)) {
                   score+=10;
                   collectible.respawn();
                }


                for (int i = 0; i < columns.size(); i++) {
                    Rectangle column = columns.get(i);

                    if (player.intersects(column)) {
                        player.y = column.y - player.height;
                        yMotion = 0; // przestan opadac
                    }

                    column.x -= speed;
                }
            }


            enemy.move();
            enemy2.move();
            collectible.move();


            if (player.intersects(enemy)) {
                System.out.println("Lose");
                resetGame();
                gameOver = true;
            }
            if (player.intersects(enemy2)) {
                System.out.println("Lose");
                resetGame();
                gameOver = true;
            }

            // odzycie enemy
            if (enemy.getX() + enemy.getWidth() < 0) {
                int randHeight = rand.nextInt(0,250); // Adjust the range based on your preferences
                enemy.setLocation(WIDTH, randHeight);
            }
            // dzycie enemy2
            if (enemy2.getX() + enemy2.getWidth() < 0) {
                int randHeight2 = rand.nextInt(0,250); // Adjust the range based on your preferences
                enemy2.setLocation(WIDTH, randHeight2);
            }


            // Update pozycja kuli
            Iterator<Bullet> iterator = bullets.iterator();
            while (iterator.hasNext()) {
                Bullet bullet = iterator.next();
                bullet.move();


                if (bullet.x > WIDTH) {
                    iterator.remove();
                }

                // sprawdzenie kolizji  kuli  z wrogiem
                if (bullet.intersects(enemy)) {
                    iterator.remove();
                   
                    System.out.println("Hit!");
                    enemy.setLocation(WIDTH, rand.nextInt(HEIGHT - 100));

                    score += 10; // Adjust points as needed
                    System.out.println("Hit! Score: " + score);
                }


                if (bullet.intersects(enemy2)) {
                    iterator.remove();
                    System.out.println("Hit!");
                    enemy2.setLocation(WIDTH, rand.nextInt(HEIGHT - 100));
                    score += 10; // Adjust points as needed
                    System.out.println("Hit! Score: " + score);
                }
            }

            // Przesuń obrazy tła w lewo
            for (int i = 0; i < backgroundXCoordinates.size(); i++) {
                backgroundXCoordinates.set(i, backgroundXCoordinates.get(i) - 4);
            }


        // Sprawdź, czy przedostatni obraz tła jest całkowicie poza ekranem
            int secondToLastBackgroundIndex = backgroundXCoordinates.size() - 2;
            if (backgroundXCoordinates.get(secondToLastBackgroundIndex) + WIDTH <= 0) {
                // Ponownie załaduj listę z pierwotnymi obrazami
                initializeBackgrounds();
            }


            // Sprawdź czy wrogowie powinni strzelać
            if (ticks % 80 == 0) {
                enemyShoot(enemy);


            }
            // Update wrogich strzałów
            Iterator<EnemyBullet> enemyBulletIterator = enemyBullets.iterator();
            while (enemyBulletIterator.hasNext()) {
                EnemyBullet enemyBullet = enemyBulletIterator.next();
                enemyBullet.move();

                // Sprawdź kolizję między strzałem wroga a graczem
                if (enemyBullet.intersects(player)) {
                    gameOver = true;
                    System.out.println("You got shot!");
                }

                // Usuń strzały wrogów, które opuściły ekran
                if (enemyBullet.x < 0) {
                    enemyBulletIterator.remove();
                }
            }

            renderer.repaint();
        }
    }


    public void jump()
    {
        player.y -=100;

    }


    public void addColumn(boolean start) {
        int maxWidth = 150; // Maksymalna szerokość kolumny
        int randDistance = rand.nextInt(400 , 2000); // Losowa odległość między kolumnami

        if (start) {
            columns.add(new Rectangle(WIDTH + columns.size() * (maxWidth + randDistance), HEIGHT - 200 - rand.nextInt(150, 400), 200, 30));
        }
    }

    public void shoot() {
        long currentTime = System.currentTimeMillis();


        if (currentTime - lastShotTime >= 1000) {

            Bullet bullet = new Bullet(player.x + player.width, player.y + player.height / 2, 10, 5);
            bullets.add(bullet);


            lastShotTime = currentTime;
        }
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


    private void resetGame() {
        player = new Player(10, HEIGHT - 60, 60, 60); // Używamy teraz klasy Player
        enemy.setLocation(WIDTH, 300);
        columns.clear();
        bullets.clear();
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        addColumn(true);
        gameOver = false;
        started = true;

        try {

            String data = "Score: " + score  + " Time: " + gameTimeInSeconds + "s" + System.lineSeparator();
            Files.write(Paths.get("highscores.txt"), data.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }



        enemy.respawn();
        enemy2.respawn();
        collectible.respawn();
    }



    private void initializeBackgrounds() {
        backgrounds = new ArrayList<>();
        backgroundXCoordinates = new ArrayList<>();

        try {
            backgrounds.add(ImageIO.read(new File("niebo.jpg")));
            backgrounds.add(ImageIO.read(new File("background3.png")));
            backgrounds.add(ImageIO.read(new File("background4.jpg")));
            backgrounds.add(ImageIO.read(new File("background5.jpg")));
            backgrounds.add(ImageIO.read(new File("background6.jpg")));
            backgrounds.add(ImageIO.read(new File("background10.jpg")));

            for (int i = 0; i < backgrounds.size(); i++) {
                backgroundXCoordinates.add(i * WIDTH);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enemyShoot(Enemy enemy) {
        int bulletX = enemy.x;
        int bulletY = enemy.y + enemy.height / 2 - 2; // Umieść strzał na środku wroga
        int bulletWidth = 10;
        int bulletHeight = 5;
        EnemyBullet enemyBullet = new EnemyBullet(bulletX, bulletY, bulletWidth, bulletHeight, enemyBulletSpeed);
        enemyBullets.add(enemyBullet);
    }


}


