import Exceptions.InvalidInputException;

import java.util.Scanner;

/**
 * Created by sfang on 8/19/15.
 */
public class Game {
    private int size, numberOfMines;
    private Board board;
    private boolean started = false;

    public void start() throws InvalidInputException {
        readBoardSetting();
        setupBoard(size, numberOfMines);
        started = true;
        while(started){
            //print
            board.printBoard();
            selectField();
        }
    }

    private void readBoardSetting(){
        System.out.println("Board setup [size, number of mines]: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        size = Integer.parseInt(s.split(" ")[0]);
        numberOfMines = Integer.parseInt(s.split(" ")[1]);
    }

    public void setupBoard(int size, int numberOfMines) throws InvalidInputException {
        Cells cells = new Cells(generatedCells(size, numberOfMines));
        board = new Board(cells);
    }

    public Cell[][] generatedCells(int size, int numberOfMines){
        Cell[][] cells = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells[i][j] = new Cell(false, false);
            }
        }
        //TODO: set mines
        return cells;
    }

    public void selectField(){
        System.out.println("Please select field [ x, y, Action]");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] inputs = input.split(" ");
        int positionX = Integer.parseInt(inputs[0]);
        int positionY = Integer.parseInt(inputs[1]);
        String action = inputs[2];
    }


}
