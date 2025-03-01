package com.sourceallies.interview;

import java.util.ArrayList;
import java.util.HashMap;

public class PokerHand {
    private String hand = "";
    private String[] handAsCards;
    private PokerRank rank;

    PokerHand(String hand){
        this.hand = hand;
        this.handAsCards = generateHand(this.hand);
        calcRank();
    }

    public String getHand(){
        return hand;
    }

    public PokerRank getRank(){
        return rank;
    }

    private void calcRank(){
        if(containsTwoPairs()){
            this.rank = PokerRank.TWOPAIRS;
        }else if(containsPair()){
            this.rank = PokerRank.PAIR;
        }else{
            this.rank = PokerRank.HIGHCARD;
        }
    }

    private boolean containsPair(){
        HashMap<Character, Integer> counts = new HashMap<>();

        for(int i = 0; i < handAsCards.length; i++){
            var currentCardValue = handAsCards[i].charAt(0);
            var currentCount = counts.getOrDefault(currentCardValue, 0) + 1;
            counts.put(currentCardValue, currentCount);

            if(currentCount >= 2){
                return true;
            }
        }

        return false;
    }

    private boolean containsTwoPairs(){

        HashMap<Character, Integer> counts = new HashMap<>();
        int pairCount = 0;

        for(int i = 0; i < handAsCards.length; i++){
            var currentCardValue = handAsCards[i].charAt(0);
            var currentCount = counts.getOrDefault(currentCardValue, 0) + 1;
            counts.put(currentCardValue, currentCount);
        }

        for(Character key : counts.keySet()){
            //get value
            int value = counts.get(key);
            if(value == 2){
                pairCount++;
            }
        }

        return pairCount == 2;
    }

    public static String[] generateHand(String handAsString){
        return handAsString.split(" ");
    }


}
