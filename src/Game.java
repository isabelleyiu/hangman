
// game logic
public class Game {
    final public static int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    public Game(String answer) {
        this.answer = answer;
        hits = "";
        misses = "";
    }
    public String getAnswer() {
        return answer;
    }
    private char normalizeGuess(char letter) {
        letter = Character.toLowerCase(letter);

        if(! Character.isLetter(letter)) {
            throw new IllegalArgumentException("Please enter a valid character");
        }

        if(misses.indexOf(letter) >= 0 || hits.indexOf(letter) >= 0) {
            throw new IllegalArgumentException(letter + " have already been guessed.");
        }
        return letter;
    }
    public boolean applyGuess(String letters) {
        if(letters.length() == 0) {
            throw new IllegalArgumentException("One letter is required");
        }
        return applyGuess(letters.charAt(0));
    }
    public boolean applyGuess(char letter) {
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if(isHit) {
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }
    public String getCurrentProgress() {
        String progress = "";
        for(char letter : answer.toCharArray()) {
            if(hits.indexOf(letter) >= 0) {
                progress += letter;
            } else {
                progress += "_ ";
            }
        }
        return progress;
    }
    public int getRemainingTries() {
        return MAX_MISSES - misses.length();
    }
    public boolean isWon() {
        return getCurrentProgress().indexOf('_') == -1 ;
    }
}

