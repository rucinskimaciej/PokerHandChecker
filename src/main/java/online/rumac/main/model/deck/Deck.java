package online.rumac.main.model.deck;

import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.CardValue;
import online.rumac.main.model.card.Suit;
import online.rumac.main.model.exceptions.NoSuchCardInDeckException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// TODO: addCard(Card card) add card to deck;
// TODO: addCards(List<Card> cards) -> add list of cards to deck - check if cards don't double in deck

public class Deck {

    private List<Card> deck;

    private Deck(Builder builder) {
        this.deck = builder.deck;
    }

    public void shuffle() {
        Collections.shuffle(deck);
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

    public int remaining() {
        return deck.size();
    }

    public static class Builder {
        private List<Card> deck;

        public Deck build() {
            this.deck = createDeck();
            return new Deck(this);
        }

        // TODO extract shuffle() to Operations class
        private List<Card> createDeck() {
            List<Integer> valueOrdinalList = IntStream.rangeClosed(0, 12).boxed().collect(Collectors.toList());
            List<Integer> suitOrdinalList = IntStream.rangeClosed(0, 3).boxed().collect(Collectors.toList());

            this.deck = new LinkedList<>();

            Card.Builder builder = new Card.Builder();

            for (Integer suitOrdinal : suitOrdinalList) {
                Suit suit = Suit.values()[suitOrdinal];

                for (Integer valueOrdinal : valueOrdinalList) {
                    CardValue value = CardValue.values()[valueOrdinal];

                    Card card = builder.value(value).suit(suit).build();
                    deck.add(card);

                }
            }

            return deck;
        }
    }

}
