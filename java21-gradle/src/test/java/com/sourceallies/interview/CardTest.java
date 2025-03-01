package com.sourceallies.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CardTest {
    @Test
    void initializeAceOfSpades() {
        var card = new Card("AS");
        assertEquals(CardValue.ACE, card.getValue());
        assertEquals(Suit.SPADES, card.getSuit());
    }
}
