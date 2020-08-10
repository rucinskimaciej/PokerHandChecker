package online.rumac.main.view.game.interfaces;

import online.rumac.main.controller.comparator.handComparator.PokerHandComparator;
import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.view.game.implementation.util.Util;

import java.util.List;
import java.util.Map;

public interface PokerHandsComparingGame extends Util<PokerHand> {

    List<List<PokerHand>> getGameList(Object dataSource);

    default PokerHand findWinner(List<PokerHand> hands) {
        return hands.stream().max(new PokerHandComparator()).get();
    }


    default void processGame(List<List<PokerHand>> games, String[] players, Map<String, Integer> scoreboard) {

        games.forEach(game -> {
            Map<PokerHand, String> playersHandsMap = matchHandsWithPlayers(game, players);

            PokerHand winner = findWinner(game);
            game.forEach(hand -> {
                if (new PokerHandComparator().compare(hand, winner) == 0) {
                    fillScoreboard(scoreboard, playersHandsMap, hand);
                }
            });
        });
    }

    private void fillScoreboard(Map<String, Integer> scoreboard, Map<PokerHand, String> playersHandsMap, PokerHand hand) {
        scoreboard.merge(playersHandsMap.get(hand), 1, Integer::sum);
    };

    default void printScoreBoard(Map<String, Integer> scoreboard) {
        scoreboard.forEach((player, wins) -> System.out.printf("%s won %s times%n", player, wins));
    }
}
