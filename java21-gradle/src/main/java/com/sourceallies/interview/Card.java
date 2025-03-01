package com.sourceallies.interview;

public class Card implements Comparable<Card>{
    char suitChar;
    char valueChar;
    private final CardValue value;
    private final Suit suit;

    public Card(String cardString){
        this.value = CardValue.init(cardString.charAt(0));
        this.suit = Suit.init(cardString.charAt(1));
    }

    @Override
    public int compareTo(Card o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    public Suit getSuit(){
        return this.suit;
    }

    public CardValue getValue() {
        return this.value;
    }


}