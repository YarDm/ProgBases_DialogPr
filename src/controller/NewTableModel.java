package controller;

import model.TableData;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 * Клвсс модели данных таблицы
 */
public class NewTableModel extends AbstractTableModel {

    private Object[][] data;
    private int row;
    private int col;

    /**
     * Вложенный класс реализующий слушатель изменения таблицы
     */
    class TML implements TableModelListener{
        public void tableChanged(TableModelEvent event){
        }

    }

    /**
     * Конструктор создающий таблицу
     * @param td характеристики тыблицы
     */
    public NewTableModel(TableData td) {
        this.row = td.getRows();
        this.col = td.getCols();
        data = new Object[row][col];
        addTableModelListener(new TML());
    }

    /**
     * Реализация метода родительского класса
     * @return возвращает количество строк таблицы
     */
    @Override
    public int getRowCount() {
        return row;
    }

    /**
     * Реализация метода родительского класса
     * @return возвращается количество столбцов таблицы
     */
    @Override
    public int getColumnCount() { return col; }

    /**
     * Реализация метода родительского класса
     * @param rowIndex индекс строки
     * @param columnIndex индекс столбца
     * @return любая ячейка редактируема
     */
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    /**
     * Реализация метода родительского класса
     * @param rowIndex идекс строки
     * @param columnIndex индекс столбца
     * @return возвращает значение указанной ячейки
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return data[rowIndex][columnIndex];
    }

    /**
     * Реализация метода родительского класса
     * @param aValue значение
     * @param rowIndex индекс строки
     * @param columnIndex индекс столбца
     */
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue;
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}