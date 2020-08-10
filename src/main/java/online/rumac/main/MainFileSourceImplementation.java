package online.rumac.main;

import online.rumac.main.view.game.implementation.pokerHandComparingGameFromFile.Game;


public class MainFileSourceImplementation {
    public static void main(String[] args) {

        System.out.println("File source implementation");
        String filePath = "src\\main\\resources\\poker.txt";
        Game game = Game.build(filePath, "Player1", "Player2");
        game.play();


    }

}
