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
    void shouldReturnHandAsListOfStrings(){
        var result = PokerHand.generateHand("2H 2D 5S 9C KD");
        assert(result.length == 5);
        assertEquals("2H", result[0]);
        assertEquals("2D", result[1]);
        assertEquals("5S", result[2]);
        assertEquals("9C", result[3]);
        assertEquals("KD", result[4]);
    }

    @Test
    void shouldBeHighCard(){
        PokerHand hand = new PokerHand("2H 3D 5S 9C KD");
        assertEquals(hand.getRank(), PokerRank.HIGHCARD);
    }

    @Test
    void shouldBePair(){
        PokerHand hand = new PokerHand("2H 2D 5S 9C KD");
        assertEquals(hand.getRank(), PokerRank.PAIR);
    }

}
