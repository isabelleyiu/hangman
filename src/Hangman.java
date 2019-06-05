public class Hangman {

    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Usage: Java Hangman <answer>");
            System.err.println("answer is required");
            System.exit(1);
        }

        Game game = new Game(args[0]);
        Prompter prompter = new Prompter(game);

        while(!game.isWon() && game.getRemainingTries() > 0) {
            prompter.displayProgress();
            boolean isHit = prompter.promptForGuess();
            if(isHit) {
                System.out.println("Yes, that's in there.");
            } else {
                System.out.println("Nope");
            }
        }
        prompter.displayOutcome();
    }
}
