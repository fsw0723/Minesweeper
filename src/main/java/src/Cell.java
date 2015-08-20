package src;

import Exceptions.InvalidActionException;

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

    public void dig() throws InvalidActionException {
        if (isFlag || isDigged)
            throw new InvalidActionException();
        isDigged = true;
    }

    public void flag() {
        isFlag = true;
    }

    public void clear() {
        isFlag = false;
    }

    public boolean needDig() {
        if (hasMine || isDigged)
            return false;
        return true;
    }
}
