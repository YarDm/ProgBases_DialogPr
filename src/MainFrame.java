import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    JTextField colQuantity;
    JTextField rowQuantity;
    static TableData td;

    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setName("Main frame");
        setLocation(50, 50);
        setPreferredSize(new Dimension(400, 500));

        var catName = new JLabel("Задайте количество столбцов и нажмите ОК");
        catName.setPreferredSize(new Dimension(370,15));
        catName.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        colQuantity = new JTextField();
        colQuantity.setToolTipText("col");
        colQuantity.setPreferredSize(new Dimension(60, 35));
        rowQuantity = new JTextField();
        rowQuantity.setToolTipText("row");
        rowQuantity.setPreferredSize(new Dimension(60, 35));
        var okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(60, 35));
        var table = new JTable();
        table.setPreferredSize(new Dimension(380,400));

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cols = Integer.parseInt(colQuantity.getText());
                int rows = Integer.parseInt(rowQuantity.getText());
                new FillForm();
                okButton.setEnabled(false);

                td = new TableData(rows, cols);

                table.setModel(new NewTableModel(rows, cols) {
                    @Override
                    public int getRowCount() {
                        return rows;
                    }

                    @Override
                    public int getColumnCount() {
                        return cols;
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        return null;
                    }
                });

            }
        });


        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        container.add(catName);
        container.add(colQuantity);
        container.add(rowQuantity);
        container.add(okButton);
        container.add(table);

        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new MainFrame();
    }

}
