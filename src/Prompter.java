import java.util.Scanner;

// display
public class Prompter {
  private Game game;

  public Prompter(Game game) {
    this.game = game;
  }

  public boolean promptForGuess() {
    Scanner scanner = new Scanner(System.in);
    boolean isHit = false;
    boolean isAcceptable = false;

    do {
      System.out.print("Please enter a letter:  ");
      String guessInput = scanner.nextLine();
      try {
        isHit = game.applyGuess(guessInput);
        isAcceptable = true;
      } catch(IllegalArgumentException e) {
        System.out.println(e.getMessage());
      }

    } while(!isAcceptable);

    return isHit;
  }
  public void displayProgress() {
    System.out.printf("Your have %d tries to solve:  %s%n",
            game.getRemainingTries(),
            game.getCurrentProgress());
  }
  public void displayOutcome() {
    if(game.isWon()) {
      System.out.println("Woohoo you won! The answer is " + game.getAnswer());
    } else {
      System.out.println("Sorry, you ran out of guesses. The answer is %s" + game.getAnswer() +  ". Better luck next time!");
    }
  }
}
