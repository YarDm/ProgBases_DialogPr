public class FillForm {

//    FillForm(){
//        JFrame frame = new JFrame();
//        frame.setLocation(450, 50);
//        frame.setPreferredSize(new Dimension(400,500));
//
//        var fillId = new JLabel("Настройки заполнения созданной таблицы");
//        fillId.setPreferredSize(new Dimension(370, 25));
//        fillId.setHorizontalAlignment(SwingConstants.CENTER);
//        fillId.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
//        var randFill = new JLabel("Заоплнение рандомными значениями из диапазона:");
//        randFill.setPreferredSize(new Dimension(370, 15));
//        randFill.setHorizontalAlignment(SwingConstants.CENTER);
//        var fromField = new JTextField();
//        fromField.setPreferredSize(new Dimension(60,35));
//        var t = new JLabel("-");
//        t.setHorizontalAlignment(SwingConstants.CENTER);
//        t.setPreferredSize(new Dimension(60,35));
//        var toField = new JTextField();
//        toField.setPreferredSize(new Dimension(60,35));
//        var fillButton = new JButton("Fill");
//        fillButton.setPreferredSize(new Dimension(60,35));
//        fillButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int fromDigit = Integer.parseInt(fromField.getText());
//                int toDigit = Integer.parseInt(toField.getText());
//                RandomFill rf = new RandomFill();
//                TableData data = MainFrame.td;
//                data.setRandMin(fromDigit);
//                data.setRandMin(toDigit);
//TODO: придумать как заполнить данными таблицу.
// Скорее всего нужно сделать статический метод в MainFrame, который будет вызываться отсюда.
//                int[] i = rf.rndFill();
//                for (int k : i) {
//                    System.out.print(k + " ");

//                }
//            }
//        });

//        Container container = frame.getContentPane();
//        container.setLayout(new FlowLayout(FlowLayout.CENTER));
//        container.add(fillId);
//        container.add(randFill);
//        container.add(fromField);
//        container.add(t);
//        container.add(toField);
//        container.add(fillButton);
//
//        frame.pack();
//        frame.setVisible(true);
//
//    }
//
}
