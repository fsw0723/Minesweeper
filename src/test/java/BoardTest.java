import Exceptions.InvalidInputException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;

public class BoardTest {
//    @Test
//    public void testDigNoMineCell() throws InvalidInputException {
//        Board board = new Board(3, 3);
//        board.cells = [][]
//        board.dig(1, 2);
//    }

    @Test
    public void testPrintBoard() throws InvalidInputException {
        Cells cells = mock(Cells.class);
        Board board = new Board(cells);
        board.printBoard();
        verify(cells, times(1)).displayValue();
    }
}
