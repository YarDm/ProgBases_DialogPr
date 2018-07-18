package view;

import javax.swing.*;
import java.awt.*;

public class FileShowDialog extends JDialog {

    JFrame frame;
    JTextArea jTextArea;



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

    public void setText(String text){
        jTextArea.setText(text);
    }
}
