import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by sfang on 8/19/15.
 */
public class CellGeneratorTest {
    @Test
    public void testGeneratedCellsReturnsCorrectNumberOfCells(){
        CellGenerator cellGenerator = new CellGenerator(3, 3);
        Cell[][] cells = cellGenerator.generatedCells();
        int numberOfCells = 0;
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                numberOfCells++;
            }
        }
        Assert.assertEquals(numberOfCells, 9);
    }

    @Test
    public void testGeneratedCellsReturnsCorrectNumberOfMines(){
        CellGenerator cellGenerator = new CellGenerator(3, 3);
        Cell[][] cells = cellGenerator.generatedCells();
        int numberOfMines = 0;
        for(int i = 0; i < cells.length; i++){
            for(int j = 0; j < cells[i].length; j++){
                if(cells[i][j].hasMine()) numberOfMines++;
            }
        }
        Assert.assertEquals(numberOfMines, 3);
    }
}
