import Exceptions.InvalidInputException;

/**
 * Created by sfang on 8/19/15.
 */
public class Main {

    public static void main(String[] args) throws InvalidInputException {
        Game game = new Game();
        boolean result = game.start();
        game.printResult(result);
    }


}
