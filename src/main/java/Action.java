import Exceptions.InvalidActionException;

/**
 * Created by sfang on 8/19/15.
 */
public interface Action {
    void act(Cell cell) throws InvalidActionException;
}
