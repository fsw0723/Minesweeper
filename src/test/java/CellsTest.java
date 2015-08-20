import Exceptions.InvalidInputException;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.Cell;
import src.Cells;

import static org.mockito.Mockito.*;

public class CellsTest {
    int SIZE = 5;

    @Test
    public void testPrints() throws InvalidInputException {
        Cell cell = mock(Cell.class);
        Cell[][] cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                cells[i][j] = cell;
        Cells cellsObject = new Cells(cells);
        cellsObject.displayValue();
        verify(cell, times(25)).displayValue();
    }

    @Test
    public void testCellAt() {
        Cell cell = new Cell(false, 0);
        Cell[][] cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                cells[i][j] = new Cell(false, 0);
        cells[1][1] = cell;
        Cells cellsObject = new Cells(cells);
        Assert.assertSame(cellsObject.cellAt(1, 1), cell);

    }
}
