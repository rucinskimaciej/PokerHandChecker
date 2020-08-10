package online.rumac.main.view.game.implementation.pokerHandComparingGameFromFile;

import online.rumac.main.controller.comparator.handComparator.PokerHandComparator;
import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.view.game.interfaces.Playable;

import java.util.*;

public final class Game extends PokerHandComparingGameBuilderFromFile implements Playable {

    private final String filePath;
    private final String[] players;
    private final List<List<PokerHand>> games;
    private static Map<String, Integer> scoreboard;

    private Game(String filePath, String[] playerNames) {
        super(playerNames.length);
        this.filePath = filePath;
        this.players = playerNames;
        this.games = PokerHandComparingGameBuilderFromFile.buildGameSetup(this.filePath, playerNames.length);
        scoreboard = buildPlayersMap(players);
    }

    public static Game build(String filePath, String ... players) {
        return new Game(filePath, players);
    }

    @Override
    public void play() {

        processGame(games, players, scoreboard);
        printScoreBoard(scoreboard);

    }
}
