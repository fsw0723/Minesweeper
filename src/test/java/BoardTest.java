import Exceptions.InvalidActionException;
import Exceptions.InvalidInputException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;

public class BoardTest {
    int SIZE = 5;
    @Test
    public void testPrintBoard() throws InvalidInputException {
        Cells cells = mock(Cells.class);
        Board board = new Board(cells, 2);
        board.printBoard();
        verify(cells, times(1)).displayValue();
    }

    @Test
    public void testCellAt() throws InvalidInputException {
        Cells cells = mock(Cells.class);
        Board board = new Board(cells, 2);
        board.cellAt(1, 1);
        verify(cells, times(1)).cellAt(1, 1);
    }

    @Test
    public void testDigCount() throws InvalidActionException {
        Cell cell = new Cell(false, 0);
        Cell[][] cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                cells[i][j] = new Cell(false, 0);
        cells[0][0] = cell;
        Cells cellsObject = new Cells(cells);
        Board board = new Board(cellsObject, 2);

        cell.dig();
        Assert.assertEquals(board.numberOfDigCell(), 1);

    }
}
