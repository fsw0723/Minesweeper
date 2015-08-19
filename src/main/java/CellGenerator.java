import java.util.ArrayList;
import java.util.Random;

/**
 * Created by sfang on 8/19/15.
 */
public class CellGenerator {
    private int size, numberOfMines;
    private int[][] cellsValue;

    public CellGenerator(int size, int numberOfMines) {
        this.size = size;
        this.numberOfMines = numberOfMines;
        cellsValue = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cellsValue[i][j] = 0;
            }
        }
    }

    public Cell[][] generatedCells(){
        Cell[][] cells = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells[i][j] = new Cell(false, 0);
            }
        }

        return setMines(cells);
    }

    private Cell[][] setMines(Cell[][] cells){
        ArrayList<Integer> usedNumber = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < numberOfMines; i++){
            int randomNum = rand.nextInt(size*size);
            while (usedNumber.contains(randomNum)){
                randomNum = rand.nextInt(size * size);
            }
            System.out.println("Mine position:"+randomNum);
            usedNumber.add(randomNum);
            int positionX = randomNum / size;
            int positionY = randomNum % size;
            Cell currentCell = cells[positionX][positionY];
            currentCell.setHasMine(true);
            cells = setSurroundingValue(cells, positionX, positionY);
        }
        return cells;
    }

    private Cell[][] setSurroundingValue(Cell[][] cells, int currentX, int currentY) {
        for(int i = currentX - 1; i <=currentX + 1; i++ ){
            for(int j = currentY - 1; j <= currentY + 1; j++){
                if(validForSurroundingValue(i, j, currentX, currentY)){
                    cells[i][j].setSurroundMines(cells[i][j].getSurroundMines() + 1);
                }
            }
        }
        return cells;
    }

    private boolean validForSurroundingValue(int i, int j, int positionX, int positionY){
        return i >= 0 && i < size && j >= 0 && j < size && !(i == positionX && j == positionY);
    }

}
