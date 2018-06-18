import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    //TODO: create this class like http://java-online.ru/swing-layout.xhtml#grouplayout
    public MainFrame(){
        JFrame mainFrame = new JFrame();
        GroupLayout groupLayout = new GroupLayout(getContentPane());

        JLabel start = new JLabel("Введите количество столбцов и строк и нажмите 'ОК'");
        JTextField colField = new JTextField();
        colField.setText("columns");
        JTextField rowField = new JTextField();
        rowField.setText("rows");
        JTable table = new JTable();
        mainFrame.setTitle("Экзаменационное задание по Основам программирования");
        mainFrame.setLocation(300,10);
        mainFrame.setSize(new Dimension(600, 800));
        mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

        mainFrame.setLayout(groupLayout);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                .addComponent(start));

    }




    public static void main(String[] args){
        new MainFrame();
    }

}
