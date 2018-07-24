package model;

import javax.swing.*;
import java.awt.*;

/**
 * Класс создает формат для элементов JList, а так же устанавливает их высоту на 5 больше предыдущего
 */
public class MyListCellRenderer extends JLabel implements ListCellRenderer {
    private JLabel label;

    /**
     * Ревлизация метода интерфейса для получения компонента JList
     * @param list список который использует Renderer
     * @param value значение строки
     * @param index индекс строки
     * @param isSelected проверка выбранности элемента списка
     * @param cellHasFocus проверка фокуса на элементе списка
     * @return
     */
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
