package online.rumac.main;

import online.rumac.main.view.game.implementation.pokerHandComparingGameFromDeck.Game;

public class MainDeckSourceImplementation {
    public static void main(String[] args) {

        System.out.println("Deck generator implementation");
        int numberOfGames = 10000;
        String[] playersNames = producePlayersNames("Player", 10);

        Game game = Game.build(numberOfGames, playersNames);
        game.play();

    }

    private static String[] producePlayersNames(String name, int count) {
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            names[i] = name + (i + 1);
        }
        return names;
    }
}
