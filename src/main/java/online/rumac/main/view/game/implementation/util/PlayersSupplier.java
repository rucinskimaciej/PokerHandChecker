package online.rumac.main.view.game.implementation.util;

import online.rumac.main.model.hand.Hand;

import java.util.*;

public interface PlayersSupplier<T> {

    default Map<T, String> matchHandsWithPlayers(List<T> hands, String[] players) {
        Map <T, String> handStringMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            handStringMap.put(hands.get(i), players[i]);
        }
        return handStringMap;
    }

    default Map<String, Integer> buildPlayersMap(String[] players) {
        Map<String, Integer> playersMap = new LinkedHashMap<>();
        Arrays.stream(players).forEach(p -> playersMap.put(p, 0));
        return playersMap;
    }

}
