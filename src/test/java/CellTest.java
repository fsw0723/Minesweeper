import Exceptions.InvalidActionException;
import org.testng.Assert;
import org.testng.annotations.Test;
import src.Cell;

public class CellTest {
    int SIZE = 5;
    @Test
    public void testPrintHiddenCell() {
        Cell cell = new Cell(false, 2);
        Assert.assertEquals(cell.displayValue(), "#");
    }

    @Test
    public void testPrintFlagCell() {
        Cell cell = new Cell(false, 2);
        cell.flag();
        Assert.assertEquals(cell.displayValue(), "F");
    }

    @Test
    public void testPrintCellWithMineSurround() throws InvalidActionException {
        Cell cell = new Cell(false, 2);
        cell.dig();
        Assert.assertEquals(cell.displayValue(), "2");
    }

    @Test
    public void testPrintCellWithoutMineSurround() throws InvalidActionException {
        Cell cell = new Cell(false, 0);
        cell.dig();
        Assert.assertEquals(cell.displayValue(), ".");
    }

    @Test(expectedExceptions = InvalidActionException.class)
    public void testCannotDigWhenHasFlag() throws InvalidActionException {
        Cell cell = new Cell(false, 0);
        cell.flag();
        cell.dig();
    }

    @Test(expectedExceptions = InvalidActionException.class)
    public void testCannotDigWhenAlreadyDig() throws InvalidActionException {
        Cell cell = new Cell(false, 0);
        cell.dig();
        cell.dig();
    }

    @Test
    public void testNeedDigOnHiddenCell() throws InvalidActionException {
        Cell cell = new Cell(false, 0);
        Assert.assertTrue(cell.needDig());
    }

    @Test
    public void testNeedDigOnMineCell() throws InvalidActionException {
        Cell cell = new Cell(true, 0);
        Assert.assertFalse(cell.needDig());
    }

    @Test
    public void testNeedDigOnDiggedCell() throws InvalidActionException {
        Cell cell = new Cell(false, 0);
        cell.dig();
        Assert.assertFalse(cell.needDig());
    }
}
