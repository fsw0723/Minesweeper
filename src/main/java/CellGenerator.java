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

        int[][] boardMap = populateBoardMap();

        Cell[][] cells = new Cell[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                cells[i][j] = new Cell(boardMap[i][j]==1, surroundMines(i, j));
            }
        }
        return cells;
    }

    private int surroundMines(int positionX, int positionY) {
        int numberOfMineSurround = 0;
        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++)
                if ((positionX + i >=0 && positionX + i <size) &&
                        (positionY + j >=0) && (positionY + j < size)
                        && (i !=0 && j!=0) && cellsValue[i + positionX][j + positionY] == 1){
                    numberOfMineSurround++;
                }
        return numberOfMineSurround;
    }

    private int[][] populateBoardMap(){
        ArrayList<Integer> usedNumber = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < numberOfMines; i++){
            int randomNum = rand.nextInt(size*size);
            while (usedNumber.contains(randomNum)){
                randomNum = rand.nextInt(size * size);
            }
            usedNumber.add(randomNum);
            int positionX = randomNum / size;
            int positionY = randomNum % size;
            cellsValue[positionX][positionY] = 1;
        }
        return cellsValue;
    }

}
