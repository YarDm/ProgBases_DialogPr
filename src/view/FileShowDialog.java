package view;

import javax.swing.*;
import java.awt.*;

/**
 * Класс реализующий отображение открытого файла на основе JDialog
 * Текст транслируется в JTextArea
 */
public class FileShowDialog extends JDialog {

    private JTextArea jTextArea;

    public FileShowDialog(){
        super.setPreferredSize(new Dimension(700, 400));
        setResizable(false);
        setLocation(100,100);
        jTextArea = new JTextArea();
        JScrollPane jsp = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setPreferredSize(new Dimension(690,390));
        add(jsp);
        pack();
        setVisible(true);
    }

    /**
     * Устанавливает текст в созданное поле
     * @param text текст из файла
     */
    public void setText(String text){
        jTextArea.setText(text);
    }
}
