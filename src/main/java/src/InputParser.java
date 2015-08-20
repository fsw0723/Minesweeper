package src;

import Exceptions.InvalidInputException;

import java.util.HashMap;

public class InputParser {
    public HashMap<String, Integer> parseSetup(String s) throws InvalidInputException {

        final int size = Integer.parseInt(s.split(" ")[0]);
        final int numberOfMines = Integer.parseInt(s.split(" ")[1]);
        if(size <= 0 || numberOfMines <= 0 || numberOfMines > Math.pow(size, 2)){
            throw new InvalidInputException();
        }

        return new HashMap<String, Integer>(){
            {
                put("size", size);
                put("numberOfMines", numberOfMines);
            }
        };
    }

    public HashMap<String, String> parsePlay(String s) {
        final String[] actions = s.split(" ");
        return new HashMap<String, String>(){
            {
                put("positionX", actions[0]);
                put("positionY", actions[1]);
                put("action", actions[2]);
            }
        };
    }
}
