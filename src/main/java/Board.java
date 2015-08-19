import Exceptions.InvalidInputException;

/**
 * Created by sfang on 8/19/15.
 */
public class Board {
    private int size;
    private Cells cells;

    public void setCells(Cells cells) {
        this.cells = cells;
    }

    public Board(Cells cells) {
        this.cells = cells;
        this.size = cells.getSize();
    }

    private int numberOfMines;

    public int getSize() {
        return size;
    }

    public int getNumberOfMines() {
        return numberOfMines;
    }

    public void setNumberOfMines(int numberOfMines) {
        this.numberOfMines = numberOfMines;
    }

    public void printBoard(){
        String[][] displayValue = cells.displayValue();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(displayValue[i][j]);
            }
            System.out.println();
        }
    }

    public void init() {
        Cell[][] cells = new Cell[size][size];

    }

    public Cell cellAt(int positionX, int positionY) {
        return cells.cellAt(positionX, positionY);
    }

    public int numberOfDigCell() {
        return cells.numberOfDigCell();
    }

    public boolean HasAllDigged(){
        return numberOfDigCell() == size * size - numberOfMines;
    }
}
