import Exceptions.InvalidActionException;

/**
 * Created by sfang on 8/19/15.
 */
public interface Action {
    boolean act(Cell cell) throws InvalidActionException;
}
