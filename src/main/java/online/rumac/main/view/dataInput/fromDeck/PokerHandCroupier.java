package online.rumac.main.view.dataInput.fromDeck;

import online.rumac.main.model.deck.Deck;
import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.view.interfaces.Dealable;

import java.util.LinkedList;
import java.util.List;

public class PokerHandCroupier implements Dealable<PokerHand> {

    @Override
    public PokerHand deal(Deck deck, int cardCount) {
        return new PokerHand.Builder().build(deck);
    }

    @Override
    public List<PokerHand> deal(Deck deck, int cardCount, int players) {
        List<PokerHand> hands = new LinkedList<>();
        deck.shuffle();
        while (hands.size() < players) {
            hands.add(deal(deck, cardCount));
        }
        return hands;
    }
}
