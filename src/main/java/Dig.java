import Exceptions.InvalidActionException;

/**
 * Created by sfang on 8/19/15.
 */
public class Dig implements Action {
    public void act(Cell cell) throws InvalidActionException {
        cell.dig();
    }
}
