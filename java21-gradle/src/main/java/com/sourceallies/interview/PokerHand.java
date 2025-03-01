package com.sourceallies.interview;

import java.util.HashMap;

public class PokerHand {
    private final String hand;
    private Card[] cards;
    private PokerRank rank;
    private HashMap<CardValue, Integer> counts;

    PokerHand(String hand){
        this.hand = hand;
        this.cards = convertHandToCards();
        this.counts = generateCountsMap();
        calcRank();
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

    private void calcRank(){
        if(isThreeOfAKind()){
            this.rank = PokerRank.THREEOFAKIND;
        }else if(containsTwoPairs()){
            this.rank = PokerRank.TWOPAIRS;
        }else if(containsPair()){
            this.rank = PokerRank.PAIR;
        }else{
            this.rank = PokerRank.HIGHCARD;
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

    //Getters and Setters
    public String getHand(){
        return hand;
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

    //Static Functions
    private String[] generateHandAsStrings(String handAsString){
        return handAsString.split(" ");
    }

    private Card[] convertHandToCards(){
        String[] tempHand = generateHandAsStrings(this.hand);
        Card[] cards = new Card[5];

        for(int i = 0; i < cards.length; i++){
            cards[i] = new Card(tempHand[i]);
        }

        return cards;
    }

}
