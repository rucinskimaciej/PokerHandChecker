package online.rumac.main.view.interfaces;

import online.rumac.main.model.card.Card;
import online.rumac.main.model.card.Deck;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public interface Dealable<T> {

    T deal(Deck deck, int cardCount);

    List<T> deal(Deck deck, int cardCount, int players);

    default Set<Card> getCardSet(Deck deck, int cardCount) {

        Set<Card> cards = new LinkedHashSet<>();
        while (cards.size() < cardCount) {
            cards.add(deck.popCard());
        }
        return cards;
    }


}
