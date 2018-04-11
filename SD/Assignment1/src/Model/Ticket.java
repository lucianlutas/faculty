package Model;

public class Ticket {
    private int id;
    private int showID;
    private int row;
    private int col;
    private int sold;

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getShowID() {
        return showID;
    }

    public int getCol() {
        return col;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setShowID(int showID) {
        this.showID = showID;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
