package com.sourceallies.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PokerHandsTest{
    
    @Test
    void shouldSayHelloWorld() {
        var solution = new Solution();
        assertEquals("Hello, world!", solution.getGreeting());
    }

    // @Test
    // void shouldCreatePokerHand(){
    //     PokerHand hand = new PokerHand();
    // }

    @Test
    void shouldGetPokerHand(){
        PokerHand hand = new PokerHand("2H 3D 5S 9C KD");
        assertEquals(hand.getHand(), "2H 3D 5S 9C KD");
    }

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

    
}
