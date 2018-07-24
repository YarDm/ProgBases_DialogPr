package model;

import javax.swing.*;
import java.awt.*;

public class MyListCellRenderer extends JLabel implements javax.swing.ListCellRenderer {
    Object[] values;
    JLabel label;
    int fontHigh = 10;




    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {

        label = new JLabel();
        label.setText(value.toString());
        while (index<list.getModel().getSize()){

            fontHigh += 10;
            label.setFont(new Font("TimesNewRoman", Font.ITALIC, fontHigh));

            }

        return label;
    }

    public void setFontHigh(int high) {
        this.fontHigh = high;
    }

    public int getFontHigh(){
        return this.fontHigh;
    }
}
