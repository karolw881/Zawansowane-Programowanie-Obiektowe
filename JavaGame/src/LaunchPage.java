import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton startButton = new JButton("Start Game");
    private JButton optionsButton = new JButton("Options");
    private JButton exitButton = new JButton("Exit");
    private JPanel backgroundPanel;

    private int animationCounter = 0;

    LaunchPage() {
        // Setting up buttons
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        optionsButton.setFocusable(false);
        optionsButton.addActionListener(this);

        exitButton.setFocusable(false);
        exitButton.addActionListener(this);

        // Adding buttons to a panel
        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Custom background animation (adjust as needed)
                g.setColor(new Color(0, 0, 0, animationCounter));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(new GridLayout(3, 1, 0, 20)); // Grid layout for buttons with spacing
        backgroundPanel.setBackground(Color.BLACK); // Set a background color

        // Customize button appearance and labels
        customizeButton(startButton, "Start Game");
        customizeButton(optionsButton, "Options");
        customizeButton(exitButton, "Exit");

        // Adding buttons to the panel
        backgroundPanel.add(startButton);
        backgroundPanel.add(optionsButton);
        backgroundPanel.add(exitButton);

        // Setting up frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setContentPane(backgroundPanel);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);

        // Timer for background animation
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
            // Add code to handle the "Start Game" button
            // For now, just close the frame
            frame.dispose();
            Jumper j = new Jumper();
        } else if (e.getSource() == optionsButton) {
            // Add code to handle the "Options" button
            // For example, display an options dialog
            JOptionPane.showMessageDialog(frame, "Options clicked!");
        } else if (e.getSource() == exitButton) {
            // Add code to handle the "Exit" button
            System.exit(0);
        } else if (e.getSource() instanceof Timer) {
            // Update background animation (fade-in effect)
            if (animationCounter < 150) {
                animationCounter += 5;
                backgroundPanel.repaint();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LaunchPage());
    }
}
