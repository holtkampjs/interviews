package com.sourceallies.interview;

import java.util.ArrayList;

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
        if(containsPair()){
            this.rank = PokerRank.PAIR;
        }else{
            this.rank = PokerRank.HIGHCARD;
        }
    }

    private boolean containsPair(){
        for(int i = 0; i < handAsCards.length-1; i++){
            var currentCardValue = handAsCards[i].charAt(0);
            for(int j = i+1; j < handAsCards.length; j++){
                var nextCardValue = handAsCards[j].charAt(0);
                if(currentCardValue == nextCardValue){
                    return true;
                }
                
            }
        }
        
        return false;
    }

    public static String[] generateHand(String handAsString){
        return handAsString.split(" ");
    }


}
