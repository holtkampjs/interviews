package com.sourceallies.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PokerHandsTest{

    // @Test
    // void shouldGetPokerHand(){
    //     PokerHand hand = new PokerHand("2H 3D 5S 9C KD");
    //     Card[] cards = hand.getHand();
    //     assertEquals(5, cards.length);
    //     assertEquals(CardValue.TWO, cards);
    //     assertEquals(hand.getHand(), "2H 3D 5S 9C KD");
    // }

    @Test
    void shouldBeHighCard(){
        PokerHand hand = new PokerHand("2H 3D 5S 9C KD");
        assertEquals(PokerRank.HIGHCARD, hand.getRank());
    }

    @Test
    void shouldBePair(){
        PokerHand hand = new PokerHand("2H 2D 5S 9C KD");
        assertEquals(PokerRank.PAIR, hand.getRank());
    }

    @Test
    void shouldBeTwoPair(){
        PokerHand hand = new PokerHand("2H 2D 5S 5C 3D");
        assertEquals(PokerRank.TWOPAIRS, hand.getRank());
    }

    @Test
    void shouldBeThreeOfAKind(){
        PokerHand hand = new PokerHand("2H 5D 5S 5C 3D");
        assertEquals(PokerRank.THREEOFAKIND, hand.getRank());
    }

    @Test
    void shouldBeStraight_preSort(){
        PokerHand hand = new PokerHand("2H 3C 4S 5H 6H");
        assertEquals(PokerRank.STRAIGHT, hand.getRank());
    }

    @Test
    void shouldBeStraight_withSort(){
        PokerHand hand = new PokerHand("2H 3C 4S 6H 5H");
        assertEquals(PokerRank.STRAIGHT, hand.getRank());
    }

    

    // @Test
    // void shouldBeFlush(){
    //     PokerHand hand = new PokerHand("2H 5H 3H 4H 6H");
    //     assertEquals(PokerRank.FLUSH, hand.getRank());
    // }
    
}
