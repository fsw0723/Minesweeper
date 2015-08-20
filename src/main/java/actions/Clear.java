package actions;

import actions.Action;
import src.Cell;

/**
 * Created by sfang on 8/19/15.
 */
public class Clear implements Action {

    public void act(Cell cell) {
        cell.clear();
    }
}
