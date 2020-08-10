package online.rumac.main.model.hand;

import online.rumac.main.controller.figure.Util;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.exceptions.HandSizeException;
import online.rumac.main.model.card.Card;

import java.util.Map;
import java.util.Set;

public abstract class Hand {
    protected final Set<Card> cards;
    private final int handSize;
    private final Map<CardValue, Integer> cardValueMap;

    protected Hand(Set<Card> cards, int handSize) throws HandSizeException {
        if (handSize <= 0) {
            throw new HandSizeException("'handSize' value must be > 0");
        }
        if (cards == null) {
            throw new HandSizeException("Cards set cannot be null");
        }
        if (cards.size() != handSize) {
            throw new HandSizeException(String.format("Number of cards on hand is not equal to required %d cards", handSize));
        } else {
            this.handSize = handSize;
            this.cards = cards;
            this.cardValueMap = Util.mapCardValues(cards);
        }
    }

    public static Hand buildHand(Set<Card> cards) {
        try {
            return new Hand(cards, cards.size()) {
                @Override
                public Set<Card> getCards() {
                    return super.getCards();
                }

                @Override
                public Map<CardValue, Integer> getCardValueMap() {
                    return super.getCardValueMap();
                }

                @Override
                public String toString() {
                    return super.toString();
                }
            };
        } catch (HandSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public Map<CardValue, Integer> getCardValueMap() {
        return cardValueMap;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (cards == null) {
            return output.toString();
        }

        for (Card card : cards) {
            output.append(card.toString()).append(" ");
        }
        return output.toString();
    }
}