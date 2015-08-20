import Exceptions.InvalidActionException;

/**
 * Created by sfang on 8/19/15.
 */
public class Cell {
    private boolean isDigged;
    private boolean hasMine;
    private boolean isFlag;

    public void setSurroundMines(int surroundMines) {
        this.surroundMines = surroundMines;
    }

    public int getSurroundMines() {
        return surroundMines;
    }

    private int surroundMines;


    public Cell(boolean hasMine, int surroundMines) {
        this.isDigged = false;
        this.hasMine = hasMine;
        this.surroundMines = surroundMines;
    }

    public boolean hasMine(){
        return hasMine;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public String displayValue() {
        if (isFlag){
            return "F";
        }
        if (!isDigged){
            return "#";
        }
        if (surroundMines > 0)
            return String.valueOf(surroundMines);
        return ".";
    }

    public boolean dig() throws InvalidActionException {
        if (isFlag || isDigged)
            throw new InvalidActionException();
        isDigged = true;
        return hasMine;
    }

    public boolean flag() {
        isFlag = true;
        return false;
    }

    public boolean clear() {
        isFlag = false;
        return true;
    }

    public boolean isDigged() {
        return isDigged;
    }
}
