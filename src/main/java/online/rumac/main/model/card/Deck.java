package online.rumac.main.model.card;

import online.rumac.main.model.exceptions.NoSuchCardInDeckException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Deck {

    private List<Card> deck;

    private Deck() {}

    public static Deck build() {
        return deckBuilder(new Deck());
    }

    private static Deck deckBuilder(Deck deckBuilder) {
        List<Integer> valOrdinal = IntStream.rangeClosed(0, 12).boxed().collect(Collectors.toList());
        List<Integer> suitOrdinal = IntStream.rangeClosed(0, 3).boxed().collect(Collectors.toList());

        deckBuilder.deck = new LinkedList<>();

        Card.Builder builder = new Card.Builder();

        for (Integer value : valOrdinal) {
            for (Integer suit : suitOrdinal) {
                Card card = builder.value(CardValue.values()[value]).suit(Suit.values()[suit]).build();
                deckBuilder.deck.add(card);
            }
        }
        Collections.shuffle(deckBuilder.deck);
        return deckBuilder;
    }

    public int cardCount() {
        return deck.size();
    }

    public Card popCard() {
        Card card;
        try {
            card = deck.iterator().next();
            deck.remove(card);
            return card;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public Card popCard(String card) throws NoSuchCardInDeckException {
        Card.Builder builder = new Card.Builder();

        Card c = builder.card(card).build();
        if (deck.remove(c)) {
            return c;
        } else {
            throw new NoSuchCardInDeckException(String.format("\"%s\" - no such card in deck.", card));
        }
    }

}
