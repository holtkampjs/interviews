package com.sourceallies.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.sourceallies.interview.service.PokerService;

public class SolutionTest {
    
    @Test
    void shouldSayHelloWorld() {
        var solution = new Solution();
        assertEquals("Hello, world!", solution.getGreeting());
    }

    @Test
    void testHighCardScoreAceWins() {
        PokerService pokerService = new PokerService();
        String result = pokerService.pokerHand("2 3 5 6 7", "A J 4 9 3");
    
        assertEquals("White hand wins - high card: ACE", result);
    }


    @Test
    void testHighCardScoreJack() {
        PokerService pokerService = new PokerService();
        String result = pokerService.pokerHand("2 3 5 6 7", "2 J 4 9 3");
    
        assertEquals("White hand wins - high card: JACK", result);
    }

    @Test
    void testHighCardNotTenOrAbove() {
        PokerService pokerService = new PokerService();
        String result = pokerService.pokerHand("2 3 5 6 7", "2 6 4 9 3");
    
        assertEquals("White hand wins - high card: 9", result);
    }

    @Test
    void testHighCardBlackHandWins() {
        PokerService pokerService = new PokerService();
        String result = pokerService.pokerHand("Q K 4 8 3", "J 3 9 T J");
    
        assertEquals("Black hand wins - high card: KING", result);
    }

    @Test
    void testHighCardTie() {
        PokerService pokerService = new PokerService();
        String result = pokerService.pokerHand("Q K 4 8 3", "J 3 9 T J");
    
        assertEquals("Black hand wins - high card: KING", result);
    }
}
