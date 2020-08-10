package online.rumac.main.view.game.implementation.pokerHandComparingGameFromDeck;

import online.rumac.main.model.card.Deck;
import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.view.dataInput.fromDeck.PokerHandCroupier;
import online.rumac.main.view.game.implementation.util.Util;
import online.rumac.main.view.game.interfaces.PokerHandsComparingGame;

import java.util.LinkedList;
import java.util.List;

public class PokerHandComparingGameFromDeck implements PokerHandsComparingGame, Util<PokerHand> {

    private final int gamesCount;
    private final int playersCount;

    protected PokerHandComparingGameFromDeck(int gamesCount, int playersCount) {
        this.gamesCount = gamesCount;
        this.playersCount = playersCount;
    }

    protected static List<List<PokerHand>> buildGameSetup(int gamesCount, int playersCount) {
        PokerHandComparingGameFromDeck game = new PokerHandComparingGameFromDeck(gamesCount, playersCount);
        return game.getGameList(new PokerHandCroupier());
    }


    @Override
    public List<List<PokerHand>> getGameList(Object dataSource) {
        return getGameList((PokerHandCroupier) dataSource);
    }

    public List<List<PokerHand>> getGameList(PokerHandCroupier croupier) {
        List<List<PokerHand>> gameList = new LinkedList<>();
        for (int i = 0; i < gamesCount; i++) {
            gameList.add((croupier).deal(Deck.build(), PokerHand.POKER_HAND_SIZE, playersCount));
        }
        return gameList;
    }
}
