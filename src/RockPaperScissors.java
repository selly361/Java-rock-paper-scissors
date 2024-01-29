import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int computer_score = 0;
        int user_score = 0;

        while (true) {
            System.out.println("Enter your choice (Rock, Paper, Scissors) or 'exit' to end: ");
            String userChoice = scanner.nextLine().toLowerCase();


            if (userChoice.equals("exit")) {
                System.out.println("Thanks for playing. Goodbye!");
                user_score = 0;
                computer_score = 0;
                break;
            }

            else if(!Set.of("rock", "paper", "scissors").contains(userChoice)){
                System.out.println("Invalid choice.");
                continue;
            }

            
            String[] options = {"Rock", "Paper", "Scissors"};
            Random random = new Random();
            String computerChoice = options[random.nextInt(3)];

            userChoice = userChoice.substring(0, 1).toUpperCase() + userChoice.substring(1);

            RockPaperScissorsGame game = new RockPaperScissorsGame(userChoice.toLowerCase(), computerChoice.toLowerCase());
            int[] results = game.play(user_score, computer_score);

            user_score = results[0];
            computer_score = results[1];

            System.out.println(String.format("You Picked %s (Score: %d) | Computer picked %s (Score: %d)", userChoice, user_score, computerChoice, computer_score));
        }

        scanner.close();
    }
}

class RockPaperScissorsGame {
    private String userChoice;
    private String computerChoice;

    public RockPaperScissorsGame(String userChoice, String computerChoice) {
        this.userChoice = userChoice;
        this.computerChoice = computerChoice;
    }

    public int[] play(int user_score, int computer_score) {
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (isUserWinning()) {
            user_score+=1;
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("Computer wins. Better luck next time!");
            computer_score+=1;
        }

        int [] scores = {user_score, computer_score};

        return scores;
    }

    private boolean isUserWinning() {
        return (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
               (userChoice.equals("paper") && computerChoice.equals("rock")) ||
               (userChoice.equals("scissors") && computerChoice.equals("paper"));
    }
}
