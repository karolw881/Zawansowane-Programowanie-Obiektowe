import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

public class LaunchPage implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton startButton = new JButton("Start Game");
    private JButton optionsButton = new JButton("High Score");
    private JButton exitButton = new JButton("Exit");
    private JPanel backgroundPanel;
    private int animationCounter = 0;

    LaunchPage() {
        startButton.setFocusable(false);
        startButton.addActionListener(this);
        optionsButton.setFocusable(false);
        optionsButton.addActionListener(this);
        exitButton.setFocusable(false);
        exitButton.addActionListener(this);
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Custom background animation (adjust as needed)
                g.setColor(new Color(0, 0, 0, animationCounter));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(new GridLayout(3, 1, 0, 20));
        backgroundPanel.setBackground(Color.BLACK);


        customizeButton(startButton, "Start Game");
        customizeButton(optionsButton, "High Scores");
        customizeButton(exitButton, "Exit");


        backgroundPanel.add(startButton);
        backgroundPanel.add(optionsButton);
        backgroundPanel.add(exitButton);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);


        Timer timer = new Timer(30, this);
        timer.start();
    }

    private void customizeButton(JButton button, String labelText) {
        button.setLayout(new BorderLayout());

        JLabel label = new JLabel(labelText, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.WHITE);

        button.add(label, BorderLayout.CENTER);

        button.setPreferredSize(new Dimension(200, 40));
        button.setBackground(new Color(50, 50, 50));
        button.setBorder(BorderFactory.createLineBorder(Color.WHITE));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            frame.dispose();
            Jumper j = new Jumper();
        } else if (e.getSource() == optionsButton) {


            try {
                // Odczyt pliku
                BufferedReader reader = new BufferedReader(new FileReader("highscores.txt"));
                ArrayList<Result> results = new ArrayList<>();

                String line;
                while ((line = reader.readLine()) != null) {
                    // Parsowanie linii i dodanie wyniku do listy
                    String[] tokens = line.split("\\s+");
                    int score = Integer.parseInt(tokens[1]);


                    int time = Integer.parseInt(tokens[3].replaceAll("[^\\d]", ""));

                    results.add(new Result(score, time));
                }

                // Sortowanie wyników
                Collections.sort(results);

                // Zapis do nowego pliku
                BufferedWriter writer = new BufferedWriter(new FileWriter("nazwa_pliku_wyjsciowego.txt"));
                for (Result result : results) {
                    writer.write("Score: " + result.score + " Time: " + result.time + "s\n");
                }

                // Zamknięcie strumieni
                reader.close();
                writer.close();

                System.out.println("Plik został posortowany i zapisany.");
                try {
                    String content = new String(Files.readAllBytes(Paths.get("nazwa_pliku_wyjsciowego.txt")), StandardCharsets.UTF_8);


                    JOptionPane.showMessageDialog(frame, "Highscores:\n" + content, "Highscores", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(frame, "Error reading highscores.txt", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else if (e.getSource() == exitButton) {

            System.exit(0);
        } else if (e.getSource() instanceof Timer) {
            if (animationCounter < 150) {
                animationCounter += 5;
                backgroundPanel.repaint();
            }
        }
    }


}
