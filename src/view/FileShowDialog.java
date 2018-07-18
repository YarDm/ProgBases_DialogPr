package view;

import javax.swing.*;
import java.awt.*;

public class FileShowDialog extends JDialog {

    JFrame frame;
    JTextArea jTextArea;



    public FileShowDialog(){
        super.setPreferredSize(new Dimension(300, 400));
        setResizable(false);
        jTextArea = new JTextArea();
        JScrollPane jsp = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setPreferredSize(new Dimension(290,390));
        add(jsp);
        pack();
        setVisible(true);
    }

    public void setText(String text){
        jTextArea.setText(text);
    }
}
