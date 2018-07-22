package model;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListModel extends DefaultListModel {
    Object[] values;

    class LML implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {

        }
    }

    @Override
    public int getSize() {
        return values.length;
    }

    @Override
    public Object getElementAt(int i) {
        return "Subject " + i;
    }

    @Override
    public void setElementAt(Object obj, int i) {
        values[i] = obj;
        fireContentsChanged(this, i, i);
    }
}
