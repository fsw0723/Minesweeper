package src;

import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;
import actions.Action;
import actions.ActionFactory;

import java.util.HashMap;

public class Game {
    private Board board;
    private boolean inProgress = false;
    private GameReader gameReader = new GameReader();

    public boolean start() {
        boolean result = false;
        setupBoard();
        inProgress = true;
        while(inProgress){
            result = play();
        }
        return result;
    }

    private boolean play() {
        board.printBoard();
        String s = gameReader.selectField();
        HashMap<String, String> actions = new InputParser().parsePlay(s);
        return performAction(Integer.parseInt(actions.get("positionX")), Integer.parseInt(actions.get("positionY")), actions.get("action"));
    }

    public void printResult(boolean result) {
        String message = result ? "You win!" : "You lose";
        System.out.println(message);
    }

    private void setupBoard(){
        String s = gameReader.readBoardSetting();
        try{
            HashMap<String, Integer> settings = new InputParser().parseSetup(s);
            Cells cells = new Cells(new CellGenerator(settings.get("size"), settings.get("numberOfMines")).generatedCells());
            board = new Board(cells);
        } catch(NumberFormatException e) {
            setupBoard();
        } catch(InvalidInputException e){
            setupBoard();
        }
    }

    private boolean performAction(int positionX, int positionY, String actionString){
        try {
            ActionFactory actionFactory = new ActionFactory();
            if(board.validatePosition(positionX, positionY) || !actionFactory.validateAction(actionString)){
                throw new InvalidActionException();
            }
            Action action = actionFactory.actionFor(actionString);
            action.act(board.cellAt(positionX, positionY));
            //TODO: HOW TO TEST THIS
        } catch (NumberFormatException e){
            gameReader.selectField();
        } catch (InvalidActionException e) {
            gameReader.selectField();
        }
        return validateResult(positionX, positionY, actionString);
    }

    private boolean validateResult(int positionX, int positionY, String actionString){
        if(!actionString.equals(Constants.DIG)) {
            return true;
        }
        if(board.cellAt(positionX, positionY).hasMine()){
            inProgress = false;
            return false;
        }
        if(board.hasAllDigged()){
            inProgress = false;
        }
        return true;
    }
}
