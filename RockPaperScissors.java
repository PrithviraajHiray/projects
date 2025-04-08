import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

   
    enum Choice {
        ROCK, PAPER, SCISSORS;

      
        public String compareChoices(Choice opponentCh) {
            
            if (this == opponentCh) {
                return "It's a tie!";
            }

            
            switch (this) {
                case ROCK:
                    return (opponentCh == SCISSORS) ? "You win!" : "Computer wins!";
                case PAPER:
                    return (opponentCh == ROCK) ? "You win!" : "Computer wins!";
                case SCISSORS:
                    return (opponentCh == PAPER) ? "You win!" : "Computer wins!";
                default:
                    
                    return "Invalid comparison";
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        Random random = new Random();           
        Choice[] ch = Choice.values();     

        System.out.println("Let's play Rock Paper Scissors!");

        boolean playAgain = true;

        while (playAgain) {
            
            Choice userCh = null;
            while (userCh == null) { 
                System.out.print("\nEnter your choice (rock, paper, or scissors): ");
                String userInput = scanner.nextLine().trim().toUpperCase(); 

                try {
                    userCh = Choice.valueOf(userInput); 
                } catch (IllegalArgumentException e) {
                    
                    System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissors'.");
                }
            }

            
            Choice computerCh = ch[random.nextInt(ch.length)]; 

            
            System.out.println("You chose: " + userCh);
            System.out.println("Computer chose: " + computerCh);

            
            String result = userCh.compareChoices(computerCh);
            System.out.println(result);

           
            System.out.print("\nPlay again? (yes/no): ");
            String playAgainIn = scanner.nextLine().trim().toLowerCase();
            if (!playAgainIn.equals("yes") && !playAgainIn.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");
        scanner.close(); 
    }
}