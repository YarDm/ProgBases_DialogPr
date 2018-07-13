import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;


public class NewTableModel extends AbstractTableModel {

    private Object[][] data;
    private int row;
    private int col;

    class TML implements TableModelListener{
        public void tableChanged(TableModelEvent event){
        }

    }

    NewTableModel(TableData td) {
        this.row = td.getRows();
        this.col = td.getCols();
        data = new Object[row][col];
        addTableModelListener(new TML());
    }

    @Override
    public int getRowCount() {
        return row;
    }

    @Override
    public int getColumnCount() { return col; }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return data[rowIndex][columnIndex];
    }


    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}