import Exceptions.InvalidInputException;

/**
 * Created by sfang on 8/19/15.
 */
public class Board {
    private Cells cells;
    private int size;

    public Board(Cells cells) {
        this.cells = cells;
        this.size = cells.getSize();
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

    public boolean hasAllDigged(){
        return cells.hasAllDigged();
    }

    public boolean validatePosition(int positionX, int positionY) {
        return positionX >= size || positionY >= size || positionX < 0 || positionY < 0;
    }
}
