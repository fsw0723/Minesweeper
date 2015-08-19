/**
 * Created by sfang on 8/19/15.
 */
public class Cell {
    private boolean isDigged;
    private boolean hasMine;

    public Cell(boolean isDigged, boolean hasMine) {
        this.isDigged = isDigged;
        this.hasMine = hasMine;
    }

    public void setIsDigged(boolean isDigged) {
        this.isDigged = isDigged;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public String displayValue() {
        return "#";
    }
}
