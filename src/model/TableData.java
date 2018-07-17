package model;

public class TableData {
    private int rows;
    private int cols;
    private int randMax;
    private int randMin;

    public TableData(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public void setRandMax(int randMax) {
        this.randMax = randMax;
    }

    public void setRandMin(int randMin) {
        this.randMin = randMin;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getRandMax() {
        return randMax;
    }

    public int getRandMin() {
        return randMin;
    }
}
