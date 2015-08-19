import Exceptions.InvalidInputException;

/**
 * Created by sfang on 8/19/15.
 */
public class Cells {
    private Cell[][] cells;
    private int size;


    public Cells(Cell[][] cells){
        this.cells = cells;
        this.size = cells[0].length;

    }

    public void generateCells(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells[i][j] = new Cell(false, 0);
            }
        }
        //set mines
    }

    public int getSize() {
        return size;
    }

    public String[][] displayValue() {
        String[][] display = new String[size][size];
        for(int i = 0;i < size; i++){
            for(int j = 0;j < size; j++){
                display[i][j] = cells[i][j].displayValue();
            }
        }
        return display;
    }

    public Cell cellAt(int positionX, int positionY) {
        return cells[positionX][positionY];
    }

    public int numberOfDigCell() {
        int count = 0;
        for(int row = 0; row < size; row++){
            count = getCount(count, cells[row]);
        }
        return count;
    }

    private int getCount(int count, Cell[] cell) {
        for(int j = 0; j < size; j++){
            if (cell[j].isDigged())
                count ++;
        }
        return count;
    }
}
