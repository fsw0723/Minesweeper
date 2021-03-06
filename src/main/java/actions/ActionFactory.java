package actions;

import src.Constants;

import java.util.HashMap;

/**
 * Created by sfang on 8/19/15.
 */
public class ActionFactory {
    private HashMap<String, Action> actions;

    public ActionFactory(){
        actions = new HashMap<String, Action>();
        actions.put(Constants.DIG, new Dig());
        actions.put(Constants.FLAG, new Flag());
        actions.put(Constants.CLEAR, new Clear());
    }

    public Action actionFor(String action){
        return actions.get(action);
    }

    public boolean validateAction(String actionString) {
        return actionString.equals(Constants.DIG) || actionString.equals(Constants.FLAG) || actionString.equals(Constants.CLEAR);
    }
}
