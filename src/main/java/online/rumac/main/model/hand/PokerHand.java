package online.rumac.main.model.hand;

import online.rumac.main.model.exceptions.HandSizeException;
import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.Deck;
import online.rumac.main.controller.comparator.handComparator.PokerHandComparator;
import online.rumac.main.controller.figure.PokerFigure;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PokerHand extends Hand {

    public static final int POKER_HAND_SIZE = 5;
    private PokerFigure pokerFigure;

    private PokerHand(Set<Card> hand, int handSize) throws HandSizeException {
        super(hand, handSize);
    }

    public static PokerHand build(Deck deck) {
        Set<Card> cards = new LinkedHashSet<>();

        for (int i = 0; i < POKER_HAND_SIZE; i++) {
            cards.add(deck.popCard());
        }
        return PokerHand.build(cards);
    }

    public static PokerHand build(PokerHand hand) {
        if (hand != null) {
            return PokerHand.build(hand.cards);
        }
        return null;
    }

    public static PokerHand build(Set<Card> cards) {
        if (cards != null) {
            try {
                PokerHand newHand = new PokerHand(cards, POKER_HAND_SIZE);
                newHand.pokerFigure = PokerFigure.check(newHand);
                return newHand;
            } catch (HandSizeException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static PokerHand build(List<String> cardsStr) {
        return buildFromStream(cardsStr.stream());
    }

    public static PokerHand build(String[] cardsStr) {
        return buildFromStream(Arrays.stream(cardsStr));
    }

    public static int compare(PokerHand hand1, PokerHand hand2) {
        return new PokerHandComparator().compare(hand1, hand2);
    }

    private static PokerHand buildFromStream(Stream<String> stream) {
        Card.Builder builder = new Card.Builder();
        Set<Card> cards = stream
                .map(c -> builder.card(c).build())
                .collect(Collectors.toSet());
        return PokerHand.build(cards);
    }

    public PokerFigure getPokerFigure() {
        return pokerFigure;
    }
}
