import controller.NewTableModel;
import model.FontsForCB;
import model.MyListCellRenderer;
import model.TableData;
import view.FileShowDialog;
import view.FontChoiseDialog;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MainFrame extends JFrame {

    private TableData tableData;

    private JTextField rowQuantity;
    private JTextField colQuantity;
    private JButton okButton;
    private NewTableModel tableModel;
    private JTable table;

    private JTextField fromField;
    private JTextField toField;

    private JTextField valueFld;
    private JTextField vCol;
    private JTextField vRow;

    private FontsForCB ffcb = new FontsForCB();

    private JFileChooser fileChooser;
    private FileShowDialog showDialog;

    private JList<String> list;
    private MyListCellRenderer lcr = new MyListCellRenderer();

    private JComboBox<Integer> listItemNums;


    private MainFrame() throws IOException, FontFormatException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setName("Main frame");
        setLocation(50, 50);
        setPreferredSize(new Dimension(800, 600));
        setResizable(false);

        JLabel catName = new JLabel("Задайте количество столбцов и нажмите ОК");
        catName.setPreferredSize(new Dimension(350,30));
        catName.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        rowQuantity = new JTextField();
        rowQuantity.setToolTipText("row");
        rowQuantity.setPreferredSize(new Dimension(60, 35));
        colQuantity = new JTextField();
        colQuantity.setToolTipText("col");
        colQuantity.setPreferredSize(new Dimension(60, 35));
        okButton = new JButton("OK");
        okButton.setPreferredSize(new Dimension(60, 35));

        table = new JTable(tableModel);
        table.setRowHeight(35);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setPreferredSize(new Dimension(380,270));


        JLabel fillId = new JLabel("Настройки заполнения созданной таблицы");
        fillId.setPreferredSize(new Dimension(370, 25));
        fillId.setHorizontalAlignment(SwingConstants.CENTER);
        fillId.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
        JLabel randFill = new JLabel("Заоплнение рандомными значениями из диапазона:");
        randFill.setPreferredSize(new Dimension(370, 15));
        randFill.setHorizontalAlignment(SwingConstants.CENTER);
        fromField = new JTextField();
        fromField.setPreferredSize(new Dimension(60,35));
        JLabel t = new JLabel("-");
        t.setHorizontalAlignment(SwingConstants.CENTER);
        t.setPreferredSize(new Dimension(60,35));
        toField = new JTextField();
        toField.setPreferredSize(new Dimension(60,35));
        JButton fillButton = new JButton("Fill");
        fillButton.setPreferredSize(new Dimension(60,35));

        JLabel valToCell = new JLabel("Ввести значение в заданную ячейку:");
        valToCell.setPreferredSize(new Dimension(370, 25));
        valToCell.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel value = new JLabel("Value:");
        valueFld = new JTextField();
        valueFld.setToolTipText("value");
        valueFld.setPreferredSize(new Dimension(60,35));
        vRow = new JTextField();
        vRow.setToolTipText("to row");
        vRow.setPreferredSize(new Dimension(60,35));
        vCol = new JTextField();
        vCol.setToolTipText("to col");
        vCol.setPreferredSize(new Dimension(60,35));
        JButton vFillButton = new JButton("Set");
        vFillButton.setPreferredSize(new Dimension(60,35));

        JLabel chooseFont = new JLabel("Выбор шрифта:");
        chooseFont.setPreferredSize(new Dimension(370,25));
        chooseFont.setHorizontalAlignment(SwingConstants.CENTER);
        JButton sDialogBtn = new JButton("Выбрать шрифт");
        sDialogBtn.setPreferredSize(new Dimension(130,35));
        JComboBox <String> fontChooser = new JComboBox<>(ffcb.getFontsList());
        fontChooser.setPreferredSize(new Dimension(180,35));

        JLabel chooseFile = new JLabel("Выберете файл для просмотра:");
        chooseFile.setPreferredSize(new Dimension(370,25));
        chooseFile.setHorizontalAlignment(SwingConstants.CENTER);
        JButton openFile = new JButton("Выбрать файл");
        openFile.setPreferredSize(new Dimension(180,35));

        JLabel listManipulations = new JLabel("Работа со списком:");
        listManipulations.setPreferredSize(new Dimension(270,25));
        listManipulations.setHorizontalAlignment(SwingConstants.CENTER);
        listManipulations.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));

        var listModel = new DefaultListModel<String>();
        listModel.addElement("one");
        listModel.addElement("two");
        listModel.addElement("three");
        listModel.addElement("four");
        listModel.addElement("five");
        listModel.addElement("six");
        listModel.addElement("seven");

        list = new JList<>(listModel);

        JScrollPane listScrollPane = new JScrollPane(list);
        listScrollPane.setPreferredSize(new Dimension(285, 180));

        JLabel setColor = new JLabel("Выберете элемент и его цвет:");
        setColor.setPreferredSize(new Dimension(230,25));
        setColor.setHorizontalAlignment(SwingConstants.CENTER);

        Integer[] items = new Integer[listModel.getSize()];
        for (int i = 0; i < listModel.getSize(); i++){
            items[i] = i;
        }
        listItemNums = new JComboBox<>(items);
        listItemNums.setPreferredSize(new Dimension(230,35));
        JButton choiseButton = new JButton("Выбрать цвет");
        choiseButton.setPreferredSize(new Dimension(230,130));

        JLabel setMoreFive = new JLabel("Увеличить пункты на пять:");
        setMoreFive.setPreferredSize(new Dimension(230,35));
        setMoreFive.setHorizontalAlignment(SwingConstants.CENTER);
        JButton doThat = new JButton("Сделать это!");
        doThat.setPreferredSize(new Dimension(230,160));


        okButton.addActionListener(e -> {
            int cols = Integer.parseInt(rowQuantity.getText());
            int rows = Integer.parseInt(colQuantity.getText());

            okButton.setEnabled(false);

            tableData = new TableData(cols, rows);


            tableModel = new NewTableModel(tableData);
            table.setModel(tableModel);

        });

        fillButton.addActionListener(e -> {
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
        });

        vFillButton.addActionListener(e -> {
            int val = Integer.parseInt(valueFld.getText());
            int row = Integer.parseInt(vRow.getText());
            int col = Integer.parseInt(vCol.getText());

            table.setValueAt(val, row, col);
            table.updateUI();

        });

        sDialogBtn.addActionListener(e -> {
            FontChoiseDialog fcd = new FontChoiseDialog(null);
            fcd.showDialog();
            table.setFont(fcd.getFont());
        });

        fontChooser.addActionListener(e -> {
            String [] fonts = ffcb.getFontsList();
            table.setFont(new Font(fonts[fontChooser.getSelectedIndex()], Font.BOLD, 20));
        });

        openFile.addActionListener(e -> {
            fileChooser = new JFileChooser();
            int ret = fileChooser.showDialog(null, "Открыть");
            if (ret == JFileChooser.APPROVE_OPTION){
                File q = fileChooser.getSelectedFile();
                StringBuilder sb = new StringBuilder();
                String line;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(q));
                    while ((line = reader.readLine()) != null){
                        sb.append(line);
                        sb.append("\n");
                    }
                    showDialog = new FileShowDialog();
                    showDialog.setText(sb.toString());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        choiseButton.addActionListener(e -> {
            Color color = JColorChooser.showDialog(this, "Выберете цвет", Color.BLACK);
            list.setSelectedIndex(listItemNums.getSelectedIndex());
            list.setSelectionBackground(color);
        });

        doThat.addActionListener(e -> {
            list.setCellRenderer(lcr);
            list.updateUI();
        });


        JPanel northPanel = new JPanel(new BorderLayout());

        JPanel westSide = new JPanel(new FlowLayout(FlowLayout.CENTER));
        westSide.setPreferredSize(new Dimension(400, 350));
        westSide.setMaximumSize(new Dimension(400, 350));
        westSide.add(catName);
        westSide.add(rowQuantity);
        westSide.add(colQuantity);
        westSide.add(okButton);
        westSide.add(scrollPane);

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

        eastSide.add(chooseFont);
        eastSide.add(sDialogBtn);
        eastSide.add(fontChooser);

        eastSide.add(chooseFile);
        eastSide.add(openFile);

        northPanel.add(westSide, "West");
        northPanel.add(eastSide, "East");

        JPanel southPanel = new JPanel(new BorderLayout());

        JPanel sWestSide = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sWestSide.setPreferredSize(new Dimension(300, 220));
        sWestSide.setMaximumSize(new Dimension(300, 220));
        sWestSide.add(listManipulations);
        sWestSide.add(listScrollPane);

        JPanel sCenter = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sCenter.setPreferredSize(new Dimension(250, 220));
        sCenter.setMaximumSize(new Dimension(250,220));
        sCenter.add(setColor);
        sCenter.add(listItemNums);
        sCenter.add(choiseButton);

        JPanel sEastSide = new JPanel(new FlowLayout((FlowLayout.CENTER)));
        sEastSide.setPreferredSize(new Dimension(250, 220));
        sEastSide.setMaximumSize(new Dimension(250,220));
        sEastSide.add(setMoreFive);
        sEastSide.add(doThat);

        southPanel.add(sWestSide, "West");
        southPanel.add(sCenter, "Center");
        southPanel.add(sEastSide, "East");

        Container container = getContentPane();
        container.add(northPanel, "North");
        container.add(southPanel, "South");

        pack();
        setVisible(true);
    }

    public static void main(String[] args) throws IOException, FontFormatException {
        new MainFrame();
    }

}
