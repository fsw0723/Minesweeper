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
                cells[i][j] = new Cell(false, false);
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
}
