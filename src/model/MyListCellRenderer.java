package model;

import javax.swing.*;
import java.awt.*;

public class MyListCellRenderer extends JLabel implements javax.swing.ListCellRenderer {
    JLabel label;

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        int fontHigh = 5 + 5*index;
        label = new JLabel();
        label.setText(value.toString());
        label.setFont(new Font("TimesNewRoman", Font.ITALIC, fontHigh));

        return label;
    }

}
