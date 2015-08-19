import Exceptions.InvalidInputException;

/**
 * Created by sfang on 8/19/15.
 */
public class Board {
    private int size;
    private Cells cells;
    private int numberOfMines;

    public Board(Cells cells, int numberOfMines) {
        this.cells = cells;
        this.size = cells.getSize();
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

    public Cell cellAt(int positionX, int positionY) {
        return cells.cellAt(positionX, positionY);
    }

    public int numberOfDigCell() {
        return cells.numberOfDigCell();
    }

    public boolean hasAllDigged(){
        return numberOfDigCell() == size * size - numberOfMines;
    }
}
