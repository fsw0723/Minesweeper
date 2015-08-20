import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;

import java.util.Scanner;

/**
 * Created by sfang on 8/19/15.
 */
public class Game {
    private int size, numberOfMines;
    private Board board;
    private boolean inProgress = false;

    public boolean start() {
        boolean result = false;
        try{
            readBoardSetting();
            setupBoard(size, numberOfMines);
            inProgress = true;
            while(inProgress){
                board.printBoard();
                String[] actions = selectField();
                performAction(actions);
                result = validateResult(actions);

            }
        }catch(InvalidInputException e){
            System.out.println("Please input valid values.");
        }
        catch (InvalidActionException e) {
            System.out.println("Please input valid values.");
        }
        return result;
    }

    public void printResult(boolean result) {
        String message = result ? "You win!" : "You lose";
        System.out.println(message);
    }

    private void readBoardSetting(){
        System.out.println("Board setup [size, number of mines]: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        try{
            size = Integer.parseInt(s.split(" ")[0]);
            numberOfMines = Integer.parseInt(s.split(" ")[1]);
            if(size <= 0 || numberOfMines <= 0 || numberOfMines > Math.pow(size, 2)){
                throw new InvalidInputException();
            }
        } catch(NumberFormatException e) {
            readBoardSetting();
        } catch(InvalidInputException e){
            readBoardSetting();
        }
    }

    private void setupBoard(int size, int numberOfMines) throws InvalidInputException {
        Cells cells = new Cells(new CellGenerator(size, numberOfMines).generatedCells());
        board = new Board(cells, numberOfMines);
    }

    private String[] selectField(){
        System.out.println("Please select field [ x, y, Action]");
        Scanner in = new Scanner(System.in);
        return in.nextLine().split(" ");
    }

    private void performAction(String[] actions) throws InvalidActionException {
        //TODO: validation
        try {
            int positionX = Integer.parseInt(actions[0]);
            int positionY = Integer.parseInt(actions[1]);
            String actionString = actions[2];
            if(positionX >= size || positionY >= size || positionX < 0 || positionY < 0 ||
                    !(actionString.equals(Constants.DIG) || actionString.equals(Constants.FLAG) || actionString.equals(Constants.CLEAR))){
                throw new InvalidActionException();
            }
            ActionFactory actionFactory = new ActionFactory();
            Action action = actionFactory.actionFor(actionString);
            action.act(board.cellAt(positionX, positionY));
            //TODO: HOW TO TEST THIS
        } catch (NumberFormatException e){
            selectField();
        } catch (InvalidActionException e) {
            selectField();
        }
    }

    private boolean validateResult(String[] actions) {
        if(!actions[2].equals(Constants.DIG)) {
            return true;
        }
        if(board.cellAt(Integer.parseInt(actions[0]), Integer.parseInt(actions[1])).hasMine()){
            inProgress = false;
            return false;
        }
        if(board.hasAllDigged()){
            inProgress = false;
            return true;
        }
        return true;
    }
}
