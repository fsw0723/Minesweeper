public class Cells {
    private Cell[][] cells;

    public Cells(Cell[][] cells){
        this.cells = cells;
    }

    public int getSize() {
        return cells[0].length;
    }

    public String[][] displayValue() {
        String[][] display = new String[getSize()][getSize()];
        for(int i = 0;i < getSize(); i++){
            for(int j = 0;j < getSize(); j++){
                display[i][j] = cells[i][j].displayValue();
            }
        }
        return display;
    }

    public Cell cellAt(int positionX, int positionY) {
        return cells[positionX][positionY];
    }

    private boolean needDig(Cell[] cell) {
        for(int j = 0; j < getSize(); j++){
            if (cell[j].needDig())
                return true;
        }
        return false;
    }

    public boolean hasAllDigged() {
        for(int row = 0; row < getSize(); row++){
            if (needDig(cells[row]))
                return false;
        }
        return true;
    }
}
