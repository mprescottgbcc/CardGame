public enum Suit {
    SPADES(1, "Spades"), HEARTS(2, "Hearts"), DIAMONDS(3, "Diamonds"), CLUBS(4, "Clubs");
    final int value;
    final String name;

    Suit(int value, String name) {
        this.value = value;
        this.name = name;
    }
}
