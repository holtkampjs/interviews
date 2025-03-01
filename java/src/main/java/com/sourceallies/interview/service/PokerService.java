package com.sourceallies.interview.service;

import java.util.HashMap;

import com.sourceallies.interview.enums.HandTypes;

public class PokerService {

    HashMap<String, Integer> rankingMap = new HashMap<>();
    HashMap<Integer, String> cardNameMap = new HashMap<>();
    private char[] handRankings = {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};


    public PokerService() {
        rankingMap.put("2", 2);
        rankingMap.put("3", 3);
        rankingMap.put("4", 4);
        rankingMap.put("5", 5);
        rankingMap.put("6",6);
        rankingMap.put("7", 7);
        rankingMap.put("8", 8);
        rankingMap.put("9", 9);
        rankingMap.put("T", 10);
        rankingMap.put("J", 11);
        rankingMap.put("Q", 12);
        rankingMap.put("K", 13);
        rankingMap.put("A", 14);

        cardNameMap.put(10, "TEN");
        cardNameMap.put(11, "JACK");
        cardNameMap.put(12, "QUEEN");
        cardNameMap.put(13, "KING");
        cardNameMap.put(14, "ACE");
    }

    public String pokerHand(String blackHand, String whiteHand) {
        var blackHandValues = blackHand.split(" ");
        var whiteHandValues = whiteHand.split(" ");

        int whiteHighCard = 0;
        int blackHighCard = 0;
        HandTypes whiteTypeOfHand = HandTypes.HighCard;
        HandTypes blackTypeOfHand = HandTypes.HighCard;

        for (int i = 0; i < blackHandValues.length ; i++) {
            int rank = rankingMap.get(blackHandValues[i]);
            if (blackHighCard < rank) {
                blackHighCard = rank;
            } else if (blackHighCard == rank) {
                blackTypeOfHand = HandTypes.Pair;
            }
        }

        for (int i = 0; i < whiteHandValues.length ; i++) {
            int rank = rankingMap.get(whiteHandValues[i]);
            if (whiteHighCard < rank) {
                whiteHighCard = rank;
            } else if (whiteHighCard == rank) {
                whiteTypeOfHand = HandTypes.Pair;
            }
        }

        if (blackTypeOfHand.compareTo(whiteTypeOfHand) > 0) {
            return "Black hand wins - " + blackTypeOfHand.name();
        } else if (blackTypeOfHand.compareTo(whiteTypeOfHand) == 0) {
            if (whiteHighCard > blackHighCard) {
                String cardValue = cardNameMap.get(whiteHighCard);
                if (cardValue != null) {
                    return "White hand wins - high card: " + cardValue;
                } else {
                    return "White hand wins - high card: " + whiteHighCard;
                }
            } else if (whiteHighCard == blackHighCard) {
                return "Tie";
            } else {
                String cardValue = cardNameMap.get(blackHighCard);
                if (cardValue != null) {
                    return "Black hand wins - high card: " + cardValue;
                } else {
                    return "Black hand wins - high card: " + blackHighCard;
                }
            }
        } else {
            return "White hand wins - " + whiteTypeOfHand.name();
        }
    }
}

private void calculateHighCardValue(int highHighValue, char[] charList) {
    
}