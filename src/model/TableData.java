package model;
/**
 * Данные таблицы которые нам необходимо передавать

 */
public class TableData {
    private int rows;
    private int cols;

    /**
     * Данные собираем при создании объекта.
     * @param rows - колчество строк
     * @param cols - количество столбцов
     */
    public TableData(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

}
