package com.sourceallies.interview;

import java.util.HashMap;
import java.util.Arrays;

public class PokerHand {
    private final String hand;
    private Card[] cards;
    private PokerRank rank;
    private HashMap<CardValue, Integer> counts;

    PokerHand(String hand){
        this.hand = hand;
        this.cards = convertHandToCards();
        this.counts = generateCountsMap();
        this.rank = calcRank();
    }

    private HashMap<CardValue, Integer> generateCountsMap(){
        HashMap<CardValue, Integer> counts = new HashMap<>();

        for(int i = 0; i < cards.length; i++){
            var currentCardValue = this.cards[i].getValue();
            var currentCount = counts.getOrDefault(currentCardValue, 0) + 1;
            counts.put(currentCardValue, currentCount);
        }

        return counts;
    }

    private PokerRank calcRank(){
        if(isFlush()){
            return PokerRank.FLUSH;
        }else if(isStraight()){
            return PokerRank.STRAIGHT;
        }else if(isThreeOfAKind()){
            return PokerRank.THREEOFAKIND;
        }else if(containsTwoPairs()){
            return PokerRank.TWOPAIRS;
        }else if(containsPair()){
            return PokerRank.PAIR;
        }else{
            return PokerRank.HIGHCARD;
        }
    }

    private boolean containsPair(){
        return countPairs() == 1;
    }

    private boolean containsTwoPairs(){
        return countPairs() == 2;
    }

    private boolean isThreeOfAKind(){
        for(CardValue key : this.counts.keySet()) {
            if(counts.get(key) == 3) return true;
        }

        return false;
    }

    //5 consecutive values
    private boolean isStraight(){
        int initialVal = cards[0].getValue().getInt();

        if( (initialVal + 1) == cards[1].getValue().getInt() &&
            (initialVal + 2) == cards[2].getValue().getInt() &&
            (initialVal + 3) == cards[3].getValue().getInt() &&
            (initialVal + 4) == cards[4].getValue().getInt()) 
        {
            return true;
        }

        return false;
    }

    private boolean isFlush(){
        //get suit of first
        Suit suit = cards[0].getSuit();

        if( suit == cards[1].getSuit() &&
            suit == cards[2].getSuit() &&
            suit == cards[3].getSuit() &&
            suit == cards[4].getSuit() ) 
        {
            return true;
        }

        return false;
    }

    //Getters and Setters
    public Card[] getHand(){
        return cards;
    }

    public PokerRank getRank(){
        return rank;
    }

    //Helper Functions
    private int countPairs(){
        int pairCount = 0;
        for(CardValue key : this.counts.keySet()) {
            if(this.counts.get(key) == 2){
                pairCount++;
            }
        }
        return pairCount;
    }

    private Card[] convertHandToCards(){
        String[] tempHand = this.hand.split(" ");
        Card[] cards = new Card[5];

        for(int i = 0; i < cards.length; i++){
            cards[i] = new Card(tempHand[i]);
        }
        
        Arrays.sort(cards);
        return cards;
    }

}
