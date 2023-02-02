import textio.TextIO;

/**
 * This program lets the user play HighLow, a simple card game
 * that is described in the output statement at the beginning of
 * the main() routine.  After the user plays several games,
 * the user's average score is reported.
 */
public class HighLow {
    public static void main(String[] args) {
        System.out.println("""
                This program lets you play the simple card game,
                HighLow.  A card is dealt from a deck of cards.
                You have to predict whether the next card will be
                higher or lower.  Your score in the game is the
                number of correct predictions you make before
                you guess wrong.
                """);

        int gamesPlayed = 0;
        int sumOfScores = 0;
        double averageScore;
        boolean playAgain;

        do {
            int scoreThisGame;
            scoreThisGame = play();
            sumOfScores += scoreThisGame;
            gamesPlayed++;
            System.out.print("Play again? ");
            playAgain = TextIO.getlnBoolean();
        } while (playAgain);

        averageScore = ((double) sumOfScores) / gamesPlayed;

        System.out.println();
        System.out.println("You played " + gamesPlayed + " games.");
        System.out.printf("Your average score was %1.3f.\n", averageScore);
    }


    /**
     * Lets the user play one game of HighLow, and returns the
     * user's score in that game.  The score is the number of
     * correct guesses that the user makes.
     */
    private static int play() {
        Deck deck = new Deck();
        Card currentCard;
        Card nextCard;

        int correctGuesses;
        char guess;
        deck.shuffle();
        correctGuesses = 0;
        currentCard = deck.dealCard();
        System.out.println("The first card is the " + currentCard);

        while (true) {  // Loop ends when user's prediction is wrong.
            /* Get the user's prediction, 'H' or 'L' (or 'h' or 'l'). */
            System.out.print("Will the next card be higher (H) or lower (L)?  ");
            do {
                guess = TextIO.getlnChar();
                guess = Character.toUpperCase(guess);
                if (guess != 'H' && guess != 'L')
                    System.out.print("Please respond with H or L:  ");
            } while (guess != 'H' && guess != 'L');

            nextCard = deck.dealCard();
            System.out.println("The next card is " + nextCard);

            if (nextCard.getFace().value == currentCard.getFace().value) {
                System.out.println("The value is the same as the previous card.");
                System.out.println("You lose on ties.  Sorry!");
                break;  // End the game.
            } else if (nextCard.getFace().value > currentCard.getFace().value) {
                if (guess == 'H') {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break;  // End the game.
                }
            } else {  // nextCard is lower
                if (guess == 'L') {
                    System.out.println("Your prediction was correct.");
                    correctGuesses++;
                } else {
                    System.out.println("Your prediction was incorrect.");
                    break;  // End the game.
                }
            }

            currentCard = nextCard;
            System.out.println();
            System.out.println("The card is " + currentCard);

        } // end of while loop

        System.out.println();
        System.out.println("The game is over.");
        System.out.println("You made " + correctGuesses
                + " correct predictions.");
        System.out.println();

        return correctGuesses;

    }
}
