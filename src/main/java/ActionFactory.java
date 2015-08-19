import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sfang on 8/19/15.
 */
public class ActionFactory {
    private HashMap<String, Action> actions;

    public ActionFactory(){
        actions = new HashMap<String, Action>();
        actions.put("D", new Dig());
        actions.put("F", new Flag());
        actions.put("C", new Clear());
    }

    public Action actionFor(String action){
        return actions.get(action);
    }
}
