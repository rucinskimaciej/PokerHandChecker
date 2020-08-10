package online.rumac.main.view.dataInput.fromDeck;

import online.rumac.main.model.card.Deck;
import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.view.interfaces.Dealable;

import java.util.LinkedList;
import java.util.List;

public class PokerHandCroupier implements Dealable<PokerHand> {

    public static List<PokerHand> dealPokerHand(Deck deck, int players) {
        return new PokerHandCroupier().deal(deck, PokerHand.POKER_HAND_SIZE, players);
    }

    @Override
    public PokerHand deal(Deck deck, int cardCount) {
        return PokerHand.build(deck);
    }

    @Override
    public List<PokerHand> deal(Deck deck, int cardCount, int players) {
        List<PokerHand> hands = new LinkedList<>();
        while (hands.size() < players) {
            hands.add(deal(deck, cardCount));
        }
        return hands;
    }
}
