import javax.swing.table.AbstractTableModel;


public abstract class NewTableModel extends AbstractTableModel {

    NewTableModel(int row, int col) {
        getRowCount(row);
        getColumnCount(col);
    }

    public int getRowCount(int row) {
        return row;
    }

    public int getColumnCount(int col) {
        return col;
    }

}