/**
 * Created by sfang on 8/19/15.
 */
public class Flag implements Action {
    public boolean act(Cell cell) {
        return cell.flag();
    }
}
