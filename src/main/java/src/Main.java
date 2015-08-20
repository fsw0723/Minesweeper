package src;

import Exceptions.InvalidInputException;

public class Main {

    public static void main(String[] args) throws InvalidInputException {
        Game game = new Game();
        boolean result = game.start();
        game.printResult(result);
    }


}
