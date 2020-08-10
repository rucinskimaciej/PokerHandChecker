package online.rumac.main.model.hand;

import online.rumac.main.model.exceptions.HandSizeException;
import online.rumac.main.model.card.Card;
import online.rumac.main.model.deck.Deck;
import online.rumac.main.controller.comparator.handComparator.PokerHandComparator;
import online.rumac.main.controller.figure.PokerFigure;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHand extends Hand {

    public static final int POKER_HAND_SIZE = 5;
    private final PokerFigure pokerFigure;

    private PokerHand(Builder builder) throws HandSizeException {
        super(builder.cards, POKER_HAND_SIZE);
        this.pokerFigure = builder.pokerFigure;
    }

    public PokerFigure getPokerFigure() {
        return pokerFigure;
    }


    public static class Builder {

        private Set<Card> cards;
        private PokerFigure pokerFigure;

        public Builder cards(Set<Card> cards) {
            this.cards = cards;
            return this;
        }

        public PokerHand build() throws HandSizeException {
            return new PokerHand(this);
        }

        public PokerHand build(Set<Card> cards) {
            if (cards != null) {
                try {
                    this.cards = cards;
                    PokerHand hand = build();
                    this.pokerFigure = PokerFigure.check(hand);
                    return build();
                } catch (HandSizeException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        public PokerHand build(List<String> cardsStr) {
            return buildFromStream(cardsStr.stream());
        }

        public PokerHand build(String[] cardsStr) {
            return buildFromStream(Arrays.stream(cardsStr));
        }

        private PokerHand buildFromStream(Stream<String> stream) {
            Card.Builder builder = new Card.Builder();
            Set<Card> cards = stream
                    .map(c -> builder.card(c).build())
                    .collect(Collectors.toSet());
            return build(cards);
        }

        public PokerHand build(Deck deck) {
            Set<Card> cards = new LinkedHashSet<>();

            for (int i = 0; i < POKER_HAND_SIZE; i++) {
                cards.add(deck.popCard());
            }
            return build(cards);
        }

        public PokerHand build(PokerHand hand) {
            if (hand != null) {
                return build(cards);
            }
            return null;
        }
    }
}
