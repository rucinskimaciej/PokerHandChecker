package online.rumac.main.view.game.implementation.pokerHandComparingGameFromDeck;

import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.view.game.interfaces.Playable;

import java.util.List;
import java.util.Map;

public class Game extends PokerHandComparingGameFromDeck implements Playable {

    private String[] players;
    private final List<List<PokerHand>> games;
    private Map<String, Integer> scoreboard;

    private Game(int games, int players) {
        super(games, players);
        this.games = PokerHandComparingGameFromDeck.buildGameSetup(games, players);
    }


    public static Game build(int gamesCount, String ... players) {
        Game game = new Game(gamesCount, players.length);
        game.players = players;
        game.scoreboard = game.buildPlayersMap(players);
        return game;
    }

    @Override
    public void play() {

        processGame(games, players, scoreboard);
        printScoreBoard(scoreboard);

    }

}
