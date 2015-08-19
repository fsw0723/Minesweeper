import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by sfang on 8/19/15.
 */
public class Game {
    private int size, numberOfMines;
    private Board board;
    private boolean inProgress = false;

    public void start() {
        readBoardSetting();
        try {
            setupBoard(size, numberOfMines);
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
        inProgress = true;
        while(inProgress){
            board.printBoard();
            try {
                inProgress = selectField();
                if (inProgress) {
                    if (winGame()) {
                        System.out.println("You Win");
                        inProgress = false;
                    }
                } else {
                    //LOSE
                    System.out.println("You Lose");
                }
            } catch (InvalidActionException e) {
                e.printStackTrace();
            }
        }
        //END GAME

    }

    private boolean winGame() {
        return board.HasAllDigged();
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
        board = new Board(cells);
    }

    private boolean selectField() throws InvalidActionException {
        System.out.println("Please select field [ x, y, Action]");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputs = input.split(" ");
        int positionX = Integer.parseInt(inputs[0]);
        int positionY = Integer.parseInt(inputs[1]);
        String actionString = inputs[2];
        //TODO: validation
        ActionFactory actionFactory = new ActionFactory();
        Action action = actionFactory.actionFor(actionString);
        return action.act(board.cellAt(positionX, positionY));
        //TODO: HOW TO TEST THIS
    }


}
