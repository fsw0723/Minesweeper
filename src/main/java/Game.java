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

    public void start() {
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
            if(result){
                System.out.println("Your win!");
            } else{
                System.out.println("You lose!");
            }
        }catch(InvalidInputException e){
            System.out.println("Please input valid values.");
        }
        catch (InvalidActionException e) {
            e.printStackTrace();
        }

        //END GAME

    }


    private boolean winGame() {
        return board.hasAllDigged();
    }

    private void readBoardSetting(){
        System.out.println("Board setup [size, number of mines]: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        size = Integer.parseInt(s.split(" ")[0]);
        numberOfMines = Integer.parseInt(s.split(" ")[1]);
        //TODO: validation
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

    private boolean performAction(String[] actions) throws InvalidActionException {
        //TODO: validation

        int positionX = Integer.parseInt(actions[0]);
        int positionY = Integer.parseInt(actions[1]);
        String actionString = actions[2];
        ActionFactory actionFactory = new ActionFactory();
        Action action = actionFactory.actionFor(actionString);
        return action.act(board.cellAt(positionX, positionY));
        //TODO: HOW TO TEST THIS
    }

    private boolean validateResult(String[] actions) {
        if(!actions[2].equals("D")) {
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
