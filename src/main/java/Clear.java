/**
 * Created by sfang on 8/19/15.
 */
public class Clear implements Action{

    public boolean act(Cell cell) {
        return cell.clear();
    }
}
