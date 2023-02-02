public enum Face {
    ACE(1, "Ace"), TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"),
    EIGHT(8, "8"), NINE(9, "9"), TEN(10, "10"), JACK(11, "Jack"), QUEEN(12, "Queen"), KING(13, "King"),
    JOKER(0, "Joker");

    final int value;
    final String name;

    Face(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
