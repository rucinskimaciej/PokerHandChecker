package online.rumac.main.view.game.implementation.pokerHandComparingGameFromFile;

import online.rumac.main.model.hand.PokerHand;
import online.rumac.main.view.game.interfaces.PokerHandsComparingGame;
import online.rumac.main.view.game.source.FromFile;

import java.util.*;
import java.util.stream.Collectors;

class PokerHandComparingGameBuilderFromFile implements PokerHandsComparingGame {

    private final int playersCount;

    protected PokerHandComparingGameBuilderFromFile(int players_count) {
        playersCount = players_count;
    }

    protected static List<List<PokerHand>> buildGameSetup(String filePath, int playersCount) {
        return new PokerHandComparingGameBuilderFromFile(playersCount).getGameList(filePath);
    }

    public List<List<PokerHand>> getGameList(String filePath) {
        List<String> stringList = FromFile.buildLines(filePath);

        return stringList.stream()
                .map(s -> mapToPokerHandList(s, playersCount))
                .collect(Collectors.toList());
    }

    @Override
    public List<List<PokerHand>> getGameList(Object filePath) {
        return getGameList((String) filePath);
    }

}
