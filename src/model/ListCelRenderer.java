package model;

import javax.swing.*;
import java.awt.*;

public class ListCelRenderer extends JLabel implements ListCellRenderer {
    Object[] values;

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        setText(value.toString());

        return this;
    }

    @Override
    public void setFont(Font font) {
        super.setFont(font);
    }
}
