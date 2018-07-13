import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    TableData tableData;

    JTextField colQuantity;
    JTextField rowQuantity;
    JLabel catName;
    JButton okButton;
    NewTableModel tableModel;
    JTable table;

    JLabel fillId;
    JLabel randFill;
    JTextField fromField;
    JLabel t;
    JTextField toField;
    JButton fillButton;

    JLabel valToCell;
    JLabel value;
    JTextField valueFld;
    JTextField vCol;
    JTextField vRow;
    JButton vFillButton;


    public MainFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setName("Main frame");
        setLocation(50, 50);
        setPreferredSize(new Dimension(800, 600));
        setResizable(false);

        catName = new JLabel("Задайте количество столбцов и нажмите ОК");
        catName.setPreferredSize(new Dimension(350,30));
        catName.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        colQuantity = new JTextField();
        colQuantity.setToolTipText("col");
        colQuantity.setPreferredSize(new Dimension(60, 35));
        rowQuantity = new JTextField();
        rowQuantity.setToolTipText("row");
        rowQuantity.setPreferredSize(new Dimension(60, 35));
        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(60, 35));

        table = new JTable(tableModel);
        table.setRowHeight(20);
        JScrollPane scrollPane = new JScrollPane(table);

        table.setPreferredSize(new Dimension(380,500));

        fillId = new JLabel("Настройки заполнения созданной таблицы");
        fillId.setPreferredSize(new Dimension(370, 25));
        fillId.setHorizontalAlignment(SwingConstants.CENTER);
        fillId.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        randFill = new JLabel("Заоплнение рандомными значениями из диапазона:");
        randFill.setPreferredSize(new Dimension(370, 15));
        randFill.setHorizontalAlignment(SwingConstants.CENTER);
        fromField = new JTextField();
        fromField.setPreferredSize(new Dimension(60,35));
        t = new JLabel("-");
        t.setHorizontalAlignment(SwingConstants.CENTER);
        t.setPreferredSize(new Dimension(60,35));
        toField = new JTextField();
        toField.setPreferredSize(new Dimension(60,35));
        fillButton = new JButton("Fill");
        fillButton.setPreferredSize(new Dimension(60,35));

        valToCell = new JLabel("Ввести значение в заданную ячейку:");
        valToCell.setPreferredSize(new Dimension(370, 25));
        valToCell.setHorizontalAlignment(SwingConstants.CENTER);
        value = new JLabel("Value:");
        valueFld = new JTextField();
        valueFld.setToolTipText("value");
        valueFld.setPreferredSize(new Dimension(60,35));
        vRow = new JTextField();
        vRow.setToolTipText("to row");
        vRow.setPreferredSize(new Dimension(60,35));
        vCol = new JTextField();
        vCol.setToolTipText("to col");
        vCol.setPreferredSize(new Dimension(60,35));
        vFillButton = new JButton("Set");
        vFillButton.setPreferredSize(new Dimension(60,35));


        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cols = Integer.parseInt(colQuantity.getText());
                int rows = Integer.parseInt(rowQuantity.getText());

                okButton.setEnabled(false);

                tableData = new TableData(cols, rows);


                tableModel = new NewTableModel(tableData);
                table.setModel(tableModel);

//                table.setValueAt(5, 3,5);
//                System.out.print(table.getValueAt(3,5));



            }
        });

        fillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fromDigit = Integer.parseInt(fromField.getText());
                int toDigit = Integer.parseInt(toField.getText());

                int rows = tableData.getRows();
                int cols = tableData.getCols();

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        int digit = fromDigit + (int) (Math.random() * ((toDigit - fromDigit) + 1));
                        table.setValueAt(digit, i, j);
                    }
                }
            }
        });

        vFillButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int val = Integer.parseInt(valueFld.getText());
                int row = Integer.parseInt(vRow.getText());
                int col = Integer.parseInt(vCol.getText());

                table.setValueAt(val, row, col);
                table.updateUI();
                System.out.println(table.getValueAt(row, col));
            }
        });


        JPanel northPanel = new JPanel(new BorderLayout());
        JPanel westSide = new JPanel(new FlowLayout(FlowLayout.CENTER));
        westSide.setPreferredSize(new Dimension(400, 350));
        westSide.setMaximumSize(new Dimension(400, 350));
        westSide.add(catName);
        westSide.add(colQuantity);
        westSide.add(rowQuantity);
        westSide.add(okButton);
        westSide.add(table);

        JPanel eastSide = new JPanel(new FlowLayout(FlowLayout.CENTER));
        eastSide.setPreferredSize(new Dimension(400, 350));
        eastSide.setMaximumSize(new Dimension(400, 350));
        eastSide.add(fillId);
        eastSide.add(randFill);
        eastSide.add(fromField);
        eastSide.add(t);
        eastSide.add(toField);
        eastSide.add(fillButton);

        eastSide.add(valToCell);
        eastSide.add(value);
        eastSide.add(valueFld);
        eastSide.add(vRow);
        eastSide.add(vCol);
        eastSide.add(vFillButton);

        northPanel.add(westSide, "West");
        northPanel.add(eastSide, "East");

        Container container = getContentPane();
        container.add(northPanel, "North");

        pack();
        setVisible(true);
    }

    public static void main(String[] args){
        new MainFrame();
    }

}
