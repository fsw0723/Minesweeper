import Exceptions.InvalidActionException;

/**
 * Created by sfang on 8/19/15.
 */
public class Dig implements Action {
    public boolean act(Cell cell) throws InvalidActionException {
        return cell.dig();
    }
}
