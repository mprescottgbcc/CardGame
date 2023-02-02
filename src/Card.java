/**
 * An object of type Card represents a playing card from a
 * standard Poker deck, including Jokers.  The card has a suit, which
 * can be spades, hearts, diamonds, clubs, or joker.  A spade, heart,
 * diamond, or club has one of the 13 values: ace, 2, 3, 4, 5, 6, 7,
 * 8, 9, 10, jack, queen, or king.  Note that "ace" is considered to be
 * the smallest value.
 */
public class Card {
    private final Suit suit;
    private final Face face;

    /**
     * Creates a Joker by default. Note that "new Card()" is equivalent to
     * "new Card(Suit.JOKER, Face.JOKER)".
     */
    public Card() {
        this(null, Face.JOKER);
    }

    /**
     * Creates a card with a specified suit and face value.
     *
     * @param suit the suit of the new card.
     * @param face the face for the card.
     */
    public Card(Suit suit, Face face) {
        this.face = face;
        this.suit = suit;
    }

    /**
     * Returns the suit of this card.
     *
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Returns the face of this card.
     *
     * @return the face.
     */
    public Face getFace() {
        return face;
    }

    /**
     * Returns a string representation of this card, including both
     * its suit and its value (except that for a Joker with value 1,
     * the return value is just "Joker").  Sample return values
     * are: "Queen of Hearts", "10 of Diamonds", "Ace of Spades",
     * "Joker", "Joker #2"
     */
    public String toString() {
        return (suit == null) ? "JOKER!" : face.name + " of " + suit.name;
    }
}
