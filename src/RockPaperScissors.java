import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter your choice (Rock, Paper, Scissors) or 'exit' to end: ");
            String userChoice = scanner.nextLine().toLowerCase();


            if (userChoice.equals("exit")) {
                System.out.println("Thanks for playing. Goodbye!");
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


            System.out.println(String.format("You Picked %s | Computer picked %s", userChoice, computerChoice));


            RockPaperScissorsGame game = new RockPaperScissorsGame(userChoice.toLowerCase(), computerChoice.toLowerCase());
            game.play();
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

    public void play() {
        if (userChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if (isUserWinning()) {
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("Computer wins. Better luck next time!");
        }
    }

    private boolean isUserWinning() {
        return (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
               (userChoice.equals("paper") && computerChoice.equals("rock")) ||
               (userChoice.equals("scissors") && computerChoice.equals("paper"));
    }
}
