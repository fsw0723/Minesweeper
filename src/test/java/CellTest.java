import Exceptions.InvalidInputException;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.mockito.Mockito.*;

public class CellTest {
    int SIZE = 5;
    @Test
    public void testPrintHiddenCell() {
        Cell cell = new Cell(false, false);
        Assert.assertEquals("#", cell.displayValue());

    }
}
