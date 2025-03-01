package com.sourceallies.interview;

enum Suit{
    CLUBS ('C'),
    DIAMONDS ('D'),
    HEARTS ('H'),
    SPADES ('S');

    private final char suit;

    Suit(char character) {
        this.suit = character;
    }

	public static Suit init(char suitChar) {
		Suit suit = Suit.CLUBS; // Default
        for (Suit s : Suit.values()) {
            if (s.suit == suitChar) suit = s;
        }
        return suit;
	}
}