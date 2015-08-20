/**
 * Created by sfang on 8/19/15.
 */
public class Flag implements Action {
    public void act(Cell cell) {
        cell.flag();
    }
}
