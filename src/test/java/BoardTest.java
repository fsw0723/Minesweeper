import Exceptions.InvalidInputException;
import org.testng.annotations.Test;
import src.Board;
import src.Cells;

import static org.mockito.Mockito.*;

public class BoardTest {
    int SIZE = 5;
    @Test
    public void testPrintBoard() throws InvalidInputException {
        Cells cells = mock(Cells.class);
        Board board = new Board(cells);
        board.printBoard();
        verify(cells, times(1)).displayValue();
    }

    @Test
    public void testCellAt() throws InvalidInputException {
        Cells cells = mock(Cells.class);
        Board board = new Board(cells);
        board.cellAt(1, 1);
        verify(cells, times(1)).cellAt(1, 1);
    }
}
