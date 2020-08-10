package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.Suit;
import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.model.card.CardValue;

import java.util.*;

public class HighCard extends Figure {

    @Override
    public PokerFigure check(PokerHand hand) {
        return isHighCard(hand) ? PokerFigure.HIGH_CARD : null;
    }

    private boolean isHighCard(PokerHand hand) {
        TreeMap<CardValue, Integer> cardValueMap = new TreeMap<>();
        Map<Suit, Integer> suitCounter = new HashMap<>(Suit.values().length);

        for (Card card : hand.getCards()) {
            cardValueMap.merge(card.getCardValue(), 1, Integer::sum);
            suitCounter.merge(card.getSuit(), 1, Integer::sum);
        }
        if (cardValueMap.size() < hand.getCards().size()) {
            return false;
        }
        if (suitCounter.size() == 1) {
            return false;
        }
        int lowest = cardValueMap.firstKey().ordinal();
        int highest = cardValueMap.lastKey().ordinal();
        boolean notStraightType = lowest + 4 < highest;
        return notStraightType;
    }
}
