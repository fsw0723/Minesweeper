package actions;

import Exceptions.InvalidActionException;
import actions.Action;
import src.Cell;

/**
 * Created by sfang on 8/19/15.
 */
public class Dig implements Action {
    public void act(Cell cell) throws InvalidActionException {
        cell.dig();
    }
}
