import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ProdigyTask02 {

    private int number;
    private int attempts = 0;

    public ProdigyTask02() {
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(5, 1, 10, 10));

        JLabel title = new JLabel("🎯 Guess the Number (1–100)", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        frame.add(title);

        JTextField input = new JTextField();
        frame.add(input);

        JLabel result = new JLabel("Enter a number", JLabel.CENTER);
        frame.add(result);

        JLabel attemptsLabel = new JLabel("Attempts: 0", JLabel.CENTER);
        frame.add(attemptsLabel);

        JButton button = new JButton("Guess");
        frame.add(button);

        number = new Random().nextInt(100) + 1;

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(input.getText());
                    attempts++;
                    attemptsLabel.setText("Attempts: " + attempts);

                    if (guess > number)
                        result.setText("Too High!");
                    else if (guess < number)
                        result.setText("Too Low!");
                    else
                        result.setText("🎉 Correct! You won!");

                } catch (Exception ex) {
                    result.setText("Enter a valid number!");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ProdigyTask02();
    }
}
