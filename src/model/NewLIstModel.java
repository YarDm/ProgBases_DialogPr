package model;

import javax.swing.*;
import java.awt.*;

public class NewLIstModel extends AbstractListModel {
    Object[] data;
    int index;
    Font font;

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public Object getElementAt(int index) {
        return data[index];
    }

    public void setData(Object[] data) {
        this.data = data;
    }

    public void setFontToItem(int index, Font font){
        data[index].setFont();
    }


}
