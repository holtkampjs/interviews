package com.sourceallies.interview;


enum CardValue{

    TWO     ('2'),
    THREE   ('3'),
    FOUR    ('4'),
    FIVE    ('5'),
    SIX     ('6'),
    SEVEN   ('7'),
    EIGHT   ('8'),
    NINE    ('9'),
    TEN     ('T'),
    JACK    ('J'),
    QUEEN   ('Q'),
    KING    ('K'),
    ACE     ('A');
    
    final char value;
    final String cards = "23456789TJQKA";

    CardValue (char value) {
        this.value = value;
    }

    public static CardValue init(char value) {
        CardValue res = CardValue.ACE; // Default
        for (CardValue c : CardValue.values()) {
            if (c.value == value) {
                res = c;
            }
        }
        return res;
    }

    int getInt(){
        return cards.indexOf(this.value);
    }

}