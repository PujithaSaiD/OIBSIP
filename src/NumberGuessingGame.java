import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGuessingGame {
    public static void main(String[] args) {
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int score = 0;
        JOptionPane.showMessageDialog(null, "Welcome to the Number Guessing Game!");
        while (true) {
            int targetNumber = generateRandomNumber(lowerBound, upperBound);
            int attempts = 0;
            while (attempts < maxAttempts) {
                String guessStr = JOptionPane.showInputDialog("Enter your guess between " + lowerBound + " and " + upperBound + ":");
            
                if (guessStr == null) {
                    JOptionPane.showMessageDialog(null, "Thanks for playing! Your score: " + score);
                    System.exit(0);
                }
                int userGuess = Integer.parseInt(guessStr);
                attempts++;
                if (userGuess == targetNumber) {
                    JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number in " + attempts + " attempts.");
                    score += calculateScore(attempts);
                    break;
                } else if (userGuess < targetNumber) {
                    JOptionPane.showMessageDialog(null, "Try again! The number is higher.");
                } else {
                    JOptionPane.showMessageDialog(null, "Try again! The number is lower.");
                }
            }
            int playAgain = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
            if (playAgain != JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Thanks for playing! Your final score: " + score);
                System.exit(0);
            }
        }
    }
    private static int generateRandomNumber(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }
    private static int calculateScore(int attempts) {
        return 100 - (attempts - 1) * 10;
    }
}
