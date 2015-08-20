package actions;

import Exceptions.InvalidActionException;
import src.Cell;

/**
 * Created by sfang on 8/19/15.
 */
public interface Action {
    void act(Cell cell) throws InvalidActionException;
}
